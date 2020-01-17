package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_topic")
public class ScmTopic {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 所属课题id
     */
    @Column(name = "curr_title_id")
    private Long currTitleId;

    /**
     * 课程类型（0 文章 1 视频）
     */
    private String type;

    /**
     * 封面url
     */
    @Column(name = "cover_url")
    private String coverUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 数据状态(0 有效 1无效)
     */
    private String state;

    /**
     * 发布状态(0 发布 1 未发布)
     */
    @Column(name = "release_state")
    private String releaseState;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 课程详情
     */
    @Column(name = "curr_detail")
    private String currDetail;

    /**
     * 课程介绍
     */
    private String remark;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取课程名称
     *
     * @return name - 课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     *
     * @param name 课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所属课题id
     *
     * @return curr_title_id - 所属课题id
     */
    public Long getCurrTitleId() {
        return currTitleId;
    }

    /**
     * 设置所属课题id
     *
     * @param currTitleId 所属课题id
     */
    public void setCurrTitleId(Long currTitleId) {
        this.currTitleId = currTitleId;
    }

    /**
     * 获取课程类型（0 文章 1 视频）
     *
     * @return type - 课程类型（0 文章 1 视频）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置课程类型（0 文章 1 视频）
     *
     * @param type 课程类型（0 文章 1 视频）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取封面url
     *
     * @return cover_url - 封面url
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * 设置封面url
     *
     * @param coverUrl 封面url
     */
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取数据状态(0 有效 1无效)
     *
     * @return state - 数据状态(0 有效 1无效)
     */
    public String getState() {
        return state;
    }

    /**
     * 设置数据状态(0 有效 1无效)
     *
     * @param state 数据状态(0 有效 1无效)
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取发布状态(0 发布 1 未发布)
     *
     * @return release_state - 发布状态(0 发布 1 未发布)
     */
    public String getReleaseState() {
        return releaseState;
    }

    /**
     * 设置发布状态(0 发布 1 未发布)
     *
     * @param releaseState 发布状态(0 发布 1 未发布)
     */
    public void setReleaseState(String releaseState) {
        this.releaseState = releaseState;
    }

    /**
     * 获取排序字段
     *
     * @return sort - 排序字段
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序字段
     *
     * @param sort 排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取课程详情
     *
     * @return curr_detail - 课程详情
     */
    public String getCurrDetail() {
        return currDetail;
    }

    /**
     * 设置课程详情
     *
     * @param currDetail 课程详情
     */
    public void setCurrDetail(String currDetail) {
        this.currDetail = currDetail;
    }

    /**
     * 获取课程介绍
     *
     * @return remark - 课程介绍
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置课程介绍
     *
     * @param remark 课程介绍
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}