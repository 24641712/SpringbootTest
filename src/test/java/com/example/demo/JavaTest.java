package com.example.demo;

import com.example.demo.mq.RocketMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
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
        String str = "20abc";
        if(StringUtils.isEmpty(str)){
            log.info("字符串为空");
        }else {
            log.info("字符串不为空");
        }

        log.info(StringUtils.delete(str,".*c"));
        Pattern pattern = Pattern.compile(".*c");
        Matcher matcher = pattern.matcher(str);

        if(matcher.matches()){
            log.info("匹配成功");
        }else{
            log.info("匹配失败");
        }

        log.info(str.replaceAll("^\\d*","def"));

    }




}
