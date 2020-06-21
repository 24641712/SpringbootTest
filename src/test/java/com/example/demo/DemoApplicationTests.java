package com.example.demo;

//import com.example.demo.redis.mq.MessagePublisherImpl;

import com.example.demo.mq.RocketMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

//    @Autowired
//    MessagePublisherImpl messagePublisher;
    @Autowired
    private RocketMQProperties rocketMQProperties;

    @Test
    void contextLoads() {
//        messagePublisher.publish("你好");

        log.info(rocketMQProperties.getNamesrvAddr());
    }

    @Test
    void test4(){
        System.out.println("54645");
    }



}
