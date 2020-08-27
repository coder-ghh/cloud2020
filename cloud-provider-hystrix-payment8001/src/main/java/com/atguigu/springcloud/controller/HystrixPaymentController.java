package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixPaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
   private  String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_OK(id);
        log.info(s);
        return  s;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public  String paymentInfo_Timeout(@PathVariable("id") Integer id) throws InterruptedException {
        String s = paymentService.paymentInfo_Timeout(id);
        log.info(s);
        return  s;
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result"+result);
        return result;
    }
}
