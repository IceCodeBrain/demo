package com.example.demo.boot.uitls;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MathUtils {

    private MathUtils() {
    }

    /**
     * b1 大于 b2
     */
    public static boolean moreThan(BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) > 0;
    }

    /**
     * b1 大于或等于 b2
     */
    public static boolean moreThanOrEqual(BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) > -1;
    }

    /**
     * b1 小于 b2
     */
    public static boolean lessThan(BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) < 0;
    }

    /**
     * b1 小于或等于 b2
     */
    public static boolean lessThanOrEqual(BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) < 1;
    }

    /**
     * b1 等于 b2
     */
    public static boolean equal(BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) == 0;
    }


    /**
     * 加法运算
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode) {
        return add(b1, b2, roundingMode, 2);
    }

    /**
     * 加法运算
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode, int scale) {
        return b1.add(b2).setScale(scale, roundingMode);
    }

    /**
     * 减法运算
     */
    public static BigDecimal sub(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode) {
        return sub(b1, b2, roundingMode, 2);
    }

    /**
     * 减法运算
     */
    public static BigDecimal sub(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode, int scale) {
        return b1.subtract(b2).setScale(scale, roundingMode);
    }

    /**
     * 乘法运算
     */
    public static BigDecimal mul(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode) {
        return b1.multiply(b2).setScale(2, roundingMode);
    }


    /**
     * 乘法运算
     */
    public static BigDecimal mul(BigDecimal b1, BigDecimal b2) {
        return b1.multiply(b2).setScale(2, RoundingMode.HALF_UP);
    }


    /**
     * 乘法运算
     */
    public static BigDecimal mul(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode, int scale) {
        return b1.multiply(b2).setScale(scale, roundingMode);
    }


    /**
     * 除法运算
     */
    public static BigDecimal div(BigDecimal b1, BigDecimal b2, RoundingMode roundingMode, int scale) {
        return b1.divide(b2, scale, roundingMode);
    }
}
