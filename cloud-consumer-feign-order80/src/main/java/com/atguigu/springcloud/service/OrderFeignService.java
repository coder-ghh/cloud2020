package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "cloud-payment-service")
public interface OrderFeignService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);


    @GetMapping("/payment/feign/timeout")
    public  String paymentFeignTimeout();


}
