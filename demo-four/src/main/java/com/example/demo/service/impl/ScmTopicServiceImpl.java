package com.example.demo.service.impl;

import com.example.demo.entity.ScmTopic;
import com.example.demo.dao.ScmTopicDao;
import com.example.demo.service.ScmTopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程表(ScmTopic)表服务实现类
 *
 * @author makejava
 * @since 2020-04-03 14:18:14
 */
@Service
public class ScmTopicServiceImpl implements ScmTopicService {
    @Resource
    private ScmTopicDao scmTopicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ScmTopic queryById(Long id) {
        return this.scmTopicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ScmTopic> queryAllByLimit(int offset, int limit) {
        return this.scmTopicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    @Override
    public ScmTopic insert(ScmTopic scmTopic) {
        this.scmTopicDao.insert(scmTopic);
        return scmTopic;
    }

    /**
     * 修改数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    @Override
    public ScmTopic update(ScmTopic scmTopic) {
        this.scmTopicDao.update(scmTopic);
        return this.queryById(scmTopic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.scmTopicDao.deleteById(id) > 0;
    }
}
