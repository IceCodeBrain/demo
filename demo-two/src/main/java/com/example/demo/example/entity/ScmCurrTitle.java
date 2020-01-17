package com.example.demo.example.entity;


import javax.persistence.*;
import java.util.Date;

@Table(name = "scm_curr_title")
public class ScmCurrTitle {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课题名称
     */
    @Column(name = "title_name")
    private String titleName;

    /**
     * 封面url
     */
    @Column(name = "cover_url")
    private String coverUrl;

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
     * 数据状态(0 有效 1无效)
     */
    private String state;

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
     * 获取课题名称
     *
     * @return title_name - 课题名称
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * 设置课题名称
     *
     * @param titleName 课题名称
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    /**
     * 获取封面url
     *
     * @return cover_url - 封面url
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * 设置封面url
     *
     * @param coverUrl 封面url
     */
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
}