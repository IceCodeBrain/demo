package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_topic_tab")
public class ScmTopicTab {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标签id
     */
    @Column(name = "tab_id")
    private Long tabId;

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
     * 课程表id
     */
    @Column(name = "topic_id")
    private Long topicId;

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
     * 获取标签id
     *
     * @return tab_id - 标签id
     */
    public Long getTabId() {
        return tabId;
    }

    /**
     * 设置标签id
     *
     * @param tabId 标签id
     */
    public void setTabId(Long tabId) {
        this.tabId = tabId;
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
     * 获取课程表id
     *
     * @return topic_id - 课程表id
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * 设置课程表id
     *
     * @param topicId 课程表id
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}