package com.example.demo.controller;

import com.example.demo.entity.ScmTopic;
import com.example.demo.entity.model.ScmTopicVO;
import com.example.demo.service.ScmTopicService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 课程表(ScmTopic)表控制层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 15:50:26 <br>
 */

@Api(tags = "课程表相关功能API")
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
    @ApiOperation("get查询")
    @GetMapping("selectOne")
    public ScmTopic selectOne(@ApiParam("id") @RequestParam Long id) {
        return this.scmTopicService.getScmTopicById(id);
    }


    @ApiOperation("get查询")
    @GetMapping("selectByPage")
    public PageInfo<ScmTopicVO> queryScmTopicByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return this.scmTopicService.queryScmTopicByPage(pageNum, pageSize);
    }
}
