package com.example.demo.example.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "scm_problem_feedback")
public class ScmProblemFeedback {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 问题分类id
     */
    @Column(name = "problem_type_id")
    private Long problemTypeId;

    /**
     * 问题
     */
    private String problem;

    /**
     * 问题描述图片
     */
    @Column(name = "problem_pic")
    private String problemPic;

    /**
     * 提交问题用户id
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 回复状态
     */
    @Column(name = "reply_status")
    private Byte replyStatus;

    /**
     * 回复人id
     */
    @Column(name = "reply_by")
    private Long replyBy;

    /**
     * 回复日期
     */
    @Column(name = "reply_date")
    private Date replyDate;

    /**
     * 是否是常见问题
     */
    @Column(name = "common_problem")
    private Byte commonProblem;

    /**
     * 排序(值越大越在前)
     */
    private Long sort;

    /**
     * 解答
     */
    private String reply;

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
     * 获取问题分类id
     *
     * @return problem_type_id - 问题分类id
     */
    public Long getProblemTypeId() {
        return problemTypeId;
    }

    /**
     * 设置问题分类id
     *
     * @param problemTypeId 问题分类id
     */
    public void setProblemTypeId(Long problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    /**
     * 获取问题
     *
     * @return problem - 问题
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置问题
     *
     * @param problem 问题
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * 获取问题描述图片
     *
     * @return problem_pic - 问题描述图片
     */
    public String getProblemPic() {
        return problemPic;
    }

    /**
     * 设置问题描述图片
     *
     * @param problemPic 问题描述图片
     */
    public void setProblemPic(String problemPic) {
        this.problemPic = problemPic;
    }

    /**
     * 获取提交问题用户id
     *
     * @return create_by - 提交问题用户id
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置提交问题用户id
     *
     * @param createBy 提交问题用户id
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取回复状态
     *
     * @return reply_status - 回复状态
     */
    public Byte getReplyStatus() {
        return replyStatus;
    }

    /**
     * 设置回复状态
     *
     * @param replyStatus 回复状态
     */
    public void setReplyStatus(Byte replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 获取回复人id
     *
     * @return reply_by - 回复人id
     */
    public Long getReplyBy() {
        return replyBy;
    }

    /**
     * 设置回复人id
     *
     * @param replyBy 回复人id
     */
    public void setReplyBy(Long replyBy) {
        this.replyBy = replyBy;
    }

    /**
     * 获取回复日期
     *
     * @return reply_date - 回复日期
     */
    public Date getReplyDate() {
        return replyDate;
    }

    /**
     * 设置回复日期
     *
     * @param replyDate 回复日期
     */
    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    /**
     * 获取是否是常见问题
     *
     * @return common_problem - 是否是常见问题
     */
    public Byte getCommonProblem() {
        return commonProblem;
    }

    /**
     * 设置是否是常见问题
     *
     * @param commonProblem 是否是常见问题
     */
    public void setCommonProblem(Byte commonProblem) {
        this.commonProblem = commonProblem;
    }

    /**
     * 获取排序(值越大越在前)
     *
     * @return sort - 排序(值越大越在前)
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序(值越大越在前)
     *
     * @param sort 排序(值越大越在前)
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取解答
     *
     * @return reply - 解答
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置解答
     *
     * @param reply 解答
     */
    public void setReply(String reply) {
        this.reply = reply;
    }
}