package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_topic_like")
public class ScmTopicLike {
    /**
     * 点赞课程主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 课程id
     */
    @Column(name = "topic_id")
    private Long topicId;

    /**
     * 是否关注 否->0 or  false |  是->1 or true
     */
    @Column(name = "is_like")
    private Boolean isLike;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取点赞课程主键
     *
     * @return id - 点赞课程主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置点赞课程主键
     *
     * @param id 点赞课程主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取课程id
     *
     * @return topic_id - 课程id
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * 设置课程id
     *
     * @param topicId 课程id
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取是否关注 否->0 or  false |  是->1 or true
     *
     * @return is_like - 是否关注 否->0 or  false |  是->1 or true
     */
    public Boolean getIsLike() {
        return isLike;
    }

    /**
     * 设置是否关注 否->0 or  false |  是->1 or true
     *
     * @param isLike 是否关注 否->0 or  false |  是->1 or true
     */
    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}