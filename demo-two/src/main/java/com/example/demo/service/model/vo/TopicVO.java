package com.example.demo.service.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description: TopicVO <br>
 * @date: 2020/1/15 16:21 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Data
public class TopicVO {


    /**
     * id
     */
    private Long id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 所属课题id
     */
    private Long currTitleId;

    /**
     * 课程类型（0 文章 1 视频）
     */
    private String type;

    /**
     * 封面url
     */
    private String coverUrl;

    /**
     * 发布状态(0 发布 1 未发布)
     */
    private String releaseState;

    /**
     * 课程详情
     */
    private String currDetail;

    /**
     * 课程介绍
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
