package com.xixi.longjw.redisconf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {

    /**
     * 自定义缓存管理器.
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
// 设置默认的过期时间
        cacheManager.setDefaultExpiration(20);
        Map<String, Long> expires = new HashMap<String, Long>();
// 单独设置
        expires.put("personCache", 200L);
        cacheManager.setExpires(expires);
        return cacheManager;

    }
    //自定义 key  的生成策略

    /**
     * 自定义 key. 此方法将会根据类名+方法名+所有参数的值生成唯一的一个 key,即使@Cacheable 中
     * 的 value 属性一样，key 也会不一样。
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
