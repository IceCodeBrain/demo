package com.example.demo.boot.test;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;


/**
 * @description: JunitTest <br>
 * @date: 2020/3/30 14:11 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
@Slf4j
public class JunitTest {

    /*  public static void main(String[] args) {
        Date now = new Date();
        List<Date> dateList = Lists.newArrayList();
        dateList.add(DateUtils.addDays(now, 12));
        dateList.add(now);
        dateList.add(DateUtils.addDays(now, 1));
        dateList.add(DateUtils.addDays(now, -1));
        dateList.sort(Date::compareTo);
        dateList.sort(((Comparator<Date>) Date::compareTo).reversed());
        System.out.println(dateList);
      }*/
    public static void main(String[] args) {
        System.out.println(DateUtils.truncate(new Date(), Calendar.DATE));
    }

}
