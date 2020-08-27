package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping("/consumer/feign/payment/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return  orderFeignService.getPayment(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public  String paymentFeignTimeout(){
        //OpenFeign-ribbon,客户端一般默认等待1秒钟
        return  orderFeignService.paymentFeignTimeout();
    }

}
