//package com.example.demo.redis.mq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.stereotype.Service;
//
///**
// * @version 1.0
// * @Description :
// * Copyright: Copyright (c)2019
// * Created Date : 2020/5/23
// */
//@Service
//public class MessagePublisherImpl implements MessagePublisher
//{
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//    @Autowired(required = true)
//    private ChannelTopic topic;
//
//    public MessagePublisherImpl() {
//    }
//
//    public MessagePublisherImpl(final RedisTemplate<String, Object> redisTemplate, final ChannelTopic topic) {
//        this.redisTemplate = redisTemplate;
//        this.topic = topic;
//    }
//
//    public void publish(final String message) {
//        redisTemplate.convertAndSend(topic.getTopic(), message);
//    }
//
//
//}
