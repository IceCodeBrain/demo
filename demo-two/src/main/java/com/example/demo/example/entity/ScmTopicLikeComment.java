package com.example.demo.example.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "scm_topic_like_comment")
public class ScmTopicLikeComment {
    /**
     * 点赞id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程评论的id
     */
    @Column(name = "scm_topic_comment_id")
    private Long scmTopicCommentId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 是否点赞  否->0  or false |  是->1 or true
     */
    @Column(name = "is_like")
    private Boolean isLike;

    /**
     * 更新操作时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取点赞id
     *
     * @return id - 点赞id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置点赞id
     *
     * @param id 点赞id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取课程评论的id
     *
     * @return scm_topic_comment_id - 课程评论的id
     */
    public Long getScmTopicCommentId() {
        return scmTopicCommentId;
    }

    /**
     * 设置课程评论的id
     *
     * @param scmTopicCommentId 课程评论的id
     */
    public void setScmTopicCommentId(Long scmTopicCommentId) {
        this.scmTopicCommentId = scmTopicCommentId;
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
     * 获取是否点赞  否->0  or false |  是->1 or true
     *
     * @return is_like - 是否点赞  否->0  or false |  是->1 or true
     */
    public Boolean getIsLike() {
        return isLike;
    }

    /**
     * 设置是否点赞  否->0  or false |  是->1 or true
     *
     * @param isLike 是否点赞  否->0  or false |  是->1 or true
     */
    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    /**
     * 获取更新操作时间
     *
     * @return update_time - 更新操作时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新操作时间
     *
     * @param updateTime 更新操作时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}