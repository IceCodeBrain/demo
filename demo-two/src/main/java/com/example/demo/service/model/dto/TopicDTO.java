package com.example.demo.service.model.dto;

import lombok.Data;

/**
 * @description: TopicDTO <br>
 * @date: 2020/1/15 16:36 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Data
public class TopicDTO {
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
     * 课程详情
     */
    private String currDetail;

    /**
     * 课程介绍
     */
    private String remark;

}
