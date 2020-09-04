package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description: BaseController <br>
 * @date: 2020/1/10 14:33 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Slf4j
public class BaseController {


    public static void testAtomicInteger() {
        int i = 0;
        AtomicInteger atomicInteger = new AtomicInteger(i);
        i = atomicInteger.getAndIncrement();
        log.info("i = {}", i);
        log.info("i = {}", atomicInteger.get());
        long second = TimeUnit.DAYS.toHours(1);
        log.info("second = {}", second);
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();
        log.info("longAdder = {}", longAdder);

    }

    public static void test1() {
        Random random = new Random();
        log.info("{}", random.nextInt(999) % (999 - 100 + 1) + 100);
    }


    private static long getFakeSaleNum(Date now, Date startTime, Date endTime) {
        log.info("计算假销量  now :{} ; startTime: {} ; endTime : {}; fakeStock : {}", now, startTime, endTime, 100);
        long fakeSaleNum = new BigDecimal(100).multiply(new BigDecimal(getMinute(now) - getMinute(startTime)).divide(new BigDecimal(getMinute(endTime) - getMinute(startTime)), new MathContext(2))).longValue();
        log.info("fakeSaleNum :{}", fakeSaleNum);
        return fakeSaleNum;
    }

    private static long getMinute(Date date) {
        return date.getTime() / 1000;
    }

    public static void main(String[] args) {
        // testAtomicInteger();
        //test1();
        Date now = new Date();
        getFakeSaleNum(now, DateUtils.addHours(now, -1), DateUtils.addHours(now, 0));
    }
}
