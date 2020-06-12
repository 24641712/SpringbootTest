//package com.example.demo.redis.mq;
//
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.connection.MessageListener;
//
///**
// * @version 1.0
// * @Description :
// * Copyright: Copyright (c)2019
// * Created Date : 2020/5/23
// */
//public class MessageSubscriber implements MessageListener{
//    @Override
//    public void onMessage(Message message, byte[] bytes) {
//        System.out.println("Message received: " + new String(message.getBody()));
//    }
//}
