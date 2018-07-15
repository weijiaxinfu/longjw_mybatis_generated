package com.xixi.longjw.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisComponent {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        if (!this.stringRedisTemplate.hasKey(key)) {
            ops.set(key, value);
            System.out.println(key + "=" + value);
        } else {
            System.out.println("已经存在的key=" + ops.get(key));
        }
    }

    public Object get(String key)
    {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    public void del(String key)
    {
        this.stringRedisTemplate.delete(key);
    }
}
