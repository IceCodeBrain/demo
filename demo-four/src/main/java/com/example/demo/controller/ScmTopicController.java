package com.example.demo.controller;

import com.example.demo.entity.ScmTopic;
import com.example.demo.service.ScmTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程表(ScmTopic)表控制层
 *
 * @author makejava
 * @since 2020-04-03 14:18:15
 */
@RestController
@RequestMapping("scmTopic")
public class ScmTopicController {


    @Autowired
    public ScmTopicController(ScmTopicService scmTopicService) {
        this.scmTopicService = scmTopicService;
    }

    /**
     * 服务对象
     */
    private ScmTopicService scmTopicService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ScmTopic selectOne(Long id) {
        return this.scmTopicService.queryById(id);
    }

}