package com.example.juwuheback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.juwuheback.mapper")
public class JuwuheBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuwuheBackApplication.class, args);
    }

}
