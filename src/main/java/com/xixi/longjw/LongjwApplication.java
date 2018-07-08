package com.xixi.longjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xixi.longjw.dao")
public class LongjwApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongjwApplication.class, args);
    }
}
