package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

      @Value("${server.port}")
       private  String ServerPort;

       @StreamListener(Sink.INPUT)
      public  void input(Message<String> message){
          System.out.println("消费者1号,------->接收到消息:"+message.getPayload()+"\t port:"+ServerPort);
      }
}
