package com.example.demo.service;

import com.example.demo.entity.ScmTopic;
import java.util.List;

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

/**
* 查询多条数据
*
* @param offset 查询起始位置
* @param limit 查询条数
* @return 对象列表
*/
List<ScmTopic> queryScmTopicByPage(int offset, int limit);

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