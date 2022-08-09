package com.example.demo.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 地区天气信息表(WeatherInfo)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:55 <br>
 */

@ApiModel("地区天气信息表model")
@Data
public class WeatherInfoDTO {

    @ApiModelProperty(value = "地区天气信息id")
    private Integer id;

    @ApiModelProperty(value = "地区行政编码")
    private Integer code;

    @ApiModelProperty(value = "地区名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}

