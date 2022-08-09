package com.example.demo.service.impl;

import com.example.demo.boot.component.security.JWTUtils;
import com.example.demo.boot.restful.RestDTO;
import com.example.demo.boot.restful.ServiceException;
import com.example.demo.boot.uitls.DateUtils;
import com.example.demo.boot.uitls.PasswordUtils;
import com.example.demo.dao.AdminDao;
import com.example.demo.model.dto.AdminDTO;
import com.example.demo.model.entity.Admin;
import com.example.demo.model.vo.AdminVO;
import com.example.demo.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @description: 管理员信息表(Admin)表服务实现类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-14 12:23:17 <br>
 */
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {


    private final AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminVO queryById(Integer id) {
        return adminDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<AdminVO> queryByPage(RestDTO<Object> dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(adminDao.findList(new Admin()));
    }

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean add(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setAvatar(dto.getAvatar());
        admin.setUsername(dto.getUsername());
        admin.setNickname(dto.getNickname());
        admin.setPassword(PasswordUtils.buildPw(dto.getPassword()));
        admin.setPhone(dto.getPhone());
        admin.setType(2);
        admin.setUpdateTime(new Date());
        admin.setCreateTime(new Date());
        if (!StringUtils.hasText(dto.getPassword())) {
            throw new ServiceException("密码必填");
        }
        if (!StringUtils.hasText(dto.getNickname())) {
            throw new ServiceException("账号名称必填");
        }
        Admin info = new Admin();
        info.setNickname(dto.getNickname());
        info = adminDao.selectOne(info);
        if (info != null) {
            throw new ServiceException("该账号名称已被注册");
        }
        return adminDao.insertSelective(admin) == 1;

    }

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setAvatar(dto.getAvatar());
        admin.setUsername(dto.getUsername());
        admin.setNickname(dto.getNickname());
        admin.setPassword(dto.getPassword());
        admin.setPhone(dto.getPhone());
        admin.setType(2);
        admin.setUpdateTime(new Date());
        if (StringUtils.hasText(dto.getPassword())) {
            admin.setPassword(PasswordUtils.buildPw(dto.getPassword()));
        }
        if (StringUtils.hasText(dto.getNickname())) {
            Admin info = new Admin();
            info.setNickname(dto.getNickname());
            info = adminDao.selectOne(info);
            if (info != null) {
                if (!info.getId().equals(dto.getId())) {
                    throw new ServiceException("该账号名称已被注册");
                }
            }
        }
        return adminDao.updateByPrimaryKeySelective(admin) == 1;

    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        return this.adminDao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public AdminVO login(String nickname, String password) {
        Admin admin = new Admin();
        admin.setNickname(nickname);
        admin = adminDao.selectOne(admin);
        if (admin == null) {
            throw new ServiceException("无此账号");
        }
        password = PasswordUtils.buildPw(password);
        if (!admin.getPassword().equals(password)) {
            throw new ServiceException("密码错误");
        }
        AdminVO adminLoginVO = new AdminVO();
        adminLoginVO.setNickname(admin.getNickname());
        adminLoginVO.setUsername(admin.getUsername());
        adminLoginVO.setAvatar(admin.getAvatar());
        adminLoginVO.setType(admin.getType());
        Date expireTime = DateUtils.addDays(new Date(), 1);
        adminLoginVO.setToken(JWTUtils.sign(admin.getId().toString(), password, expireTime));
        return adminLoginVO;
    }

    @Override
    public Boolean logout() {
        return true;
    }

    /* =================================================【以下为私有方法区域】=================================================================*/
}

