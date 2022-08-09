package com.example.demo.service;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.model.dto.AreaCodeDTO;
import com.example.demo.model.vo.AreaCodeVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description: 地址编码表(AreaCode)表服务接口 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:54 <br>
 */

public interface AreaCodeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AreaCodeVO queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    PageInfo<AreaCodeVO> queryByPage(RestDTO<Object> dto);

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean add(AreaCodeDTO dto);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean update(AreaCodeDTO dto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);


    List<AreaCodeVO> getAddress(Integer code);


}

