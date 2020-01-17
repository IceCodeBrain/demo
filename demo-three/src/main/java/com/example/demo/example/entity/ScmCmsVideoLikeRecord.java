package com.example.demo.example.entity;

import javax.persistence.*;

@Table(name = "scm_cms_video_like_record")
public class ScmCmsVideoLikeRecord {
    /**
     * 点赞id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 视频id
     */
    @Column(name = "cms_video_id")
    private Long cmsVideoId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 评论id
     */
    @Column(name = "comment_id")
    private Long commentId;

    /**
     * 是否评论点赞 Y
     */
    @Column(name = "is_comment_like")
    private String isCommentLike;

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
     * 获取视频id
     *
     * @return cms_video_id - 视频id
     */
    public Long getCmsVideoId() {
        return cmsVideoId;
    }

    /**
     * 设置视频id
     *
     * @param cmsVideoId 视频id
     */
    public void setCmsVideoId(Long cmsVideoId) {
        this.cmsVideoId = cmsVideoId;
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
     * 获取评论id
     *
     * @return comment_id - 评论id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置评论id
     *
     * @param commentId 评论id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取是否评论点赞 Y
     *
     * @return is_comment_like - 是否评论点赞 Y
     */
    public String getIsCommentLike() {
        return isCommentLike;
    }

    /**
     * 设置是否评论点赞 Y
     *
     * @param isCommentLike 是否评论点赞 Y
     */
    public void setIsCommentLike(String isCommentLike) {
        this.isCommentLike = isCommentLike;
    }
}