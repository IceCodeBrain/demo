package com.example.demo.service;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.model.dto.AdminDTO;
import com.example.demo.model.vo.AdminVO;
import com.github.pagehelper.PageInfo;

/**
 * @description: 管理员信息表(Admin)表服务接口 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:17 <br>
 */

public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminVO queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    PageInfo<AdminVO> queryByPage(RestDTO<Object> dto);

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean add(AdminDTO dto);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean update(AdminDTO dto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);


    /**
     * @param name     <br>
     * @param password <br>
     * @return com.yixin.review.model.vo.AdminLoginVO <br>
     * @description: login <br>
     * @date: 2021/4/7 16:50 <br>
     * @author: PWB <br>
     */
    AdminVO login(String nickname, String password);


    /**
     * @description: 后台管理退出登录 <br>
     * @author: PWB <br>
     */
    Boolean logout();


}

