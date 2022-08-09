package com.example.demo.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @description: 用户信息表(UserInfo)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:20 <br>
 */
@Data
@Table(name = "user_info")
public class UserInfo {

    /**
     * 用户id
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    /**
     * 账号名称
     */


    private String name;

    /**
     * 用户手机号
     */


    private String phone;

    /**
     * 密码
     */


    private String password;

    /**
     * 创建时间
     */


    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */


    @Column(name = "update_time")
    private Date updateTime;


}

