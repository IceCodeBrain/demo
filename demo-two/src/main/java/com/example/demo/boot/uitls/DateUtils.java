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

    public static List<String> dayTime = new ArrayList() {{
        add("00");
        add("01");
        add("02");
        add("03");
        add("04");
        add("05");
        add("06");
        add("07");
        add("08");
        add("09");
        add("10");
        add("11");
        add("12");
        add("13");
        add("14");
        add("15");
        add("16");
        add("17");
        add("18");
        add("19");
        add("20");
        add("21");
        add("22");
        add("23");
    }};

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

    public static String HH_MM_SS = "HH-mm";

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


    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTimeNow(final String format, Date date) {
        return parseDateToStr(format, date);
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
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
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }


    /**
     * 计算两个时间差
     */
    public static String getDatePoorLive(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        return String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
    }

    public static String getDatePoorLive(long endDate, long nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate - nowDate;
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        return String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
    }

    /**
     * 计算两个时间差,获取分钟数
     */
    public static long getDatePoorMin(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return min;
    }


    //计算两个时间的时间差 并转为白话文
    public static String doTransformDate(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            return null;
        }
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - beginDate.getTime();
        if (diff < 0) {
            return null;
        }
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        if (day == 0 && hour == 0) {
            return min + "分钟";
        }
        if (day == 0) {
            return hour + "小时" + min + "分钟";
        }
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 给时间加上几个小时
     *
     * @param hour 需要加的时间
     * @return
     */
    public static Date addDateHOUR(int hour) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    public static Date addDateHOUR(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    public static Date addDateMINUTE(Date date, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);// 24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    /**
     * 给指定时间加上几秒钟
     *
     * @param second 需要加的时间
     * @return
     */
    public static Date addDateSECOND(Date date, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);// 24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    /**
     * 获取两个时间之间的年月
     *
     * @param start
     * @param end
     * @return
     * @throws
     * @author hq
     * @date 2019/12/2 19:00
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

        Calendar curr = min;
        while (curr.before(max)) {
            list.add(curr.getTime());
            curr.add(Calendar.MONTH, 1);
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
        List lDate = new ArrayList();
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
//    public static void main(String[] args) {
//        long day=8;
//        String str = String.format("%02d", day);
//        System.out.println(str); // 0001
//    }

    /**
     * 时间戳转秒
     *
     * @param Millisecond
     * @return
     */
    public static Long getSeconds(Long Millisecond) {
        double k = Math.round(Millisecond * 1.0 / 1000L);
        double result = (int) Math.rint(k);
        String str = new BigDecimal(result + "").toString();
        Long result1 = Long.valueOf(str);
        return result1;
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
     * @return boolean
     * @throws Exception
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
     *
     * @return
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }


    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
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
        cal.setTimeInMillis(new Long(millions).longValue() * 1000);
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
     * @return
     * @throws ParseException
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
            cal.setTimeInMillis(new Long(millions).longValue() * 1000);
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
     * 获取当前时间加天的时间
     *
     * @param millions 时间int
     * @param day      天数
     * @return
     */
    public static int getIntAddDay(int millions, int day) {
        if (millions <= 0) {
            return 0;
        }
        Date strtodate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            cal.setTimeInMillis(new Long(millions).longValue() * 1000);
            String formatDate = format.format(cal.getTime());
            cal.setTime(format.parse(formatDate));
            cal.add(Calendar.DAY_OF_YEAR, day);
            strtodate = new Date(cal.getTime().getTime());

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
     *
     * @param millions
     * @return
     * @throws ParseException
     */
    public static int getMonLastDay(int millions) {
        if (millions <= 0) {
            return 0;
        }
        Date strtodate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calast = Calendar.getInstance();
            calast.setTimeInMillis(new Long(millions).longValue() * 1000);
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
            cal.setTimeInMillis(new Long(millions).longValue() * 1000);
            String formatDate = format.format(cal.getTime());
            cal.setTime(format.parse(formatDate));
            strtodate = new Date(cal.getTime().getTime());

        } catch (ParseException e) {
            return 0;
        }
        if (strtodate == null) {
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
        cal.setTimeInMillis(new Long(millions).longValue() * 1000);
        Date d = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat(YYYYMM);
        sp.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return Integer.parseInt(sp.format(d));
    }


}
