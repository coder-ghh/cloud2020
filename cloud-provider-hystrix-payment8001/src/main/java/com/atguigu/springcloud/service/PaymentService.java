package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public  String paymentInfo_OK(Integer id){
        return  "线程池:"+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id;
    }

    //设置服务降级
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties =
          {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public  String paymentInfo_Timeout(Integer id) throws InterruptedException {
        int timeNumber=3000;
        Thread.sleep(timeNumber);
        //两个睡眠方法都可以,一个3000代表3秒,另一个则3代表3秒
        //TimeUnit.SECONDS.sleep(timeNumber);
        return  "线程池:"+Thread.currentThread().getName()+" paymentInfo_Timeout,id:"+id;
    }

    public  String paymentInfo_TimeoutHandler(Integer id){

        return  "线程池:"+Thread.currentThread().getName()+"服务器繁忙或者报错请稍后再试!, paymentInfo_TimeoutHandler,id:"+id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否打开断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//在配置时间窗口内达到该数值后进行短路,默认20,至少有10个请求才会进行失败率计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//短路多久后开始恢复,默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率,达到此值开始短路,默认50%
    })
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw  new RuntimeException("id不能为负数");
        }
        //生成一个唯一的流水号(糊涂工具包)
        String serialNumber= IdUtil.simpleUUID();
        return  Thread.currentThread().getName()+"调用成功,流水号是:"+serialNumber;
    }

    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return  "id不能为负数.请稍后尝试!!,id:"+id;
    }

}
