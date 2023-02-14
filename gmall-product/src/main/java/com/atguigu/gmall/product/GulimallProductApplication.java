package com.atguigu.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.atguigu.gmall.product.feign")
@MapperScan("com.atguigu.gmall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class gmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(gmallProductApplication.class, args);
    }

}
