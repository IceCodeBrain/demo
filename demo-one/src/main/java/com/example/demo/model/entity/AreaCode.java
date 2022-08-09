package com.example.demo.model.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @description: 地址编码表(AreaCode)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:54 <br>
 */
@Data
@Table(name = "area_code")
public class AreaCode {

    /**
     * 地址Id
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    /**
     * 区域名称
     */


    private String name;

    /**
     * 地址全称
     */


    private String address;

    /**
     * 区域Code
     */


    private Integer code;

    /**
     * 上级区域Code
     */


    @Column(name = "super_code")
    private Integer superCode;


}

