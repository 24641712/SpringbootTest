package com.example.demo.mq.listener;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "demo", consumerGroup = "defaultGroup", selectorExpression = "*")
public class TestListner  implements RocketMQListener<User> {


    @Override
    public void onMessage(User user) {
        log.info("接收到消息{}", JSONObject.toJSONString(user));
    }
}
