package com.example.demo.service.impl;

import com.example.demo.entity.ScmTopic;
import com.example.demo.dao.ScmTopicDao;
import com.example.demo.service.ScmTopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 课程表(ScmTopic)表服务实现类 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 13:49:37 <br>
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
public ScmTopic getScmTopicById(Long id) {
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
public List<ScmTopic> queryScmTopicByPage(int offset, int limit) {
return null;
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
}