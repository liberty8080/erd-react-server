package com.zhao.erdreact;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhao.erdreact.mapper")
public class ErdReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErdReactApplication.class, args);
    }

}
