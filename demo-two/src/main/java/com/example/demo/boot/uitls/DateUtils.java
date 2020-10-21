package com.example.demo.boot.uitls;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static String YYYY = "yyyy";

    public static String MIN = "min";

    public static String MAX = "max";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYYMM = "yyyyMM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYY_MM_01 = "yyyy-MM-01";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String CN_YYYY_MM_DD_HH_MM = "yyyy年MM月dd日 HH:mm";

    public static String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";

    public static String HH_MM_SS = "HH-mm-ss";

    public static String MM_DD_HH_MM = "MM-dd HH:mm";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    /**
     * 获取当前日期, 默认格式为MM-dd HH:mm
     *
     * @return String
     */
    public static String getMDHMDate() {
        return dateTimeNow(MM_DD_HH_MM);
    }

    /**
     * 获取当前日期, 默认格式为MM-dd HH:mm
     *
     * @return String
     */
    public static String getMDHMDate(Date date) {
        return dateTimeNow(MM_DD_HH_MM, date);
    }


    public static String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static String dateTimeNow(final String format, Date date) {
        return parseDateToStr(format, date);
    }

    public static String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }


    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / MILLIS_PER_DAY;
        // 计算差多少小时
        long hour = diff % MILLIS_PER_DAY / MILLIS_PER_HOUR;
        // 计算差多少分钟
        long min = diff % MILLIS_PER_DAY % MILLIS_PER_HOUR / MILLIS_PER_MINUTE;
        // 计算差多少秒//输出结果
        long sec = diff % MILLIS_PER_DAY % MILLIS_PER_HOUR % MILLIS_PER_MINUTE / MILLIS_PER_SECOND;
        return String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
    }


    //计算两个时间的时间差 并转为白话文
    public static String doTransformDate(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            return null;
        }
        long diff = endDate.getTime() - beginDate.getTime();
        if (diff < 0) {
            return null;
        }
        // 计算差多少天
        long day = diff / MILLIS_PER_DAY;
        // 计算差多少小时
        long hour = diff % MILLIS_PER_DAY / MILLIS_PER_HOUR;
        // 计算差多少分钟
        long min = diff % MILLIS_PER_DAY % MILLIS_PER_HOUR / MILLIS_PER_MINUTE;
        // 计算差多少秒//输出结果
        // long sec = diff % MILLIS_PER_DAY % MILLIS_PER_HOUR % MILLIS_PER_MINUTE / MILLIS_PER_SECOND;
        if (day == 0 && hour == 0) {
            return min + "分钟";
        }
        if (day == 0) {
            return hour + "小时" + min + "分钟";
        }
        return day + "天" + hour + "小时" + min + "分钟";
    }
    /**
     * 获取两个时间之间的年月
     */
    public static List<Date> getYearMonth(Date start, Date end) {
        List<Date> list = new ArrayList<>();
        //格式化为年月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(start);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(end);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        while (min.before(max)) {
            list.add(min.getTime());
            min.add(Calendar.MONTH, 1);
        }
        return list;
    }


    public static List<String> getSevenDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date endDate = calendar.getTime();
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 6);
        Date startDate = calendar.getTime();
        List<Date> dates = findDates(startDate, endDate);
        List<String> result = new ArrayList<>();
        for (Date d : dates) {
            result.add(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, d));
        }
        return result;
    }


    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    /**
     * 根据当前日，加减日期
     *
     * @param day 日期 正数为+ ，负数为减
     * @return 计算后的日期字符串 年月日 yyyy-MM-dd
     */
    public static String getCalculateDay(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        cal.add(Calendar.DATE, day);
        Date d = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat(YYYY_MM_DD);
        sp.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sp.format(d);
    }


    /**
     * 时间戳转秒
     */
    public static Long getSeconds(Long Millisecond) {
        double k = Math.round(Millisecond * 1.0 / 1000L);
        double result = (int) Math.rint(k);
        String str = new BigDecimal(result + "").toString();
        return Long.valueOf(str);
    }

    public static Date getBeginTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 0);
        todayEnd.set(Calendar.MINUTE, 0);
        todayEnd.set(Calendar.SECOND, 0);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }


    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 判断是否超过多少小时 如：24
     *
     * @param tableTime 业务时间
     * @param hour      多少小时
     */
    public static boolean judgmentDate(long tableTime, double hour) {
        Date start = new Date(tableTime);
        //业务时间
        Date end = new Date();//当前时间
        long cha = end.getTime() - start.getTime();
        if (cha < 0) {
            return false;
        }
        double result = cha * 1.0 / (1000 * 60 * 60);
        return result <= hour;//是小于等于 hour 小时
    }


    /**
     * 获取精确到秒的时间戳
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.parseInt(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }


    /**
     * @param date 指定日期 <br>
     * @return boolean <br>
     * @description: 判断某个日期 是否 是今日 <br>
     * @since: 1.0 <br>
     * @date: 2020/7/10 10:16 <br>
     * @author: PWB <br>
     */
    public static boolean isToday(Date date) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String todayStr = sdf.format(now);
        return todayStr.equals(sdf.format(date));
    }

    //yesterday
    public static boolean isYesterday(Date date) {
        Date yesterday = addDays(new Date(), -1);
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String yesterdayStr = sdf.format(yesterday);
        return yesterdayStr.equals(sdf.format(date));
    }

    /**
     * 通过long/1000 获取时间格式
     *
     * @return 计算后的日期字符串 YYYY_MM_DD_HH_MM_SS
     */
    public static String getDateStrByInt(int millions) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        cal.setTimeInMillis((long) millions * 1000);
        Date d = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        sp.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sp.format(d);
    }


    /**
     * 获取当前时间的最大值贺最小值
     *
     * @param millions 当前时间
     * @param patterns min 和 max
     */
    public static int getIntStrByPatterns(int millions, String patterns) {
        if (millions <= 0) {
            return 0;
        }
        Date strtodate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            cal.setTimeInMillis((long) millions * 1000);
            String formatDate = format.format(cal.getTime());
            if ("min".equals(patterns)) {
                cal.setTime(format.parse(formatDate));
                cal.add(Calendar.DAY_OF_YEAR, 0);
                strtodate = new Date(cal.getTime().getTime() + 1);
            }
            if ("max".equals(patterns)) {
                cal.setTime(format.parse(formatDate));
                cal.add(Calendar.DAY_OF_YEAR, 1);
                strtodate = new Date(cal.getTime().getTime() - 1);
            }
        } catch (ParseException e) {
            return 0;
        }
        if (strtodate == null) {
            return 0;
        }
        return (int) (strtodate.getTime() / 1000);
    }



    /**
     * 获取当月最后一天最大值
     */
    public static int getMonLastDay(int millions) {
        if (millions <= 0) {
            return 0;
        }
        Date strtodate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calast = Calendar.getInstance();
            calast.setTimeInMillis((long) millions * 1000);
            String formatDate = format.format(calast.getTime());
            calast.setTime(format.parse(formatDate));
            calast.set(Calendar.DAY_OF_MONTH, calast.getActualMaximum(Calendar.DAY_OF_MONTH));
            calast.add(Calendar.DAY_OF_YEAR, 1);
            strtodate = new Date(calast.getTime().getTime() - 1);
        } catch (ParseException e) {
            return 0;
        }
        return (int) (strtodate.getTime() / 1000);
    }


    /**
     * 获取当前时间格式化
     *
     * @param millions 时间int
     * @return
     */
    public static int getIntGSH(int millions, String parent) {
        if (millions <= 0) {
            return 0;
        }
        Date strtodate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(parent);
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            cal.setTimeInMillis((long) millions * 1000);
            String formatDate = format.format(cal.getTime());
            cal.setTime(format.parse(formatDate));
            strtodate = new Date(cal.getTime().getTime());

        } catch (ParseException e) {
            return 0;
        }
        return (int) (strtodate.getTime() / 1000);
    }


    /**
     * 获取YYYYMMinter类型数据
     *
     * @return 计算后的日期字符串 YYYYMM
     */
    public static Integer getYYYYMMIntByInt(int millions) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        cal.setTimeInMillis((long) millions * 1000);
        Date d = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat(YYYYMM);
        sp.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return Integer.parseInt(sp.format(d));
    }


}
