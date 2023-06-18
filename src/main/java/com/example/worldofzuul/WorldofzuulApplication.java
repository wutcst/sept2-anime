package com.example.worldofzuul;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.worldofzuul.mapper")
public class WorldofzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldofzuulApplication.class, args);
    }

}
