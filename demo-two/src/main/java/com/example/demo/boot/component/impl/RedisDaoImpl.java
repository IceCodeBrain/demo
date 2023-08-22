package com.example.demo.boot.component.impl;


import com.example.demo.boot.component.RedisDao;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author pwb
 * @create 2019/8/27
 * @since 1.0.0
 */
@Repository("redisDao")
public class RedisDaoImpl implements RedisDao {

    @Resource
    protected RedisTemplate<String, Object> redisTemplate;

    @Override
    public Boolean existsKey(final String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Set<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }

    @Override
    public void delete(final String key) {
        Boolean exist = existsKey(key);
        if (exist != null && exist) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public int count(final String key) {
        Set<String> strings = redisTemplate.keys(key);
        if (strings == null) {
            return 0;
        }
        return strings.size();
    }

    @Override
    public Long deletePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys != null && !keys.isEmpty()) {
            return redisTemplate.delete(keys);
        } else {
            return 0L;
        }
    }

    @Override
    public void delete(final String[] keys) {
        for (String key : keys) {
            delete(key);
        }
    }

    @Override
    public Long delete(final Set<String> keys) {
        return redisTemplate.delete(keys);
    }

    @Override
    public boolean vSet(final String key, Object value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        return true;
    }

    @Override
    public boolean vSet(final String key, Object value, Long expireTime) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        return true;
    }

    @Override
    public Boolean setExpireTime(final String key, Long expireTime, TimeUnit unit) {
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey != null && hasKey) {
            return redisTemplate.expire(key, expireTime, unit);
        }
        return true;
    }

    @Override
    public Object vGet(final String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    @Override
    public Long vIncrement(String key, long delta) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        return operations.increment(key, delta);
    }

    @Override
    public void hashPut(String key, String hashKey, Object value) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    @Override
    public Long hashSize(final String key) {
        return redisTemplate.opsForHash().size(key);
    }


    @Override
    public void hashPutAll(String key, Map<String, Object> map) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.putAll(key, map);
    }

    @Override
    public Map<String, Object> hashGet(String key) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }

    @Override
    public Object hashGet(String key, String hashKey) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    @Override
    public Object hashDelete(String key, String hashKey) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.delete(key, hashKey);
    }

    @Override
    public void hashIncrement(String key, String hashKey, Long value) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.increment(key, hashKey, value);
    }


    @Override
    public Long listSize(String key) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.size(key);
    }

    @Override
    public Object listRange(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (size == null) {
            return null;
        }
        return list.range(k, 0, size);

    }

    @Override
    public List<?> listRange(String k, long start, long end) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, start, end);
    }

    @Override
    public Object listIndexFirst(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.index(k, 0);
    }

    @Override
    public Object listIndex(String k, long index) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.index(k, index);
    }

    @Override
    public void listLeftPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.leftPush(k, v);
    }

    @Override
    public void listLeftPush(String k, Object v, boolean bool) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (bool && size != null) {
            list.remove(k, size, v);
        }
        list.leftPush(k, v);
    }

    @Override
    public void listLeftPushAll(String k, List<Object> lst) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.leftPushAll(k, lst);
    }

    @Override
    public void listRightPush(String k, Object v, boolean bool) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (bool && size != null) {
            list.remove(k, size, v);
        }
        list.rightPush(k, v);
    }

    @Override
    public void listRightPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    @Override
    public void listRightPushAll(String k, List<Object> lst) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPushAll(k, lst);
    }


    @Override
    public Object listLeftPop(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.leftPop(k);
    }

    @Override
    public Object listRightPop(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.rightPop(k);
    }


    @Override
    public Long listRemove(String k, long count, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.remove(k, count, v);
    }

    @Override
    public Long listRemove(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (size == null) {
            return 0L;
        }
        return list.remove(k, size, v);
    }

    @Override
    public void setAdd(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    @Override
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    @Override
    public void zSetAdd(String key, Object value, double score) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, score);

    }

    @Override
    public Set<Object> zSetRangeByScore(String key, double score, double score1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, score, score1);
    }

    @Override
    public Set<Object> zSetRange(String key, long start, long end) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.range(key, start, end);
    }

    @Override
    public Set<Object> zSetReverseRangeByScore(String key, double score, double score1, long start, long end) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.reverseRangeByScore(key, score, score1, start, end);
    }


    @Override
    public Long zSetRemoveRangeByScore(String key, double score, double score1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.removeRangeByScore(key, score, score1);
    }

    @Override
    public Long zSetRemoveRange(String key, long start, long end) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.removeRange(key, start, end);
    }


}
