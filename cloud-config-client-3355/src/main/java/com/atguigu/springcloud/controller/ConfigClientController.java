package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //自动获取刷新的内容
public class ConfigClientController {

    @Value("${server.port}")
    private  String ServerPort;

    @Value("${config.info}")
    private  String configInfo;

    @GetMapping("/configInfo")
    public  String getConfigInfo(){
        return  ServerPort+"---------"+configInfo;
    }
}
