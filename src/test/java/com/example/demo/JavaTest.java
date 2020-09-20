package com.example.demo;

import com.example.demo.mq.RocketMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class JavaTest {

    @Test
    public void listTest(){
        List<String> list = new ArrayList<>();
        list.add("麻雀");
        list.add("秃鹫");
        if(list.contains("秃鹫")){
            log.info("有秃鹫存在");
        }
        if(list.contains("夜莺")){
            log.info("有夜莺存在");
        }else{
            log.info("夜莺不存在");
        }

        if("alibab".contains("lib")){
            log.info("有你想要的内容");
        }else{
            log.info("没有你想要的内容");
        }

    }

    @Test
    public void StringTest(){
       final String str = "你好#0，我也好#1";
        System.out.println(StringUtils.replace(str,"#0","123"));


    }

    @Test
    public void integerTest(){
        AtomicInteger atomicInteger = new AtomicInteger();
        for(int i=0;i<1000;i++){
            atomicInteger.incrementAndGet();
        }
        log.info(atomicInteger.get()+"");

    }




}
