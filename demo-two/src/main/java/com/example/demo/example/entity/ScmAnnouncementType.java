package com.example.demo.example.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "scm_announcement_type")
public class ScmAnnouncementType {
    /**
     * 公告类型id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公告分类名称
     */
    @Column(name = "announcement_name")
    private String announcementName;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取公告类型id
     *
     * @return id - 公告类型id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置公告类型id
     *
     * @param id 公告类型id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取公告分类名称
     *
     * @return announcement_name - 公告分类名称
     */
    public String getAnnouncementName() {
        return announcementName;
    }

    /**
     * 设置公告分类名称
     *
     * @param announcementName 公告分类名称
     */
    public void setAnnouncementName(String announcementName) {
        this.announcementName = announcementName;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
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