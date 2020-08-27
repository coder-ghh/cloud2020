package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private  String ServerPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
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

    }

