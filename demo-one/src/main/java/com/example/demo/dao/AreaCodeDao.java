package com.example.demo.dao;

import com.example.demo.boot.component.tk.TKMapper;
import com.example.demo.model.entity.AreaCode;
import com.example.demo.model.vo.AreaCodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @description: 地址编码表(AreaCode)表数据库访问层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:54 <br>
 */

public interface AreaCodeDao extends TKMapper<AreaCode> {

    /**
     * 查询单条数据
     *
     * @param areaCode 查询条件
     * @return 返回对象
     */
    AreaCode findOne(AreaCode areaCode);

    List<AreaCodeVO> getAddress(@Param("code") Integer code);

}

