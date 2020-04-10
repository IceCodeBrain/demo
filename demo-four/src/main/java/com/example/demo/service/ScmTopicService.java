package com.example.demo.service;

import com.example.demo.entity.ScmTopic;
import com.example.demo.entity.model.ScmTopicVO;
import com.github.pagehelper.PageInfo;

/**
 * @description: 课程表(ScmTopic)表服务接口 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 15:22:18 <br>
 */

public interface ScmTopicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScmTopic getScmTopicById(Long id);


    PageInfo<ScmTopicVO> queryScmTopicByPage(Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    ScmTopic addScmTopic(ScmTopic scmTopic);

    /**
     * 修改数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    ScmTopic updateScmTopic(ScmTopic scmTopic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteScmTopicById(Long id);

}
