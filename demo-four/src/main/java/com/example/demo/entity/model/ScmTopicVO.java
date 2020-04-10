package com.example.demo.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 课程表(ScmTopic)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 15:43:42 <br>
 */

@ApiModel("课程表model")
@Data
public class ScmTopicVO {

    @ApiModelProperty(value = "id", dataType = "java.lang.Long")
    private Long id;

    @ApiModelProperty(value = "课程名称", dataType = "java.lang.String")
    private String name;

    @ApiModelProperty(value = "所属课题id", dataType = "java.lang.Long")
    private Long currTitleId;

    @ApiModelProperty(value = "课程类型（0 文章 1 视频）", dataType = "java.lang.String")
    private String type;

    @ApiModelProperty(value = "课程详情", dataType = "java.lang.String")
    private String currDetail;

    @ApiModelProperty(value = "课程介绍", dataType = "java.lang.String")
    private String remark;

    @ApiModelProperty(value = "封面url", dataType = "java.lang.String")
    private String coverUrl;

}
