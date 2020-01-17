package com.example.demo.service.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: AnnouncementDTO <br>
 * @date: 2020/1/13 17:03 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@ApiModel("平面公告")
@Data
public class AnnouncementDTO {

    /**
     * 公告主键id
     */
    @ApiModelProperty(value = "公告主键id")
    private Long id;

    /**
     * 公告名称
     */
    @ApiModelProperty(value = "公告名称")
    private String title;


    /**
     * 供应链 1 商家 2 商家和供应链都可用 3
     */
    @ApiModelProperty(value = "供应链 1 商家 2 商家和供应链都可用 3")
    private Byte type;


    /**
     * 公告内容少于200字
     */
    @ApiModelProperty(value = "公告内容少于200字")
    private String content;

    /**
     * 滚动时间以秒为单位不要超过4位数
     */
    @ApiModelProperty(value = "滚动时间以秒为单位不要超过4位数")
    private Byte rollingTime;

    /**
     * 文字是否轮播 是-》1或者true  否->0或者false
     */
    @ApiModelProperty(value = "文字是否轮播 是->true  否->false")
    private Boolean wordIsRolling;


    @ApiModelProperty(value = "排序")
    private Integer sort;
}
