package com.example.demo;

import com.example.demo.redis.cache.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@SpringBootTest

public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void stringTest(){
        redisUtil.set("我的key","我的Value");
        log.info(redisUtil.get("我的key")+"");
    }

    @Test
    public void mapAllTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        redisUtil.hmset("map1",map);

        log.info(redisUtil.hmget("map1").toString());

    }

    @Test
    public void mapTest(){
        redisUtil.hset("map1","key4","value4");
        Map<Object, Object> map = redisUtil.hmget("map1");
        log.info((String) map.get("key1"));

    }

    @Test
    public void setTest(){
     String keys[] = {"1","2"};
     redisUtil.sSet("key", keys);
     Set<Object> key = redisUtil.sGet("key");
     Iterator<Object> iterator = key.iterator();
     while (iterator.hasNext()){
         log.info(iterator.next().toString());
     }

     if(redisUtil.sHasKey("key","1")){
         log.info("这个值存在");
     }else{
         log.info("这个值不存在");
     }

    }





}
