package com.atguigu.springcloud.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //setter getter
@AllArgsConstructor  //有参构造
@NoArgsConstructor   //无参构造
public class CommonResult<T> {
    private  Integer code;
    private  String message;
    private T data;

    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
