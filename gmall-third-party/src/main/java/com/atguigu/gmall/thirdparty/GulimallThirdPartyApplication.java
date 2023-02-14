package com.atguigu.gmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class gmallThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(gmallThirdPartyApplication.class, args);
    }

}
