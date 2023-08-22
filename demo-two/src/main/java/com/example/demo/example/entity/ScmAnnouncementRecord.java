package com.example.demo.example.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "scm_announcement_record")
public class ScmAnnouncementRecord {
    /**
     * 公告主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公告模板id
     */
    @Column(name = "template_id")
    private Long templateId;

    /**
     * 供应链 1 商家 2 商家和供应链都可用 3
     */
    private Byte type;

    /**
     * 公告名称
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否删除 是 ->1 or true | 否 -> 0 or false
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

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
     * 获取公告主键id
     *
     * @return id - 公告主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置公告主键id
     *
     * @param id 公告主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取公告模板id
     *
     * @return template_id - 公告模板id
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 设置公告模板id
     *
     * @param templateId 公告模板id
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取供应链 1 商家 2 商家和供应链都可用 3
     *
     * @return type - 供应链 1 商家 2 商家和供应链都可用 3
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置供应链 1 商家 2 商家和供应链都可用 3
     *
     * @param type 供应链 1 商家 2 商家和供应链都可用 3
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取公告名称
     *
     * @return title - 公告名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置公告名称
     *
     * @param title 公告名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取公告内容
     *
     * @return content - 公告内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置公告内容
     *
     * @param content 公告内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否删除 是 ->1 or true | 否 -> 0 or false
     *
     * @return is_delete - 是否删除 是 ->1 or true | 否 -> 0 or false
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 是 ->1 or true | 否 -> 0 or false
     *
     * @param isDelete 是否删除 是 ->1 or true | 否 -> 0 or false
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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