package com.example.demo.service.impl;

import com.example.demo.boot.restful.RestDTO;
import com.example.demo.dao.WeatherInfoDao;
import com.example.demo.model.dto.WeatherInfoDTO;
import com.example.demo.model.entity.WeatherInfo;
import com.example.demo.model.excel.AreaWeatherEO;
import com.example.demo.model.vo.WeatherInfoVO;
import com.example.demo.service.WeatherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description: 地区天气信息表(WeatherInfo)表服务实现类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:55 <br>
 */
@RequiredArgsConstructor
@Service
public class WeatherInfoServiceImpl implements WeatherInfoService {


    private final WeatherInfoDao weatherInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WeatherInfoVO queryById(Integer id) {
        return weatherInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dto 分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<WeatherInfoVO> queryByPage(RestDTO<Object> dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(weatherInfoDao.findList(new WeatherInfo()));
    }

    /**
     * 新增数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean add(WeatherInfoDTO dto) {
        Date now = new Date();
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setCode(dto.getCode());
        weatherInfo.setName(dto.getName());
        weatherInfo.setUpdateTime(now);
        weatherInfo.setCreateTime(now);
        return this.weatherInfoDao.insertSelective(weatherInfo) == 1;
    }

    /**
     * 修改数据
     *
     * @param dto 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(WeatherInfoDTO dto) {
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setId(dto.getId());
        weatherInfo.setCode(dto.getCode());
        weatherInfo.setName(dto.getName());
        weatherInfo.setUpdateTime(new Date());
        return this.weatherInfoDao.updateByPrimaryKeySelective(weatherInfo) == 1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        return this.weatherInfoDao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<AreaWeatherEO> exportList() {
        return weatherInfoDao.exportList();
    }

    @Override
    public String batchAdd(List<WeatherInfo> list) {
        try {
            weatherInfoDao.insertList(list);
        } catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }

    @Override
    public Boolean existCode(Integer code) {
        return weatherInfoDao.existCode(code) != null;
    }

    /* =================================================【以下为私有方法区域】=================================================================*/
}

