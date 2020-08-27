package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id){


        String result = paymentHystrixService.paymentInfo_OK(id);
        return  result;
    }

    //设置服务降级
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties =
//            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public  String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }


    public  String paymentInfo_TimeoutHandler(Integer id){
        return  "我是cloud-consumer-feign-hystrix-order80,服务器繁忙或者报错请稍后再试!, paymentInfo_TimeoutHandler,id:"+id;
    }

    //全局fallback方法
    public  String payment_Global_FallbackMethod(){
        return "全局fallback方法执行成功,请稍后重试!!!";
    }

}
