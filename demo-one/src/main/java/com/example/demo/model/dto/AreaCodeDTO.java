package com.example.demo.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 地址编码表(AreaCode)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2022-05-13 16:54:54 <br>
 */

@ApiModel("地址编码表model")
@Data
public class AreaCodeDTO {

    @ApiModelProperty(value = "地址Id")
    private Integer id;

    @ApiModelProperty(value = "区域名称")
    private String name;

    @ApiModelProperty(value = "地址全称")
    private String address;

    @ApiModelProperty(value = "区域Code")
    private Integer code;

    @ApiModelProperty(value = "上级区域Code")
    private Integer superCode;


}

