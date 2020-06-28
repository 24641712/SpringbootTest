package com.example.demo.mq;

import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.beans.BeanUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 监听消息进行消费
 */
@Component
public class ConsumerService {
    @EventListener(condition = "#event.msgs[0].topic=='user-topic' && #event.msgs[0].tags=='white'")
    public void rocketmqMsgListener(MessageEvent event) {
        try {
            List<MessageExt> msgs = event.getMsgs();
            for (MessageExt msg : msgs) {
                System.err.println("消费消息:"+new String(msg.getBody()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
