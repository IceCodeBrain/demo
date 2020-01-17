package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_cms_video_comment")
public class ScmCmsVideoComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 供应链视频id
     */
    @Column(name = "cms_video_id")
    private Long cmsVideoId;

    /**
     * 评论用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 评论用户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户头像
     */
    @Column(name = "user_pic")
    private String userPic;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论图片地址
     */
    @Column(name = "comment_pic")
    private String commentPic;

    /**
     * 点赞数
     */
    private Integer likes;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 评论时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取供应链视频id
     *
     * @return cms_video_id - 供应链视频id
     */
    public Long getCmsVideoId() {
        return cmsVideoId;
    }

    /**
     * 设置供应链视频id
     *
     * @param cmsVideoId 供应链视频id
     */
    public void setCmsVideoId(Long cmsVideoId) {
        this.cmsVideoId = cmsVideoId;
    }

    /**
     * 获取评论用户id
     *
     * @return user_id - 评论用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置评论用户id
     *
     * @param userId 评论用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取评论用户
     *
     * @return user_name - 评论用户
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置评论用户
     *
     * @param userName 评论用户
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户头像
     *
     * @return user_pic - 用户头像
     */
    public String getUserPic() {
        return userPic;
    }

    /**
     * 设置用户头像
     *
     * @param userPic 用户头像
     */
    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    /**
     * 获取评论内容
     *
     * @return comment - 评论内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置评论内容
     *
     * @param comment 评论内容
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取评论图片地址
     *
     * @return comment_pic - 评论图片地址
     */
    public String getCommentPic() {
        return commentPic;
    }

    /**
     * 设置评论图片地址
     *
     * @param commentPic 评论图片地址
     */
    public void setCommentPic(String commentPic) {
        this.commentPic = commentPic;
    }

    /**
     * 获取点赞数
     *
     * @return likes - 点赞数
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * 设置点赞数
     *
     * @param likes 点赞数
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * 获取乐观锁
     *
     * @return version - 乐观锁
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置乐观锁
     *
     * @param version 乐观锁
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取评论时间
     *
     * @return create_date - 评论时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置评论时间
     *
     * @param createDate 评论时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}