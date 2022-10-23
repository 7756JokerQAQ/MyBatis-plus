package com.atguigu.mybaitsplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper接口所在的包
//@MapperScan("com.atguigu.mybaitsplus.mapper")
public class MybaitsPlusApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybaitsPlusApplication.class, args);
    }

}
