package com.example.demo.dao;

import com.example.demo.entity.ScmTopic;
import com.example.demo.boot.core.TKMapper;

/**
 * @description: 课程表(ScmTopic)表数据库访问层 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 * @date: 2020-04-07 15:22:17 <br>
 */

public interface ScmTopicDao extends TKMapper<ScmTopic>{

/**
* 通过ID查询单条数据
*
* @param id 主键
* @return 实例对象
*/
ScmTopic queryById(Long id);





}
