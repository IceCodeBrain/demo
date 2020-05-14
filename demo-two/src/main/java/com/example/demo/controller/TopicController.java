package com.example.demo.controller;

import com.example.demo.boot.restful.RestResponse;
import com.example.demo.boot.restful.RestResult;
import com.example.demo.service.TopicService;
import com.example.demo.service.model.dto.TopicDTO;
import com.example.demo.service.model.pojo.TopicBean;
import com.example.demo.service.model.vo.TopicVO;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: TopicController <br>
 * @date: 2020/1/15 16:59 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Api(tags = " 课程相关api ")
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @ApiOperation("初始化添加数据运行一次")
    @GetMapping("/doInit")
    public void doInit() {
        List<TopicDTO> topicDTOS = Lists.newLinkedList();
        TopicDTO topicDTO;
        for (int i = 0; i < 1; i++) {
            topicDTO = new TopicDTO();
            topicDTO.setCoverUrl("https://image-store-all.oss-cn-beijing.aliyuncs.com/NKB8BGEhKe.png");
            topicDTO.setId((long) i);
            topicDTO.setCurrDetail("皇冠" + i);
            topicDTO.setCurrTitleId((long) i);
            topicDTO.setName("心魔" + i);
            topicDTO.setRemark("备注" + i);
            topicDTO.setType("type" + i);
            topicDTOS.add(topicDTO);
        }
        topicService.doAddAllTopic(topicDTOS);
    }


    @ApiOperation("添加课程")
    @PostMapping("/doAddTopic")
    public RestResult<Boolean> doAddTopic(@RequestBody TopicDTO topicDTO) {
        return RestResponse.ok(topicService.doAddTopic(topicDTO));
    }

    @ApiOperation("更新课程")
    @PutMapping("/doUpdateTopic")
    public RestResult<Boolean> doUpdateTopic(@RequestBody TopicDTO topicDTO) {
        return RestResponse.ok(topicService.doUpdateTopic(topicDTO));
    }

    @ApiOperation("通过课程id删除课程")
    @DeleteMapping("/doDeleteTopicById")
    public RestResult<Boolean> doDeleteTopicById(@RequestParam Long id) {
        return RestResponse.ok(topicService.doDeleteTopicById(id));
    }


    @ApiOperation("通过课程id获取课程")
    @GetMapping("/doGetTopicById")
    public RestResult<TopicVO> doGetTopicById(@RequestParam Long id) {
        return RestResponse.ok(topicService.doGetTopicById(id));
    }


    @ApiOperation("通过课程名称获取课程")
    @GetMapping("/doGetTopicByName")
    public RestResult<Page<TopicBean>> doGetTopicByName(@RequestParam String name, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return RestResponse.ok(topicService.doGetTopicByName(name, page, size));
    }


    @ApiOperation("获取所有课程")
    @GetMapping("/doFindAllTopic")
    public RestResult<Page<TopicBean>> doFindAllTopic(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return RestResponse.ok(topicService.doFindAllTopic(page, size));
    }

}
