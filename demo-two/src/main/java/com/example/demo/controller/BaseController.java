package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

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

    public static void test1(){
        Random random = new Random();
        log.info("{}",random.nextInt(999) % (999 - 100 + 1) + 100);
    }

    public static void main(String[] args) {
       // testAtomicInteger();
        test1();
    }
}
