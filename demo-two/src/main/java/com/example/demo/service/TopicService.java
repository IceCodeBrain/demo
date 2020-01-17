package com.example.demo.service;

import com.example.demo.service.model.dto.TopicDTO;
import com.example.demo.service.model.pojo.TopicBean;
import com.example.demo.service.model.vo.TopicVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description: TopicService <br>
 * @date: 2020/1/15 16:34 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public interface TopicService {

    void doAddAllTopic(List<TopicDTO> topicDTOS);

    Boolean doAddTopic(TopicDTO topicDTO);


    Boolean doUpdateTopic(TopicDTO topicDTO);

    Boolean doDeleteTopicById(Long id);

    TopicVO doGetTopicById(Long id);


    Page<TopicBean> doGetTopicByName(String name,int page, int size);


    Page<TopicBean> doFindAllTopic(int page, int size);
}
