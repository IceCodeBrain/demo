package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan("com.example.demo.example.mapper")
@EnableCaching
@SpringBootApplication
public class DemoTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTwoApplication.class, args);
    }

}
