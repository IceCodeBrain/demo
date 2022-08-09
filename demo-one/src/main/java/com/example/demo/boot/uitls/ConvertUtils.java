package com.example.demo.boot.uitls;


import com.example.demo.boot.restful.CommonException;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 用于将一个对象转换为另一个对象等操作
 */
public final class ConvertUtils {

    private ConvertUtils() {
    }

    //region [处理几种类型的数据，发生错误时返回默认数据等操作]

    public static String getStringValue(String s) {
        return s == null ? "" : s;

    }

    public static String getStringValue(Object s) {
        return s == null ? "" : s.toString();
    }


    /**
     * 这里主要用来验证代表的状态值或等级等，要求大于-1，不能为null
     */
    public static Boolean judgeIntegerValue(Integer v) {
        if (v != null) {
            return v > -1;
        }
        return false;
    }

    /**
     * 这里主要用来获取代表的状态值或等级等，最小为0
     */
    public static Integer getIntegerValue(Integer v) {
        if (v != null) {
            if (v > -1) {
                return v;
            }
        }
        return 0;
    }

    /**
     * 这里主要用来验证代表值常量的判断，要求大于0，不能为null
     */
    public static Boolean judgeIntegerKey(Integer v) {
        return getIntValue(v) > 0;
    }

    public static Integer getIntValue(Integer v) {
        return getIntValue(v, -1);
    }

    public static Integer getIntValue(Integer v, int def) {
        if (v != null && !v.equals(0)) {
            return v;
        } else {
            return def;
        }
    }

    public static int getIntValue(String v) {
        return getIntValue(v, -1);
    }

    public static int getIntValue(String v, int def) {
        try {
            return Integer.parseInt(v);
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 这里主要用来验证是不是自增ID，要求大于0，不能为null
     */
    public static Boolean judgeLongKey(Long v) {
        return getLongValue(v) > 0;
    }

    public static Long getLongValue(Long v) {
        return getLongValue(v, -1L);
    }

    public static Long getLongValue(Long v, Long def) {
        if (v != null && !v.equals(0L)) {
            return v;
        } else {
            return def;
        }
    }

    public static Long getLongValue(String v) {
        return getLongValue(v, -1L);
    }

    public static Long getLongValue(String v, Long def) {
        try {
            return Long.parseLong(v);
        } catch (Exception ex) {
            return def;
        }
    }

    public static Float getFloatValue(String v) {
        return getFloatValue(v, 0);
    }

    public static Float getFloatValue(String v, float def) {
        try {
            return Float.parseFloat(v);
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 返回保留2位数的数据
     *
     * @param v 值
     */
    public static Double getDoubleRetain(Double v) {
        return getDoubleRetain(v, 2);
    }

    /**
     * 返回指定保留位数的数据
     *
     * @param v   值
     * @param num 位数
     */
    public static Double getDoubleRetain(Double v, int num) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num; i++) {
            s.append("0");
        }
        DecimalFormat df = new DecimalFormat("#." + s);
        return getDoubleValue(df.format(v));
    }

    public static Double getDoubleValue(String v) {
        return getDoubleValue(v, 0);
    }

    public static Double getDoubleValue(String v, double def) {
        try {
            return Double.parseDouble(v);
        } catch (Exception ex) {
            return def;
        }
    }

    //region [BigDecimal操作]

    /**
     * 判断是否v1是否大于v2
     *
     * @param v1 原始值
     * @param v2 待比值
     */
    public static Boolean judgeBigDecimalBig(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2) > 0;
    }

    /**
     * 判断是否v1是否小于v2
     *
     * @param v1 原始值
     * @param v2 待比值
     */
    public static Boolean judgeBigDecimalSmall(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2) < 0;
    }

