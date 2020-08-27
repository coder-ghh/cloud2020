package com.atguigu.springcloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源的自动创建
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.atguigu.springcloud.alibaba.dao")
public class SeataAccountMain2004 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain2004.class, args);
    }
}
