package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  //setter getter
@AllArgsConstructor  //有参构造
@NoArgsConstructor   //无参构造
public class Payment {
    private Long id;
    private String serial;
}
