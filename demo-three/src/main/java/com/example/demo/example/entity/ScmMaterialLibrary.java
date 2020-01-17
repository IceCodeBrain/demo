package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_material_library")
public class ScmMaterialLibrary {
    /**
     * 素材库id
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
     * 标题
     */
    private String title;

    /**
     * 图文类型（T 种草，V 视频，P 测评，I 图片）
     */
    @Column(name = "evaluation_type")
    private String evaluationType;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否@兔店学院
     */
    private Byte aite;

    /**
     * 审核状态（0 未审核 1 审核通过 2 审核不通过）
     */
    @Column(name = "auth_status")
    private Integer authStatus;

    /**
     * 文本描述
     */
    private String description;

    /**
     * 视频地址
     */
    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 图片地址（多个用,隔开）
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 获取素材库id
     *
     * @return id - 素材库id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置素材库id
     *
     * @param id 素材库id
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
     * 获取图文类型（T 种草，V 视频，P 测评，I 图片）
     *
     * @return evaluation_type - 图文类型（T 种草，V 视频，P 测评，I 图片）
     */
    public String getEvaluationType() {
        return evaluationType;
    }

    /**
     * 设置图文类型（T 种草，V 视频，P 测评，I 图片）
     *
     * @param evaluationType 图文类型（T 种草，V 视频，P 测评，I 图片）
     */
    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
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
     * 获取是否@兔店学院
     *
     * @return aite - 是否@兔店学院
     */
    public Byte getAite() {
        return aite;
    }

    /**
     * 设置是否@兔店学院
     *
     * @param aite 是否@兔店学院
     */
    public void setAite(Byte aite) {
        this.aite = aite;
    }

    /**
     * 获取审核状态（0 未审核 1 审核通过 2 审核不通过）
     *
     * @return auth_status - 审核状态（0 未审核 1 审核通过 2 审核不通过）
     */
    public Integer getAuthStatus() {
        return authStatus;
    }

    /**
     * 设置审核状态（0 未审核 1 审核通过 2 审核不通过）
     *
     * @param authStatus 审核状态（0 未审核 1 审核通过 2 审核不通过）
     */
    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * 获取文本描述
     *
     * @return description - 文本描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置文本描述
     *
     * @param description 文本描述
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

    /**
     * 获取图片地址（多个用,隔开）
     *
     * @return pic_url - 图片地址（多个用,隔开）
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片地址（多个用,隔开）
     *
     * @param picUrl 图片地址（多个用,隔开）
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}