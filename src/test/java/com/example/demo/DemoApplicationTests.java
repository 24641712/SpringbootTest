package com.example.demo;

//import com.example.demo.redis.mq.MessagePublisherImpl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

//    @Autowired
//    MessagePublisherImpl messagePublisher;

    @Test
    void contextLoads() {
//        messagePublisher.publish("你好");
        log.info("hello world");
    }

    @Test
    void test4(){
        System.out.println("54645");
    }



}
