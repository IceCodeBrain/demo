package com.example.demo.dao;

import com.example.demo.boot.component.tk.TKMapper;
import com.example.demo.model.entity.UserInfo;


/**
 * @description: 用户信息表(UserInfo)表数据库访问层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:20 <br>
 */

public interface UserInfoDao extends TKMapper<UserInfo> {

    /**
     * 查询单条数据
     *
     * @param userInfo 查询条件
     * @return 返回对象
     */
    UserInfo findOne(UserInfo userInfo);

}

