package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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


}
