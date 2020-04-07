package com.example.demo.controller;

import com.example.demo.entity.ScmTopic;
import com.example.demo.service.ScmTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: 课程表(ScmTopic)表控制层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 10:33:29 <br>
 */

@RestController
@RequestMapping("scmTopic")
public class ScmTopicController {

    /**
     * 服务对象
     */
    private ScmTopicService scmTopicService;

    @Autowired
    public ScmTopicController(ScmTopicService scmTopicService) {
        this.scmTopicService = scmTopicService;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    /**
     * @description: selectOne <br>
     * @since: 1.0 <br>
     * @date: 2020/4/7 10:35 <br>
     * @author: PWB <br>
     * @param id <br>
     * @return com.example.demo.entity.ScmTopic <br>
     */
    @GetMapping("selectOne")
    public ScmTopic selectOne(Long id) {
        return this.scmTopicService.getScmTopicById(id);
    }

}
