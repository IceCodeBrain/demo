package com.example.demo.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @description: 地区天气信息表(WeatherInfo)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:55 <br>
 */
@Data
@Table(name = "weather_info")
public class WeatherInfo {

    /**
     * 地区天气信息id
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    /**
     * 地区行政编码
     */


    private Integer code;

    /**
     * 地区名称
     */


    private String name;

    /**
     * 更新时间
     */


    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */


    @Column(name = "create_time")
    private Date createTime;


}

