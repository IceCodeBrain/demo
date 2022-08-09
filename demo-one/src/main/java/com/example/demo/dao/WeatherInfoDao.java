package com.example.demo.dao;

import com.example.demo.boot.component.tk.TKMapper;
import com.example.demo.model.entity.WeatherInfo;
import com.example.demo.model.excel.AreaWeatherEO;
import com.example.demo.model.vo.WeatherInfoVO;

import java.util.List;


/**
 * @description: 地区天气信息表(WeatherInfo)表数据库访问层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:55 <br>
 */

public interface WeatherInfoDao extends TKMapper<WeatherInfo> {

    /**
     * 查询单条数据
     *
     * @param weatherInfo 查询条件
     * @return 返回对象
     */
    WeatherInfo findOne(WeatherInfo weatherInfo);

    WeatherInfoVO queryById(Integer id);

    List<WeatherInfoVO> findList(WeatherInfo weatherInfo);

    List<AreaWeatherEO> exportList();

    Integer existCode(Integer code);
}

