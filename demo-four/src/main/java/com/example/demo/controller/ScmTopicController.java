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



    /**
     *
    *
    *默认情况下你无法使用@Transactional对一个非public的方法进行事务管理
    *
    * 出现了自调用。什么是自调用呢？我们看个例子
    * */
    /**
     * @description: 事务失效 <br>
     *     数据库层面，数据库使用的存储引擎是否支持事务？默认情况下MySQL数据库使用的是Innodb存储引擎（5.5版本之后），
     *     它是支持事务的，但是如果你的表特地修改了存储引擎，
     *     例如，你通过下面的语句修改了表使用的存储引擎为MyISAM，而MyISAM又是不支持事务的<br>
     *         我们要使用Spring的声明式事务，那么需要执行事务的Bean是否已经交由了Spring管理？
     *         在代码中的体现就是类上是否有@Service、Component等一系列注解<br>
     *     默认情况下你无法使用@Transactional对一个非public的方法进行事务管理 <br>
     *         出现了自调用<br>
     *
     * @since: 1.0 <br>
     * @date: 2020/8/21 11:09 <br>
     * @author: PWB <br>
     * @return void <br>
     */
    @ApiOperation("测试事务")
    @GetMapping("testTransactional")
    public void testTransactional() {
        scmTopicService.testTransactional();
    }
}
