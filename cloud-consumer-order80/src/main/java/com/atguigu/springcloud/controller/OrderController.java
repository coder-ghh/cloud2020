package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public  static  final  String PAYMENT_URL="http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
         return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPayment/{id}")
    public  CommonResult getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public  CommonResult getForEntity(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> Entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        if(Entity.getStatusCode().is2xxSuccessful()){
            return  Entity.getBody();
        }else {
            return  new CommonResult(444,"失败",null);
        }

    }

   //zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public   String paymentZipkin(){
         String result= restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/",String.class);
         return  result;
    }
}
