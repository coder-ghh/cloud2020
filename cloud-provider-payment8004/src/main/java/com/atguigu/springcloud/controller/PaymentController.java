package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private  String ServerPort;
    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:"+ServerPort+"\t"+ UUID.randomUUID().toString();

    }

    }

