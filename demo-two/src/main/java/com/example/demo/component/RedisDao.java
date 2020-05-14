
package com.example.demo.component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisDao接口类
 * @author pwb
 * @create 2019/8/27
 * @since 1.0.0
 */
public interface RedisDao {

    /**
     * 判断缓存中是否有对应的value
     */
    Boolean existsKey(String key);

    /**
     * 根据key获取key列表(key值可为模糊匹配---taskInfo:taskDetail:* <---> *代表任意字符)
     */
    Set<String> keys(String pattern);

    /**
     * 根据key删除对应的value
     *
     * @param key 键
     */
    void delete(String key);

    /**
     * 根据key获取个数
     *
     * @param key 键
     */
    int count(String key);

    /**
     * 批量删除对应的value
     *
     * @param keys 键
     */
    void delete(String[] keys);

    /**
     * 批量删除key(key值可为模糊匹配---taskInfo:taskDetail:* <---> *代表任意字符)
     *
     * @param pattern 键集合
     */
    Long deletePattern(String pattern);

    /**
     * 批量删除对应的value
     */
    Long delete(Set<String> keys);

    /**
     * 写入缓存(操作字符串)
     */
    boolean vSet(String key, Object value);

    /**
     * 写入缓存设置时效时间(操作字符串)
     */
    boolean vSet(String key, Object value, Long expireTime);

    /**
     * 缓存设置时效时间
     */
    Boolean setExpireTime(String key, Long expireTime, TimeUnit unit);


    /**
     * 读取缓存(操作字符串)
     *
     * @param key 键
     */
    Object vGet(String key);

    /**
     * 哈希 添加(操作hash)
     */
    void hmSet(String key, String hashKey, Object value);

    /**
     * 哈希 添加(操作hash)
     */
    void hmSetAll(String key, Map<String, Object> map);

    /**
     * 哈希获取数据(操作hash)
     */
    Map<String, Object> hmGet(String key);

    /**
     * 哈希获取数据(操作hash)
     */
    Object hmGet(String key, String hashKey);

    /**
     * 哈希大小
     */
    Long hSize(final String key);

    /**
     * 哈希删除数据(操作hash)
     */
    Object hmDel(String key, String hashKey);

    /**
     * 获取列表中个数
     *
     * @param k 键
     * @return Long
     */
    Long lSize(String k);

    /**
     * 通过其索引从列表获取第一个元素(操作list)
     *
     * @param key 键
     * @return Object
     */
    Object lindexFirst(String key);

    /**
     * 通过其索引从列表获取元素(操作list)
     *
     * @param key             键
     * @param index:索引位置,从0开始
     * @return Object
     */
    Object lindex(String key, long index);

    /**
     * 从左向右添加列表(操作list)
     *
     * @param k 键集合
     * @param v 值
     */
    void lLeftPush(String k, Object v);

    /**
     * 从左向右添加列表(操作list);如果bool=true,会删除列表中已经存在的数据,然后再进行添加(仅针对字符串列表,其它待测)
     */
    void lLeftPush(String k, Object v, boolean bool);

    /**
     * 从左向右添加列表(操作list)
     */
    void lLeftPushAll(String k, List<Object> lst);

    /**
     * 从右向左添加列表(操作list)
     */
    void lRightPush(String k, Object v);

    /**
     * 从右向左添加列表(操作list);如果bool=true,会删除列表中已经存在的数据,然后再进行添加(仅针对字符串列表,其它待测)
     */
    void lRightPush(String k, Object v, boolean bool);

    /**
     * 从右向左添加列表(操作list)
     */
    void lRightPushAll(String k, List<Object> lst);

    /**
     * 删除并获取列表中的第1个元素(操作list)
     */
    Object lLeftPop(String k);

    /**
     * 删除并获取列表中的最后1个元素(操作list)
     */
    Object lRightPop(String k);


    /**
     * 移除k中值为v的count个,返回删除的个数；如果没有这个元素则返回0(操作list)
     */
    Long lRemove(String k, long count, Object v);

    /**
     * 移除k中值为v的所有数据,返回删除的个数；如果没有这个元素则返回0(操作list)
     */
    Long lRemove(String k, Object v);

    /**
     * 根据key获取获取List列表(操作list)
     */
    Object lRange(String key);

    /**
     * 根据key获取列表中第start至end的数据(操作list)
     */
    List<?> lRange(String k, long start, long end);

    /**
     * 集合添加
     */
    void sAdd(String key, Object value);

    /**
     * 集合获取
     */
    Set<Object> sMembers(String key);

    /**
     * 有序集合添加
     */
    void zAdd(String key, Object value, double score);

    /**
     * 有序集合获取
     *
     * @return Set<Object>
     */
    Set<Object> rangeByScore(String key, double score, double score1);


    /**
     * 有序集合获取
     *
     * @return Set<Object>
     */
    Set<Object> range(String key, long start, long end);


    Set<Object> reverseRangeByScore(String key, double score, double score1, long start, long end);

    /**
     * 有序集合删除
     *
     * @return Long
     */
    Long removeRangeByScore(String key, double score, double score1);

    /**
     * 有序集合删除
     *
     * @return Long
     */
    Long removeRange(String key, long start, long end);

    /**
     * 将hashKey中储存的数字加上指定的增量值(操作hash)
     *
     * @param key 键
     */
    void hmSetIncrement(String key, String hashKey, Long value);

}
