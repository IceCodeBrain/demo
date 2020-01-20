package com.example.demo.boot.uitls;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description: ArabicNumToChineseNumUtil <br>
 * @date: 2020/1/7 16:06 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public class ArabicNumToChineseNumU {

    /**
     * 单位进位，中文默认为4位即（万、亿）
     */
    public static final int UNIT_STEP = 4;

    /**
     * 单位
     */
    public static final String[] CN_UNITS = new String[]{"个", "十", "百", "千", "万", "十",
            "百", "千", "亿", "十", "百", "千", "万"};

    /**
     * 汉字
     */
    public static final String[] CN_CHARS = new String[]{"零", "一", "二", "三", "四",
            "五", "六", "七", "八", "九"};


    /**
     * @param srcNum 需要转换的数值 <br>
     * @return java.lang.String <br>
     * @description: getCNNum 将阿拉伯数字转换为中文数字123=》一二三 <br>
     * @version: 1.0 <br>
     * @date: 2020/1/8 9:41 <br>
     */
    public static String getCNNum(int srcNum) {
        StringBuilder desCNNum = new StringBuilder();

        if (srcNum <= 0)
            desCNNum = new StringBuilder("零");
        else {
            int singleDigit;
            while (srcNum > 0) {
                singleDigit = srcNum % 10;
                desCNNum.insert(0, CN_CHARS[singleDigit]);
                srcNum /= 10;
            }
        }
        return desCNNum.toString();
    }


    /**
     * @param num 需要转换的数值 <br>
     * @return java.lang.String <br>
     * @description: cvt  数值转换为中文字符串 如2转化为贰 <br>
     * @version: 1.0 <br>
     * @date: 2020/1/8 9:38 <br>
     */
    public static String cvt(long num) {
        return cvt(num, false);
    }


    /**
     * @param num          需要转换的数值
     * @param isColloquial 是否口语化。例如12转换为'十二'而不是'一十二' <br>
     * @return java.lang.String <br>
     * @description: cvt  数值转换为中文字符串(口语化) <br>
     * @version: 1.0 <br>
     * @date: 2020/1/8 9:38 <br>
     */
    public static String cvt(String num, boolean isColloquial) {
        int integer, decimal;
        StringBuilder stringBuilder = new StringBuilder(32);
        String[] splitNum = num.split("\\.");
        integer = Integer.parseInt(splitNum[0]);    //整数部分
        decimal = Integer.parseInt(splitNum[1]);    //小数部分
        String[] result_1 = convert(integer, isColloquial);
        for (String str1 : result_1)
            stringBuilder.append(str1);
        if (decimal == 0) {//小数部分为0时
            return stringBuilder.toString();
        }
        String result_2 = getCNNum(decimal);  //例如5.32，小数部分展示三二，而不是三十二
        stringBuilder.append("点");
        stringBuilder.append(result_2);
        return stringBuilder.toString();

    }

    /**
     * @param num          需要转换的数值
     * @param isColloquial 是否口语化。例如12转换为'十二'而不是'一十二' <br>
     * @return java.lang.String <br>
     * @description: cvt 对于int,long类型的数据处理 <br>
     * @version: 1.0 <br>
     * @date: 2020/1/8 9:39 <br>
     */
    public static String cvt(long num, boolean isColloquial) {
        String[] result = convert(num, isColloquial);
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str : result) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }


    /**
     * @param num          需要转换的数值
     * @param isColloquial 是否口语化。例如12转换为'十二'而不是'一十二'。 <br>
     * @return java.lang.String[] <br>
     * @description: convert  将数值转换为中文 <br>
     * @version: 1.0 <br>
     * @date: 2020/1/8 9:40 <br>
     */
    public static String[] convert(long num, boolean isColloquial) {
        if (num < 10) {// 10以下直接返回对应汉字
            return new String[]{CN_CHARS[(int) num]};// ASCII2int
        }

        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length > CN_UNITS.length) {// 超过单位表示范围的返回空
            return new String[]{};
        }

        boolean isLastUnitStep = false;// 记录上次单位进位
        ArrayList<String> cnChars = new ArrayList<>(chars.length * 2);// 创建数组，将数字填入单位对应的位置
        for (int pos = chars.length - 1; pos >= 0; pos--) {// 从低位向高位循环
            char ch = chars[pos];
            String cnChar = CN_CHARS[ch - '0'];// ascii2int 汉字
            int unitPos = chars.length - pos - 1;// 对应的单位坐标
            String cnUnit = CN_UNITS[unitPos];// 单位
            boolean isZero = (ch == '0');// 是否为0
            boolean isZeroLow = (pos + 1 < chars.length && chars[pos + 1] == '0');// 是否低位为0

            boolean isUnitStep = (unitPos >= UNIT_STEP && (unitPos % UNIT_STEP == 0));// 当前位是否需要单位进位

            if (isUnitStep && isLastUnitStep) {// 去除相邻的上一个单位进位
                int size = cnChars.size();
                cnChars.remove(size - 1);
                if (!CN_CHARS[0].equals(cnChars.get(size - 2))) {// 补0
                    cnChars.add(CN_CHARS[0]);
                }
            }

            if (isUnitStep || !isZero) {// 单位进位(万、亿)，或者非0时加上单位
                cnChars.add(cnUnit);
                isLastUnitStep = isUnitStep;
            }
            if (isZero && (isZeroLow || isUnitStep)) {// 当前位为0低位为0，或者当前位为0并且为单位进位时进行省略
                continue;
            }
            cnChars.add(cnChar);
            isLastUnitStep = false;
        }

        Collections.reverse(cnChars);
        // 清除最后一位的0
        int chSize = cnChars.size();
        String chEnd = cnChars.get(chSize - 1);
        if (CN_CHARS[0].equals(chEnd) || CN_UNITS[0].equals(chEnd)) {
            cnChars.remove(chSize - 1);
        }

        // 口语化处理
        if (isColloquial) {
            String chFirst = cnChars.get(0);
            String chSecond = cnChars.get(1);
            if (chFirst.equals(CN_CHARS[1]) && chSecond.startsWith(CN_UNITS[1])) {// 是否以'一'开头，紧跟'十'
                cnChars.remove(0);
            }
        }
        return cnChars.toArray(new String[]{});
    }


    /**
     * @param chineseStr 字符串 <br>
     * @return boolean <br>
     * @description: isChineseNum 判断传入的字符串是否全是汉字数字 <br>
     * @version: 1.0 <br>
     * @date: 2020/1/7 16:19 <br>
     */
    public static boolean isChineseNum(String chineseStr) {
        final String allChineseNum = "零一二三四五六七八九十百千万亿";
        char[] ch = chineseStr.toCharArray();
        for (char c : ch) {
            if (!allChineseNum.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param str 待验证的字符串 <br>
     * @return boolean <br>
     * @description: isNum  判断数字字符串是否是整数字符串 <br>
     * @version: 1.0 <br>
     * @date: 2020/1/7 16:20 <br>
     */
    public static boolean isNum(String str) {
        String reg = "[0-9]+";
        return str.matches(reg);
    }
}
