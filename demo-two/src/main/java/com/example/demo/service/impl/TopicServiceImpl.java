package com.example.demo.service.impl;

import com.example.demo.repository.TopicESRepository;
import com.example.demo.service.TopicService;
import com.example.demo.service.model.dto.TopicDTO;
import com.example.demo.service.model.pojo.TopicBean;
import com.example.demo.service.model.vo.TopicVO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @description: TopicServiceImpl <br>
 * @date: 2020/1/15 16:34 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Service
public class TopicServiceImpl implements TopicService {


    @Autowired
    private TopicESRepository topicESRepository;


    @Override
    public void doAddAllTopic(List<TopicDTO> topicDTOS) {
        TopicBean topicBean = new TopicBean();
        List<TopicBean> topicBeans = Lists.newLinkedList();
        Date date = new Date();
        for (TopicDTO topicDTO : topicDTOS) {
            topicBean = new TopicBean();
            BeanUtils.copyProperties(topicDTO, topicBean);
            topicBean.setUpdateTime(date);
            topicBean.setCreateTime(date);
            topicBeans.add(topicBean);
        }
       topicESRepository.saveAll(topicBeans);
    }

    @Override
    public Boolean doAddTopic(TopicDTO topicDTO) {
        TopicBean topicBean = new TopicBean();
        BeanUtils.copyProperties(topicDTO, topicBean);
        topicBean.setCreateTime(new Date());
        topicBean.setUpdateTime(new Date());
        topicESRepository.save(topicBean);
        return true;
    }

    @Override
    public Boolean doUpdateTopic(TopicDTO topicDTO) {
        TopicBean topicBean = new TopicBean();
        BeanUtils.copyProperties(topicDTO, topicBean);
        topicBean.setCreateTime(new Date());
        topicBean.setUpdateTime(new Date());
        topicESRepository.save(topicBean);
        return true;
    }

    @Override
    public Boolean doDeleteTopicById(Long id) {
        topicESRepository.deleteById(id);
        return true;
    }

    @Override
    public TopicVO doGetTopicById(Long id) {
        Optional<TopicBean> optionalTopicBean = topicESRepository.findById(id);
        if (optionalTopicBean.isPresent()) {
            TopicBean topicBean = optionalTopicBean.get();
            TopicVO topicVO = new TopicVO();
            BeanUtils.copyProperties(topicBean, topicVO);
            return topicVO;
        }
        return null;
    }

    @Override
    public Page<TopicBean> doGetTopicByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return topicESRepository.findByName(name, pageable);
    }


    @Override
    public Page<TopicBean> doFindAllTopic(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return topicESRepository.findAll(pageable);
    }
}
