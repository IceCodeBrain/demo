package com.example.demo.boot.uitls;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description: DateU <br>
 * @date: 2020/1/20 10:47 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public class DateU {


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

    public static String doFormatDate(Date date) {
        return doFormatDate("yyyy-MM-dd", date);
    }

    public static String doFormatDate(String pattern, Date date) {
        /*SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);*/
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date getDate(int calendar, int oneDay, Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendar, oneDay);
        return c.getTime();
    }

    public static String getDateStr(int oneDay) {
        return getDateStr("yyyy-MM-dd", Calendar.MONTH, oneDay);
    }

    public static String getDateStr(int calendar, int oneDay) {
        return getDateStr("yyyy-MM-dd", calendar, oneDay);
    }

    public static String getDateStr(String pattern, int calendar, int oneDay) {
        //yyyy-MM-dd"
        return getDateStr(pattern, calendar, oneDay, new Date());
    }

    public static String getDateStr(String pattern, int calendar, int oneDay, Date date) {
        return doFormatDate(pattern, getDate(calendar, oneDay, date));
    }


    public static void doLocalDate() {

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        LocalDate date2 = LocalDate.of(2018, 2, 5);
        System.out.println("date2:" + date2);

        date2 = LocalDate.MIN;
        System.out.println("date2:" + date2);
        System.out.println("today:" + today);
        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);

    }

    public static void testInstant() {
        Date date = new Date();
        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(date);
        System.out.println(instant);
        System.out.println(localDateTime);
    }

    public static void testLangDateUtils() {
        Date date = DateUtils.addMinutes(new Date(), 10);
        System.out.println(date);
    }

    public static void testWxPay() {
        String pay = "2020-09-14T10:14:59+08:00";

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(pay);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
