package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderMain9001.class, args);
    }

}
