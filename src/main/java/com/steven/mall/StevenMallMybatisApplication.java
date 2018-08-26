package com.steven.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.steven.mall.mapper")
public class StevenMallMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(StevenMallMybatisApplication.class, args);
    }
}
