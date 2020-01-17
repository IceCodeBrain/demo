package com.example.demo.example.entity;

import javax.persistence.*;

@Table(name = "scm_act_share_record")
public class ScmActShareRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 素材id
     */
    @Column(name = "act_id")
    private Long actId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

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
     * 获取素材id
     *
     * @return act_id - 素材id
     */
    public Long getActId() {
        return actId;
    }

    /**
     * 设置素材id
     *
     * @param actId 素材id
     */
    public void setActId(Long actId) {
        this.actId = actId;
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
}