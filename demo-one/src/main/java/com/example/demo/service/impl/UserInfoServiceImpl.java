package com.example.demo.service.impl;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.model.dto.UserInfoDTO;
import com.example.demo.model.entity.UserInfo;
import com.example.demo.model.vo.UserInfoVO;
import com.example.demo.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @description: 用户信息表(UserInfo)表服务实现类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:20 <br>
 */
@RequiredArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {


    private final UserInfoDao userInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserInfoVO queryById(Integer id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<UserInfoVO> queryByPage(RestDTO<Object> dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return null;
    }

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean add(UserInfoDTO dto) {
        UserInfo userInfo = new UserInfo();
        return this.userInfoDao.insertSelective(userInfo) == 1;
    }

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(UserInfoDTO dto) {
        UserInfo userInfo = new UserInfo();
        return this.userInfoDao.updateByPrimaryKeySelective(userInfo) == 1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        return this.userInfoDao.deleteByPrimaryKey(id) == 1;
    }

    /* =================================================【以下为私有方法区域】=================================================================*/
}

