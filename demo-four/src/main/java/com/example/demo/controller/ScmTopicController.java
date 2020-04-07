package com.example.demo.controller;

import com.example.demo.entity.ScmTopic;
import com.example.demo.service.ScmTopicService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @description: 课程表(ScmTopic)表控制层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 13:49:37 <br>
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
@GetMapping("selectOne")
public ScmTopic selectOne(Long id) {
return this.scmTopicService.getScmTopicById(id);
}

}