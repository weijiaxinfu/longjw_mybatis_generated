package com.xixi.longjw;


import com.xixi.longjw.redis.RedisComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void setTest() {
        redisComponent.set("user", "liubaojiangxxx");
        Object res = redisComponent.get("user");
        System.out.println(res);
    }

    @Test
    public void getTest() {
        Object res = redisComponent.get("user");
        System.out.println(res);
    }

    @Test
    public void delTest() {
        redisComponent.del("user");
    }

}
