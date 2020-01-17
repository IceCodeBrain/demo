/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: AbstractBaseRedisDao
 * Author:   pwb
 * Date:     2019/8/27 18:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * frank           修改时间           1.0.0              ycypApp
 */
package com.example.demo.component.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author pwb
 * @create 2019/8/27
 * @since 1.0.0
 */
public abstract class AbstractBaseRedisDao<K, V> {

    // @Resource(name = "redisTemplate")
    @Resource
    protected RedisTemplate<K, V> redisTemplate;

    /**
     * 设置redisTemplate
     *
     * @param redisTemplate
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取 RedisSerializer
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }
}