    /**
     * 判断是否v1是否等于v2
     *
     * @param v1 原始值
     * @param v2 待比值
     */
    public static Boolean judgeBigDecimalEqual(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2) == 0;
    }

    /**
     * 返回相加数据
     *
     * @param v1 原始值
     * @param v2 待加值
     */
    public static BigDecimal getBigDecimalAdd(BigDecimal v1, BigDecimal v2) {
        return v1.add(v2);
    }

    /**
     * 返回相减数据
     *
     * @param v1 原始值
     * @param v2 待减值
     */
    public static BigDecimal getBigDecimalSubtract(BigDecimal v1, BigDecimal v2) {
        return v1.subtract(v2);
    }

    /**
     * 返回相乘数据
     *
     * @param v1  原始值
     * @param v2  待乘值
     * @param num 保留位数
     */
    public static BigDecimal getBigDecimalMultiply(BigDecimal v1, BigDecimal v2, int num) {
        return getBigDecimalRetain(v1.multiply(v2), num);
    }

    /**
     * 返回相除数据
     *
     * @param v1  被除数
     * @param v2  除数
     * @param num 保留位数
     */
    public static BigDecimal getBigDecimalDivide(BigDecimal v1, BigDecimal v2, int num) {
        return v1.divide(v2, num, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 返回保留2位数的四舍五入数据
     *
     * @param v 值
     */
    public static BigDecimal getBigDecimalRetain(BigDecimal v) {
        return getBigDecimalRetain(v, 2);
    }

    /**
     * 返回指定保留位数的四舍五入数据
     *
     * @param v   值
     * @param num 位数
     */
    public static BigDecimal getBigDecimalRetain(BigDecimal v, int num) {
        return getBigDecimalValue(v).setScale(num, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 返回截取2位数的数据【不四舍五入】
     *
     * @param v 值
     */
    public static BigDecimal getBigDecimalIntercept(BigDecimal v) {
        return getBigDecimalIntercept(v, 2);
    }

    /**
     * 返回指定截取位数的数据【不四舍五入】
     *
     * @param v   值
     * @param num 位数
     */
    public static BigDecimal getBigDecimalIntercept(BigDecimal v, int num) {
        return getBigDecimalValue(v).setScale(num, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal getBigDecimalValue(BigDecimal v) {
        return getBigDecimalValue(v, "0");
    }

    public static BigDecimal getBigDecimalValue(BigDecimal v, String def) {
        if (v != null) {
            return v;
        } else {
            return new BigDecimal(def);
        }
    }
    //endregion

    public static String getFormatDate(Date v) {
        return getFormatDate(v, "");
    }

    public static String getFormatDate(Date v, String format) {
        try {
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(v);
        } catch (Exception ex) {
            throw new CommonException(ex.getMessage());
        }
    }

    //endregion

    //region [对时间进行相应的处理]

    //获取当前月份加指定月数的月份第一天
    public static String getFirstDayOfMonth(int month) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, month);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    //获取当前月份的第一天
    public static String getFirstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    //获取给定日期月份的第一天
    public static String getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    //获取当前月份加指定月数的月份最后一天：
    public static String getLastDayOfMonth(int month) {
        //获取当前月最后一天
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    //获取当前月最后一天：
    public static String getLastDayOfMonth() {
        //获取当前月最后一天
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    //获取给定日期月份最后一天：
    public static String getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 得到加N周后的周一
     *
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfWeek(int week) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.WEEK_OF_MONTH, week);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        System.out.println(c.getTime());
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        System.out.println(c.getTime());
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 得到给定日期的周一
     *
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        System.out.println(c.getTime());
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 得到加N周后的周日
     *
     * @return yyyy-MM-dd
     */
    public static String getLastDayOfWeek(int week) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.WEEK_OF_MONTH, week);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 7);
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static String getLastDayOfWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 7);
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 得到给定日期的周日
     *
     * @return yyyy-MM-dd
     */
    public static String getLastDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 7);
        return getFormatDate(c.getTime(), "yyyy-MM-dd");
    }

    /**
     * 获取给定日期是星期几
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static int getWeekOfDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int w = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (w <= 0) {
            w = 7;
        }
        return w;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static Integer daysBetween(Date smdate, Date bdate) throws ParseException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }

    }

    /**
     * 计算两个日期之间相差的分钟
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差分钟数
     */
    public static Integer minuteBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_minute = (time2 - time1) / (1000 * 60);
            return Integer.parseInt(String.valueOf(between_minute));
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }

    }

    /**
     * 计算两个日期之间相差的秒钟
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相秒钟数
     */
    public static Integer secondBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_Between = (time2 - time1) / 1000;
            return Integer.parseInt(String.valueOf(between_Between));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回只有年月日的时间格式
    public static Date getString2Date(String strDate) {
        return getString2Date(strDate, "yyyy-MM-dd");
    }

    //返回相应格式的时间
    public static Date getString2Date(String strDate, String format) {
        Date date;
        try {
            date = new SimpleDateFormat(format).parse(strDate);
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
        return date;
    }

    /**
     * 将指定的年月日加上相应的数字后返回新的时间
     *
     * @param date  – 日期
     * @param type  – 加减类型 y年m月d日 h小时mm分s秒
     * @param value – 加上的数值 如果为负数，则为减去
     * @return 返回增加后的Date
     */
    public static Date dateAdd(Date date, String type, int value) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if ("d".equals(type)) {
                //日期加减N天
                cal.add(Calendar.DAY_OF_YEAR, value);
            } else if ("m".equals(type)) {
                //日期加减N个月
                cal.add(Calendar.MONTH, value);
            } else if ("y".equals(type)) {
                //日期加减N年
                cal.add(Calendar.YEAR, value);
            } else if ("h".equals(type)) {
                //日期加减小时
                cal.add(Calendar.HOUR, value);
            } else if ("mm".equals(type)) {
                //日期加减分钟
                cal.add(Calendar.MINUTE, value);
            } else if ("s".equals(type)) {
                //日期加减秒
                cal.add(Calendar.SECOND, value);
            }
            return cal.getTime();
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }

    }

    //endregion

    //region [对文本的一些转换处理操作]

    /**
     * 去除编辑器文本格式
     *
     * @param str 要操作的文本
     */
    public static String removeFormat(String str) {
        String inStr = str;
        if (!getStringValue(str).trim().equals("")) {
            inStr = str.replaceAll("</?[^>]+>", "");
        }
        return inStr;
    }

    /**
     * 将字符串格式化成HTML代码
     *
     * @param str 要格式化的字符串
     */
    public static String textToHtml(String str) {
        String inStr = str;
        if (!getStringValue(str).trim().equals("")) {
            inStr = inStr.replace("&", "&amp;");
            inStr = inStr.replace("<", "&lt;");
            inStr = inStr.replace(">", "&gt;");
            inStr = inStr.replace("\r\n", "<br>");
            inStr = inStr.replace("\n", "<br>");
            inStr = inStr.replace("\t", " ");
            inStr = inStr.replace(" ", "&nbsp;");
        }
        return inStr;
    }

    /**
     * 将HTML代码转化成文本格式
     *
     * @param str 要格式化的字符串
     */
    public static String htmlToText(String str) {
        String inStr = str;
        if (!getStringValue(str).trim().equals("")) {
            inStr = inStr.replace("&nbsp;", " ");
            inStr = inStr.replace("<br>", "\r\n");
            inStr = inStr.replace("&lt;", "<");
            inStr = inStr.replace("&gt;", ">");
            inStr = inStr.replace("&amp;", "&");
        }
        return inStr;
    }

    /**
     * 截取规定字符数字符串，必须保证str不等于null(如果字符串含有html代码先转成文本再截取)
     *
     * @param str  原是字符串
     * @param num  规定的长度
     * @param spot 是否加省略点...
     */
    public static String subStringNumber(String str, int num, Boolean spot) {
        String strSpot = spot ? "..." : "";
        String stur = removeFormat(str).trim();
        if (stur.length() > num) {
            stur = stur.substring(0, num) + strSpot;
        }
        return stur;
    }

    /**
     * 截取规定字节数字符串，必须保证str不等于null(如果字符串含有html代码先转成文本再截取)
     *
     * @param str  原是字符串
     * @param num  规定的字节长度
     * @param spot 是否加省略点...
     */
    public static String subStringBytes(String str, int num, Boolean spot) {
        String strSpot = spot ? "..." : "";
        String stur = removeFormat(str).trim();
        byte[] bytes = stur.getBytes();
        if (bytes.length > num) {
            for (int i = 1; i <= stur.length(); i++) {
                //这里已经处理掉了如截取6个字节“abcde薛”这种情况
                byte[] bytesFor = stur.trim().substring(0, i).getBytes();
                //如果当前截取的字符串字节数大于了要求的字节数，那取上一次截取的值
                if (bytesFor.length > num) {
                    stur = stur.substring(0, (i - 1)) + strSpot;
                    return stur;
                }
            }
        }
        return stur;
    }

    /**
     * 将字符串一部分隐藏为规定个数的“*”号，begin大于或等于字符长度返回原字符串
     *
     * @param str   要处理的字符串
     * @param begin 显示几个字符后开始隐藏
     * @param num   隐藏为“*”的字符数量
     */
    public static String replaceStr(String str, int begin, int num) {
        String inStr = getStringValue(str).trim();
        StringBuilder retStr = new StringBuilder();
        if (inStr.length() >= (begin + num)) {
            retStr.append(inStr, 0, begin);
            for (int i = 0; i < num; i++) {
                retStr.append("*");
            }
            retStr.append(inStr.substring(begin + num));
        } else {
            if (inStr.length() > begin) {
                retStr.append(inStr, 0, begin);
                for (int i = 0; i < inStr.length() - begin; i++) {
                    retStr.append("*");
                }
            } else {
                return inStr;
            }
        }
        return retStr.toString();
    }


    /**
     * 给字符串Base64编码并替换相应的字符
     *
     * @param text 要编码的字符串n
     */
    public static String encoderString(String text) throws Exception {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(text.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }

    }

    /**
     * 给字Base64符串解码【有时密文的“+”号会被转为空格，里面要处理下】
     *
     * @param text 要解码的字符串
     */
    public static String decodeString(String text) throws Exception {
        try {
            return new String(Base64.getDecoder().decode(text.replaceAll(" ", "+")));
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
    }


    //UTF-8+BOM编码转化为普通的UTF-8编码
    public static String replaceUTF8Bom(String str) {
        return str.replace("\uFEFF", "");
    }

    /**
     * 特殊符号转码 utf-8
     */
    public static String encodeUrlComponent(String str) {
        String result = null;

        try {
            result = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            result = str;
        }
        return result;
    }

    /**
     * 解码 utf-8
     */
    public static String decoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }

    /**
     * 加上http协议
     */
    public static String httpStr(String url) {
        if (url.startsWith("http:") || url.startsWith("https:")) {
            return url;
        }
        return "http:" + url;
    }

    /**
     * 用于维易淘获取优惠卷金额。【格式都是“满xx元减xx元】
     */
    public static String splitMoney(String str) {
        String s = str.split("元")[1];
        return s.replace("减", "");
    }

    /**
     * 获取图片，格式：<img size=790x1178>//**.jpg</img>
     */
    public static String splitImage(String str) {
        String img = null;
        Pattern compile = Pattern.compile("//.*.</img>");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            img = matcher.group();
        }
        if (img == null) {
            return null;
        }
        return img.replace("</img>", "");
    }

    /**
     * 拼多多的累计销量是字符串格式，格式其中为 "10万"
     */
    public static Integer splitSales(String volume) {
        volume = volume.replaceAll("\\+", "");
        if (volume.contains("万")) {
            String str = volume.split("万")[0];
            float number = (Float.parseFloat(str) * 10000);
            return (int) number;
        }
        return Integer.valueOf(volume);
    }


    /**
     * 返回随机N位整数
     */
    public static int getRandomNumber(int num) {
        if (num <= 0) {
            num = 1;
        }
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            code.append(random.nextInt(10));
        }
        return Integer.parseInt(code.toString());
    }

    /**
     * 正则验证
     *
     * @param rgx 表达式
     * @param res 值
     */
    public static boolean isCorrect(String rgx, String res) {
        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(res);
        return m.matches();
    }

    /**
     * 验证手机号码
     *
     * @param number 手机号
     */
    public static boolean phoneJudge(String number) {
        String rgx = "^((13[0-9])|(15[0-9])|(18[0-9])|(19[0-9])|(17[0-9]))\\d{8}$";
        return isCorrect(rgx, number);
    }

    /**
     * 验证身份证号码
     *
     * @param number 身份证
     */
    public static boolean idCardJudge(String number) {
        String rgx = "^\\d{15}|^\\d{17}([0-9]|X|x)$";
        return isCorrect(rgx, number);
    }

    /**
     * 验证护照号码
     *
     * @param number 护照
     */
    public static boolean passportJudge(String number) {
        String rgx1 = "^[a-zA-Z]{5,17}$";
        String rgx2 = "^[a-zA-Z0-9]{5,17}$";
        return (isCorrect(rgx1, number) || isCorrect(rgx2, number));
    }
}
