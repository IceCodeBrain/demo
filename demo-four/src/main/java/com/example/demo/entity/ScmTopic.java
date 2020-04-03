package com.example.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程表(ScmTopic)实体类
 *
 * @author makejava
 * @since 2020-04-03 14:18:12
 */
public class ScmTopic implements Serializable {
    private static final long serialVersionUID = 547798957096169683L;
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
    * 课程详情
    */
    private String currDetail;
    /**
    * 课程介绍
    */
    private String remark;
    /**
    * 封面url
    */
    private String coverUrl;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 数据状态(0 有效 1无效)
    */
    private String state;
    /**
    * 发布状态(0 发布 1 未发布)
    */
    private String releaseState;
    /**
    * 排序字段
    */
    private Long sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCurrTitleId() {
        return currTitleId;
    }

    public void setCurrTitleId(Long currTitleId) {
        this.currTitleId = currTitleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrDetail() {
        return currDetail;
    }

    public void setCurrDetail(String currDetail) {
        this.currDetail = currDetail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(String releaseState) {
        this.releaseState = releaseState;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

}