/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RedisCacheConfig
 * Author:   pwb
 * Date:     2019/8/28 10:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * frank           修改时间           1.0.0              ycypApp
 */
package com.example.demo.boot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * 〈〉
 *
 * @author pwb
 * @create 2019/8/28
 * @since 1.0.0
 */
@Configuration
public class RedisCacheConfig {
    //过期时间1天
    private Duration timeToLive = Duration.ofDays(60);

/*
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))//缓存1天
                // .computePrefixWith(cacheName -> "miaosha1".concat(":").concat(cacheName).concat(":"))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new
                        StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new
                        GenericJackson2JsonRedisSerializer()))
                .disableCachingNullValues();
        // 设置一个初始化的缓存空间set集合
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("my-redis-cache1");
        cacheNames.add("user");

        // 对每个缓存空间应用不同的配置
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("my-redis-cache1", cacheConfiguration);
        configMap.put("user", cacheConfiguration.entryTtl(Duration.ofSeconds(120)));
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)     // 使用自定义的缓存配置初始化一个cacheManager
                .initialCacheNames(cacheNames)  // 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置
                .withInitialCacheConfigurations(configMap)
                .build();
        return cacheManager;
    }
*/


    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        //默认1
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(this.timeToLive)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new
                        StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new
                        GenericJackson2JsonRedisSerializer()))
                .disableCachingNullValues();
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
    }


    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //key hashMap序列化
        template.setHashKeySerializer(redisSerializer);

        RedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);


        //value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //value hashMap序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);

        //
        return template;
    }

    /**
     * 设置  全限定类名 + 方法名 + 参数名 共同组成 key
     * key生成策略
     */
    /*@Bean
    public KeyGenerator accountKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder(16);
                sb.append(target.getClass().getName());
                sb.append("_");
                sb.append(method.getName());
                sb.append("_");
                for (int i = 0; i < params.length; i++) {
                    sb.append(params[i]);
                    if (i < params.length - 1) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        };
    }*/


}
