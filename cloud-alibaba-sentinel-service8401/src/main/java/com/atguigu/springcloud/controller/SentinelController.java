package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping("/testA")
    public  String testA(){
        return  "testA------Success";
    }


    @GetMapping("/testB")
    public  String testB(){
        return  "testB------Success";
    }
}
