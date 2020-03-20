package com.example.demo;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @description: TestHuTool <br>
 * @date: 2020/3/10 11:53 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
@Slf4j
public class TestHuTool {

    @Test
    public void testDateUtils1() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.MS);
        //Level.MINUTE表示精确到分
        String formatBetween = DateUtil.formatBetween(betweenDay, BetweenFormater.Level.MINUTE);
        //输出：31天1小时
        Console.log(formatBetween);
    }

    //转换时间
    @Test
    public void doTransformDate() throws ParseException {
        long nd = 24 * 60 * 60;
        long nh = 60 * 60;
        long nm = 60;
        long ns = 1;
        // 获得两个时间的毫秒时间差异
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date begin = dfs.parse("2004-01-02 11:30:24");
        java.util.Date end = dfs.parse("2004-01-03 12:31:30");
        long diff = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        Console.log(day + "天" + hour + "小时" + min + "分钟" + sec + "秒");
    }

}
