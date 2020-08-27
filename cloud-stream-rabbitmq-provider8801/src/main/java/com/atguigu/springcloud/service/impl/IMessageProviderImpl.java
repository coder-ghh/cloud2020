package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

//定义消息的推送管道,表示当前这个类是source,负责生产消息,并且发送给channel
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道,将消息发送给这个channel
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build()); //发送
        System.out.println("---------serial"+serial);
        return null;
    }
}
