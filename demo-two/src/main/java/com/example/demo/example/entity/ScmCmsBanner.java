package com.example.demo.example.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "scm_cms_banner")
public class ScmCmsBanner {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 供应链 ->1 | 商家->2 | 商家和供应链都可用-> 3 ...
     */
    @Column(name = "banner_type")
    private Byte bannerType;

    /**
     * 图片名
     */
    @Column(name = "img_name")
    private String imgName;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 跳转地址
     */
    @Column(name = "jump_url")
    private String jumpUrl;

    /**
     * 跳转类型 内部模块->1 | H5->2  其他->3 .....
     */
    @Column(name = "jump_type")
    private Byte jumpType;

    /**
     * 排序 1<-2<-3<-4-<5 .......
     */
    private Integer sort;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

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
     * 获取供应链 ->1 | 商家->2 | 商家和供应链都可用-> 3 ...
     *
     * @return banner_type - 供应链 ->1 | 商家->2 | 商家和供应链都可用-> 3 ...
     */
    public Byte getBannerType() {
        return bannerType;
    }

    /**
     * 设置供应链 ->1 | 商家->2 | 商家和供应链都可用-> 3 ...
     *
     * @param bannerType 供应链 ->1 | 商家->2 | 商家和供应链都可用-> 3 ...
     */
    public void setBannerType(Byte bannerType) {
        this.bannerType = bannerType;
    }

    /**
     * 获取图片名
     *
     * @return img_name - 图片名
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 设置图片名
     *
     * @param imgName 图片名
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * 获取图片地址
     *
     * @return img_url - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取跳转地址
     *
     * @return jump_url - 跳转地址
     */
    public String getJumpUrl() {
        return jumpUrl;
    }

    /**
     * 设置跳转地址
     *
     * @param jumpUrl 跳转地址
     */
    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    /**
     * 获取跳转类型 内部模块->1 | H5->2  其他->3 .....
     *
     * @return jump_type - 跳转类型 内部模块->1 | H5->2  其他->3 .....
     */
    public Byte getJumpType() {
        return jumpType;
    }

    /**
     * 设置跳转类型 内部模块->1 | H5->2  其他->3 .....
     *
     * @param jumpType 跳转类型 内部模块->1 | H5->2  其他->3 .....
     */
    public void setJumpType(Byte jumpType) {
        this.jumpType = jumpType;
    }

    /**
     * 获取排序 1<-2<-3<-4-<5 .......
     *
     * @return sort - 排序 1<-2<-3<-4-<5 .......
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序 1<-2<-3<-4-<5 .......
     *
     * @param sort 排序 1<-2<-3<-4-<5 .......
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
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