package com.example.demo.service;

import com.example.demo.entity.ScmTopic;
import java.util.List;

/**
 * 课程表(ScmTopic)表服务接口
 *
 * @author makejava
 * @since 2020-04-03 14:18:14
 */
public interface ScmTopicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScmTopic queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScmTopic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    ScmTopic insert(ScmTopic scmTopic);

    /**
     * 修改数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    ScmTopic update(ScmTopic scmTopic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}