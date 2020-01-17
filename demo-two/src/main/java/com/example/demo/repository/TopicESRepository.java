package com.example.demo.repository;

import com.example.demo.service.model.pojo.TopicBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description: TopicESRepository <br>
 * @date: 2020/1/15 16:33 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public interface TopicESRepository extends ElasticsearchRepository<TopicBean, Long> {

    //默认的注释
    //@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
    Page<TopicBean> findByName(String name, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"id\" : \"?\"}}}}")
    Page<TopicBean> findByCurrTitleId(Long currTitleId, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"releaseState.keyword\" : \"?\"}}}}")
    Page<TopicBean> findByReleaseState(String releaseState, Pageable pageable);

}
