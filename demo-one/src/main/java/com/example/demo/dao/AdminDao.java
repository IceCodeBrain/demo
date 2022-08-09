package com.example.demo.dao;

import com.example.demo.boot.component.tk.TKMapper;
import com.example.demo.model.entity.Admin;
import com.example.demo.model.vo.AdminVO;

import java.util.List;


/**
 * @description: 管理员信息表(Admin)表数据库访问层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:19 <br>
 */

public interface AdminDao extends TKMapper<Admin> {

    /**
     * 查询单条数据
     *
     * @param admin 查询条件
     * @return 返回对象
     */
    Admin findOne(Admin admin);

    List<AdminVO> findList(Admin admin);

    AdminVO queryById(Integer id);
}

