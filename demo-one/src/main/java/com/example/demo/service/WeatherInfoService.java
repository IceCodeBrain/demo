package com.example.demo.service;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.model.dto.WeatherInfoDTO;
import com.example.demo.model.entity.WeatherInfo;
import com.example.demo.model.excel.AreaWeatherEO;
import com.example.demo.model.vo.WeatherInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description: 地区天气信息表(WeatherInfo)表服务接口 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:55 <br>
 */

public interface WeatherInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WeatherInfoVO queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    PageInfo<WeatherInfoVO> queryByPage(RestDTO<Object> dto);

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean add(WeatherInfoDTO dto);

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return Boolean
     */
    Boolean update(WeatherInfoDTO dto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

    List<AreaWeatherEO> exportList();

    String batchAdd(List<WeatherInfo> list);

    Boolean existCode(Integer code);
}

