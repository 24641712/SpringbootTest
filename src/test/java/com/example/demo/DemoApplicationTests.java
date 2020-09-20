package com.example.demo;

//import com.example.demo.redis.mq.MessagePublisherImpl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mq.RocketMQProperties;
import com.example.demo.mq.entity.User;
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
        for(int i=0;i<100;i++){
            User user = new User(""+i, ""+i);

            boolean result = defaultProducerService.send("demo", "TAG-A", JSONObject.toJSONString(user));
            if(result){
                log.info("B_{}消息发送成功");
            }else{
                log.info("B_{}消息发送失败");
            }

        }

    }



}
