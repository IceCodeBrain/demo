package com.example.demo.service.impl;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.dao.AreaCodeDao;
import com.example.demo.model.dto.AreaCodeDTO;
import com.example.demo.model.entity.AreaCode;
import com.example.demo.model.vo.AreaCodeVO;
import com.example.demo.service.AreaCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 地址编码表(AreaCode)表服务实现类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:53 <br>
 */
@RequiredArgsConstructor
@Service
public class AreaCodeServiceImpl implements AreaCodeService {

    private final AreaCodeDao areaCodeDao;

    @Override
    public List<AreaCodeVO> getAddress(Integer code) {
        return areaCodeDao.getAddress(code);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AreaCodeVO queryById(Integer id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<AreaCodeVO> queryByPage(RestDTO<Object> dto) {
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
    public Boolean add(AreaCodeDTO dto) {
        AreaCode areaCode = new AreaCode();
        return this.areaCodeDao.insertSelective(areaCode) == 1;
    }

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(AreaCodeDTO dto) {
        AreaCode areaCode = new AreaCode();
        return this.areaCodeDao.updateByPrimaryKeySelective(areaCode) == 1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        return this.areaCodeDao.deleteByPrimaryKey(id) == 1;
    }

    /* =================================================【以下为私有方法区域】=================================================================*/
}

