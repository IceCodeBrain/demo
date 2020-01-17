package com.example.demo.example.entity;

import javax.persistence.*;

@Table(name = "scm_cms_video_type")
public class ScmCmsVideoType {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 视频类型
     */
    private String type;

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
     * 获取父id
     *
     * @return pid - 父id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取视频类型
     *
     * @return type - 视频类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置视频类型
     *
     * @param type 视频类型
     */
    public void setType(String type) {
        this.type = type;
    }
}