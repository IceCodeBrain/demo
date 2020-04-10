package com.example.demo.service.impl;

import com.example.demo.dao.ScmTopicDao;
import com.example.demo.entity.ScmTopic;
import com.example.demo.entity.model.ScmTopicVO;
import com.example.demo.service.ScmTopicService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 课程表(ScmTopic)表服务实现类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 15:22:18 <br>
 */

@Slf4j
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
    public ScmTopic getScmTopicById(Long id) {
        return this.scmTopicDao.queryById(id);
    }

    @Override
    public PageInfo<ScmTopicVO> queryScmTopicByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ScmTopic> pageInfo = new PageInfo<>(scmTopicDao.selectAll());
        log.info("pageInfo::{}", pageInfo);
        PageInfo<ScmTopic> pageInfo2 = new PageInfo<>(scmTopicDao.selectAll());
        log.info("pageInfo2::{}", pageInfo);
        Page<ScmTopicVO> page = new Page<>(pageNum, pageSize);
        page.setTotal(pageInfo2.getTotal() + pageInfo.getTotal());
        PageInfo<ScmTopicVO> topicVOPageInfo = new PageInfo<>(page);
        List<ScmTopicVO> scmTopicVOS = new LinkedList<>();
        ScmTopicVO scmTopicVO;
        for (ScmTopic scmTopic : pageInfo.getList()) {
            scmTopicVO = new ScmTopicVO();
            BeanUtils.copyProperties(scmTopic,scmTopicVO);
            scmTopicVOS.add(scmTopicVO);
        }
        topicVOPageInfo.setList(scmTopicVOS);

        return topicVOPageInfo;
    }

    /**
     * 新增数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    @Override
    public ScmTopic addScmTopic(ScmTopic scmTopic) {

        return null;
    }

    /**
     * 修改数据
     *
     * @param scmTopic 实例对象
     * @return 实例对象
     */
    @Override
    public ScmTopic updateScmTopic(ScmTopic scmTopic) {

        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteScmTopicById(Long id) {
        return null;
    }


    /**
     * 将PageInfo对象泛型中的Po对象转化为Vo对象
     *
     * @param pageInfoPo PageInfo<Po>对象</>
     * @param <P>        Po类型
     * @param <V>        Vo类型
     * @return
     */
    public <P, V> PageInfo<V> PageInfo2PageInfoVo(PageInfo<P> pageInfoPo) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<V> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        page.setTotal(pageInfoPo.getTotal());
        return new PageInfo<>(page);
    }

}
