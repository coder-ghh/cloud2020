package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //支持Nacos自动刷新功能
public class ConfigClientController {

    //会在Nacos中查找指定配置文件的config.info
    @Value("${config.info}")
    private  String ConfigInfo;

    @GetMapping("/config/info")
    public  String getConfigInfo(){
        return  ConfigInfo;
    }
}
