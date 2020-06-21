package com.example.demo;

import com.example.demo.mq.RocketMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private RocketMQProperties rocketMQProperties;

    @Test
    public void propertiestst(){
        log.info(rocketMQProperties.getNamesrvAddr());


    }


}
