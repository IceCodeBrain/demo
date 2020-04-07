package com.example.demo.controller;

import com.example.demo.entity.ScmTopic;
import com.example.demo.service.ScmTopicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

}