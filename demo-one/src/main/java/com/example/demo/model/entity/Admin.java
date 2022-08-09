package com.example.demo.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @description: 管理员信息表(Admin)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:19 <br>
 */
@Data
@Table(name = "admin")
public class Admin {

    /**
     * 管理员id
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    /**
     * 头像
     */


    private String avatar;

    /**
     * 名称
     */


    private String username;

    /**
     * 昵称
     */


    private String nickname;

    /**
     * 密码
     */


    private String password;

    /**
     * 电话
     */


    private String phone;

    /**
     * 类型
     */


    private Integer type;

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

