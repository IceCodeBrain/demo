package com.example.demo.service.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @description: TopicBean <br>
 * @date: 2020/1/15 16:23 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "topic", type = "_doc", shards = 1, replicas = 0)
public class TopicBean {


    /**
     * Incorrect table definition; there can be only one auto column and it must be defined as a key
     * id
     */
    @Id
    private Long id;

    /**
     * 课程名称
     */
    @Field(type = FieldType.Keyword)
    private String name;

    /**
     * 所属课题id
     */
    @Field(type = FieldType.Keyword)
    private Long currTitleId;

    /**
     * 课程类型（0 文章 1 视频）
     */
    private String type;

    /**
     * 封面url
     */
    @Field(type = FieldType.Text)
    private String coverUrl;


    /**
     * 数据状态(0 有效 1无效)
     */
    @Field(type = FieldType.Keyword)
    private String state;

    /**
     * 发布状态(0 发布 1 未发布)
     */
    @Field(type = FieldType.Keyword)
    private String releaseState;

    /**
     * 排序字段
     */
    @Field(type = FieldType.Integer)
    private Integer sort;

    /**
     * 课程详情
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String currDetail;

    /**
     * 课程介绍
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String remark;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Date)
    private Date createTime;

    /**
     * 修改时间
     */
    @Field(type = FieldType.Date)
    private Date updateTime;
}
