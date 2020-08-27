package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//配置feign的日志
@Configuration
public class FeignConfig {
@Bean
    Logger.Level feignLoggerLevel(){
    return  Logger.Level.FULL;
}
}
