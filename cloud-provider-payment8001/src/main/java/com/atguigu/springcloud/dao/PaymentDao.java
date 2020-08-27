package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public  int create(Payment payment);
    public  Payment getPaymentById(Long id);
}
