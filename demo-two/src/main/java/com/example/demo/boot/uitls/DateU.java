package com.example.demo.boot.uitls;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: DateU <br>
 * @date: 2020/1/20 10:47 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public class DateU {


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

        LocalDate date2 = LocalDate.of(2018,2,5);
        System.out.println("date2:" + date2);

        date2 = LocalDate.MIN;
        System.out.println("date2:" + date2);
        System.out.println("today:" + today);
        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);

    }

    public static void main(String[] args) {
        /*String pattern = "yyyy-MM";
        System.out.println(getDateStr(pattern, Calendar.MONTH, -24));
        String dateFormatType = "%Y-%m";

        int calendar = Calendar.MONTH;
        int num = 15;
        for (int day = 0; day > -num; day--) {
            System.out.println(getDateStr(pattern, calendar, day));
        }*/
        doLocalDate();
    }
}
