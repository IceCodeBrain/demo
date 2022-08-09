package com.example.demo.service;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.model.dto.UserInfoDTO;
import com.example.demo.model.vo.UserInfoVO;
import com.github.pagehelper.PageInfo;

/**
 * @description: 用户信息表(UserInfo)表服务接口 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:20 <br>
 */

public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfoVO queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    PageInfo<UserInfoVO> queryByPage(RestDTO<Object> dto);

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean add(UserInfoDTO dto);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean update(UserInfoDTO dto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);


}

