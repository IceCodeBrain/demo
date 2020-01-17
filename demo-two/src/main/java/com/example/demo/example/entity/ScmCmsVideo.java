package com.example.demo.example.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "scm_cms_video")
public class ScmCmsVideo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频分类id
     */
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 观看数
     */
    @Column(name = "watch_count")
    private Integer watchCount;

    /**
     * 点赞数
     */
    @Column(name = "likes_count")
    private Integer likesCount;

    /**
     * 评论数
     */
    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 时长
     */
    @Column(name = "time_length")
    private Long timeLength;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 视频描述
     */
    private String description;

    /**
     * 视频地址
     */
    @Column(name = "video_url")
    private String videoUrl;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取视频分类id
     *
     * @return type_id - 视频分类id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置视频分类id
     *
     * @param typeId 视频分类id
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取封面图
     *
     * @return cover - 封面图
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面图
     *
     * @param cover 封面图
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取观看数
     *
     * @return watch_count - 观看数
     */
    public Integer getWatchCount() {
        return watchCount;
    }

    /**
     * 设置观看数
     *
     * @param watchCount 观看数
     */
    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

    /**
     * 获取点赞数
     *
     * @return likes_count - 点赞数
     */
    public Integer getLikesCount() {
        return likesCount;
    }

    /**
     * 设置点赞数
     *
     * @param likesCount 点赞数
     */
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    /**
     * 获取评论数
     *
     * @return comment_count - 评论数
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数
     *
     * @param commentCount 评论数
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取时长
     *
     * @return time_length - 时长
     */
    public Long getTimeLength() {
        return timeLength;
    }

    /**
     * 设置时长
     *
     * @param timeLength 时长
     */
    public void setTimeLength(Long timeLength) {
        this.timeLength = timeLength;
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
     * 获取视频描述
     *
     * @return description - 视频描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置视频描述
     *
     * @param description 视频描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取视频地址
     *
     * @return video_url - 视频地址
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频地址
     *
     * @param videoUrl 视频地址
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}