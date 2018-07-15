package com.xixi.longjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@EnableCaching
@SpringBootApplication

@MapperScan({"com.xixi.longjw.dao"})
public class LongjwApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongjwApplication.class, args);
    }
}
