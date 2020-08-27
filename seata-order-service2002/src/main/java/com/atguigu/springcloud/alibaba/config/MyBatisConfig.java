package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.atguigu.springcloud.alibaba.dao"})//指定我们的接口的位置
public class MyBatisConfig {
}
