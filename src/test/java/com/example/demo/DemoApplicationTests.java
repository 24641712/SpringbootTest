package com.example.demo;

//import com.example.demo.redis.mq.MessagePublisherImpl;

import com.example.demo.mq.RocketMQProperties;
import com.example.demo.mq.service.DefaultProducerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
    @Autowired
    private DefaultProducerService defaultProducerService;


    @Autowired
    private RocketMQProperties rocketMQProperties;

    @Test
    void contextLoads() {
//        messagePublisher.publish("你好");

        log.info(rocketMQProperties.getNamesrvAddr());
    }

    @Test
    void test4(){
        boolean result = defaultProducerService.send("demo", "TAG-A", "Hello RocketMQ_B_");
        if(result){
            log.info("B_{}消息发送成功");
        }else{
            log.info("B_{}消息发送失败");
        }

    }



}
