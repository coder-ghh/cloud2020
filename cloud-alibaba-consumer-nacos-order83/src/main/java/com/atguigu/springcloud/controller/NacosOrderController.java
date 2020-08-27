package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class NacosOrderController {
    @Value("${server.port}")
    private  String port;

    @Value("${service-url.nacos-user-service}")
    private  String service_url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public  String  paymentInfo(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(service_url+"/payment/nacos/"+id,String.class);
    }



}
