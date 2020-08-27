package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private  String ServerPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody  Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,ServerPort="+ServerPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }


    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200,"查询数据成功,ServerPort="+ServerPort,payment);
        }


    @GetMapping("/payment/discovery")
     public  Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service:services){
            System.out.println("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances){
            System.out.println("instance:"+instance);
            System.out.println("Host:"+instance.getHost()+"\tPort:"+instance.getPort()+"\tUri:"+instance.getUri());
        }
       return  discoveryClient;
    }

    //测试openfeign的超时控制
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  ServerPort;
    }


    @GetMapping("/payment/zipkin")
    public   String paymentZipkin(){
        return "测试Zipkin成功!!!!!!!";
    }

    }

