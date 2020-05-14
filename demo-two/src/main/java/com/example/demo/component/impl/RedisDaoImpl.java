
package com.example.demo.component.impl;


import com.example.demo.component.RedisDao;
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
        if ((keys != null ? keys.size() : 0) > 0) {
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
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean vSet(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
    public void hmSet(String key, String hashKey, Object value) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    @Override
    public Long hSize(final String key) {
        return redisTemplate.opsForHash().size(key);
    }


    @Override
    public void hmSetAll(String key, Map<String, Object> map) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.putAll(key, map);
    }

    @Override
    public Map<String, Object> hmGet(String key) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }

    @Override
    public Object hmGet(String key, String hashKey) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    @Override
    public Object hmDel(String key, String hashKey) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.delete(key, hashKey);
    }

    @Override
    public Long lSize(String key) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.size(key);
    }

    @Override
    public Object lRange(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (size == null) {
            return null;
        }
        return list.range(k, 0, size);

    }

    @Override
    public List<?> lRange(String k, long start, long end) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, start, end);
    }

    @Override
    public Object lindexFirst(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.index(k, 0);
    }

    @Override
    public Object lindex(String k, long index) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.index(k, index);
    }

    @Override
    public void lLeftPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.leftPush(k, v);
    }

    @Override
    public void lLeftPush(String k, Object v, boolean bool) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (bool && size != null) {
            list.remove(k, size, v);
        }
        list.leftPush(k, v);
    }

    @Override
    public void lLeftPushAll(String k, List<Object> lst) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.leftPushAll(k, lst);
    }

    @Override
    public void lRightPush(String k, Object v, boolean bool) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (bool && size != null) {
            list.remove(k, size, v);
        }
        list.rightPush(k, v);
    }

    @Override
    public void lRightPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    @Override
    public void lRightPushAll(String k, List<Object> lst) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPushAll(k, lst);
    }


    @Override
    public Object lLeftPop(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.leftPop(k);
    }

    @Override
    public Object lRightPop(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.rightPop(k);
    }


    @Override
    public Long lRemove(String k, long count, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.remove(k, count, v);
    }

    @Override
    public Long lRemove(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        Long size = list.size(k);
        if (size == null) {
            return 0L;
        }
        return list.remove(k, size, v);
    }

    @Override
    public void sAdd(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    @Override
    public Set<Object> sMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    @Override
    public void zAdd(String key, Object value, double score) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, score);

    }

    @Override
    public Set<Object> rangeByScore(String key, double score, double score1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, score, score1);
    }

    @Override
    public Set<Object> range(String key, long start, long end) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.range(key, start, end);
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double score, double score1, long start, long end) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.reverseRangeByScore(key, score, score1, start, end);
    }


    @Override
    public Long removeRangeByScore(String key, double score, double score1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.removeRangeByScore(key, score, score1);
    }

    @Override
    public Long removeRange(String key, long start, long end) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.removeRange(key, start, end);
    }

    @Override
    public void hmSetIncrement(String key, String hashKey, Long value) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.increment(key, hashKey, value);
    }

}
