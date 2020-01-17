package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_tab")
public class ScmTab {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标签名称
     */
    @Column(name = "tab_name")
    private String tabName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 数据状态(0 有效  1 无效)
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
     * 获取标签名称
     *
     * @return tab_name - 标签名称
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * 设置标签名称
     *
     * @param tabName 标签名称
     */
    public void setTabName(String tabName) {
        this.tabName = tabName;
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
     * 获取数据状态(0 有效  1 无效)
     *
     * @return state - 数据状态(0 有效  1 无效)
     */
    public String getState() {
        return state;
    }

    /**
     * 设置数据状态(0 有效  1 无效)
     *
     * @param state 数据状态(0 有效  1 无效)
     */
    public void setState(String state) {
        this.state = state;
    }
}