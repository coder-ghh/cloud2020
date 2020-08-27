package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务器宕机了!!,PaymentFallbackService---paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "服务器宕机了!!,PaymentFallbackService---paymentInfo_Timeout";
    }
}
