package com.example.demo;

import com.example.demo.redis.cache.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest

public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void MapTest(){
        redisUtil.set("name","hello");
        log.info(redisUtil.get("name")+"");

    }



}
