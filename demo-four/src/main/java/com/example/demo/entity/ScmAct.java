package com.example.demo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @description: CMS文章视频测评种草表(ScmAct)实体类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 10:18:13 <br>
 */

@Table(name = "scm_act")
public class ScmAct{
        
    
    private Long id;
        
    /**
     * 发布用户id
     */
    
    @Column(name = "user_id")
    private Long userId;
        
    /**
     * 关联商家id
     */
    
    @Column(name = "seller_id")
    private Long sellerId;
        
    /**
     * 商品ids(逗号分割)
     */
    
    @Column(name = "product_id")
    private String productId;
        
    /**
     * 商品分类id
     */
    
    @Column(name = "category_id")
    private Long categoryId;
        
    /**
     * 标题
     */
    
    private String title;
        
    /**
     * 作者
     */
    
    private String author;
        
    /**
     * 简单描述
     */
    
    @Column(name = "simple_description")
    private String simpleDescription;
        
    /**
     * 文本
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
     * 封面图
     */
    
    private String cover;
        
    /**
     * 简介/摘要
     */
    
    private String abstracts;
        
    /**
     * 图文类型（T 种草，V 视频，P 测评 I 图片）
     */
    
    @Column(name = "evaluation_type")
    private String evaluationType;
        
    /**
     * 点赞数
     */
    
    private Integer likes;
        
    /**
     * 分享数
     */
    
    private Integer shears;
        
    /**
     * 评论数
     */
    
    private Integer comments;
        
    /**
     * 浏览/观看数
     */
    
    private Integer browse;
        
    /**
     * 共享锁
     */
    
    private Integer version;
        
    /**
     * 审核状态（0=已保存1=审核中2=审核成功3=待上架4=出售中5=已下架 6=审核失败）
     */
    
    @Column(name = "auth_status")
    private Integer authStatus;
        
    /**
     * 不通过原因
     */
    
    @Column(name = "fail_cause")
    private String failCause;
        
    /**
     * 0未推荐1推荐
     */
    
    @Column(name = "act_status")
    private Integer actStatus;
        
    /**
     * 1置顶
     */
    
    @Column(name = "act_top")
    private Integer actTop;
        
    /**
     * 修改时间
     */
    
    @Column(name = "update_time")
    private Date updateTime;
        
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
     * 兔店头条 1 供应链头条 2 商家头条
     */
    
    @Column(name = "headlines_article")
    private Byte headlinesArticle;
        
    /**
     * @删除标志
     */
    
    @Column(name = "aite_delete")
    private Byte aiteDelete;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    /**
     * 获取发布用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置发布用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
        
    /**
     * 获取关联商家id
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置关联商家id
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
        
    /**
     * 获取商品ids(逗号分割)
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置商品ids(逗号分割)
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }
        
    /**
     * 获取商品分类id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
        
    /**
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
        
    /**
     * 获取作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }
        
    /**
     * 获取简单描述
     */
    public String getSimpleDescription() {
        return simpleDescription;
    }

    /**
     * 设置简单描述
     */
    public void setSimpleDescription(String simpleDescription) {
        this.simpleDescription = simpleDescription;
    }
        
    /**
     * 获取文本
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置文本
     */
    public void setDescription(String description) {
        this.description = description;
    }
        
    /**
     * 获取视频地址
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频地址
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
        
    /**
     * 获取图片地址（多个用,隔开）
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置图片地址（多个用,隔开）
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
        
    /**
     * 获取封面图
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面图
     */
    public void setCover(String cover) {
        this.cover = cover;
    }
        
    /**
     * 获取简介/摘要
     */
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * 设置简介/摘要
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }
        
    /**
     * 获取图文类型（T 种草，V 视频，P 测评 I 图片）
     */
    public String getEvaluationType() {
        return evaluationType;
    }

    /**
     * 设置图文类型（T 种草，V 视频，P 测评 I 图片）
     */
    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }
        
    /**
     * 获取点赞数
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * 设置点赞数
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }
        
    /**
     * 获取分享数
     */
    public Integer getShears() {
        return shears;
    }

    /**
     * 设置分享数
     */
    public void setShears(Integer shears) {
        this.shears = shears;
    }
        
    /**
     * 获取评论数
     */
    public Integer getComments() {
        return comments;
    }

    /**
     * 设置评论数
     */
    public void setComments(Integer comments) {
        this.comments = comments;
    }
        
    /**
     * 获取浏览/观看数
     */
    public Integer getBrowse() {
        return browse;
    }

    /**
     * 设置浏览/观看数
     */
    public void setBrowse(Integer browse) {
        this.browse = browse;
    }
        
    /**
     * 获取共享锁
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置共享锁
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
        
    /**
     * 获取审核状态（0=已保存1=审核中2=审核成功3=待上架4=出售中5=已下架 6=审核失败）
     */
    public Integer getAuthStatus() {
        return authStatus;
    }

    /**
     * 设置审核状态（0=已保存1=审核中2=审核成功3=待上架4=出售中5=已下架 6=审核失败）
     */
    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }
        
    /**
     * 获取不通过原因
     */
    public String getFailCause() {
        return failCause;
    }

    /**
     * 设置不通过原因
     */
    public void setFailCause(String failCause) {
        this.failCause = failCause;
    }
        
    /**
     * 获取0未推荐1推荐
     */
    public Integer getActStatus() {
        return actStatus;
    }

    /**
     * 设置0未推荐1推荐
     */
    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }
        
    /**
     * 获取1置顶
     */
    public Integer getActTop() {
        return actTop;
    }

    /**
     * 设置1置顶
     */
    public void setActTop(Integer actTop) {
        this.actTop = actTop;
    }
        
    /**
     * 获取修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
        
    /**
     * 获取创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    /**
     * 获取是否@兔店学院
     */
    public Byte getAite() {
        return aite;
    }

    /**
     * 设置是否@兔店学院
     */
    public void setAite(Byte aite) {
        this.aite = aite;
    }
        
    /**
     * 获取兔店头条 1 供应链头条 2 商家头条
     */
    public Byte getHeadlinesArticle() {
        return headlinesArticle;
    }

    /**
     * 设置兔店头条 1 供应链头条 2 商家头条
     */
    public void setHeadlinesArticle(Byte headlinesArticle) {
        this.headlinesArticle = headlinesArticle;
    }
        
    /**
     * 获取@删除标志
     */
    public Byte getAiteDelete() {
        return aiteDelete;
    }

    /**
     * 设置@删除标志
     */
    public void setAiteDelete(Byte aiteDelete) {
        this.aiteDelete = aiteDelete;
    }

}