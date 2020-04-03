package com.example.demo.dao;

import com.example.demo.entity.ScmTopic;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 课程表(ScmTopic)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-03 14:18:13
 */
public interface ScmTopicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScmTopic queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScmTopic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scmTopic 实例对象
     * @return 对象列表
     */
    List<ScmTopic> queryAll(ScmTopic scmTopic);

    /**
     * 新增数据
     *
     * @param scmTopic 实例对象
     * @return 影响行数
     */
    int insert(ScmTopic scmTopic);

    /**
     * 修改数据
     *
     * @param scmTopic 实例对象
     * @return 影响行数
     */
    int update(ScmTopic scmTopic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}