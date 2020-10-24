package com.example.demo;

import com.example.demo.redis.cache.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    final double MAX_TIME = 9999999999L;

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

    @Test
    public void test(){
        ZSetOperations.TypedTuple<Object> typedTuple1 = new DefaultTypedTuple<Object>("e",5.0);
        ZSetOperations.TypedTuple<Object> typedTuple2 = new DefaultTypedTuple<Object>("f",6.0);
        ZSetOperations.TypedTuple<Object> typedTuple3 = new DefaultTypedTuple<Object>("g",7.0);
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet = new HashSet<ZSetOperations.TypedTuple<Object>>();
        typedTupleSet.add(typedTuple1);
        typedTupleSet.add(typedTuple2);
        typedTupleSet.add(typedTuple3);
        BoundZSetOperations boundZSetOperations = redisTemplate.boundZSetOps("bzso");
        boundZSetOperations.add(typedTupleSet);

        String key = (String) boundZSetOperations.getKey();
        boundZSetOperations.add("h", 8.0);
        boundZSetOperations.incrementScore("h", -2.0);
//        boundZSetOperations.expire(-5, TimeUnit.SECONDS);
        System.out.println(boundZSetOperations.score("h"));
        Set<String> typedTuples = boundZSetOperations.reverseRange(0, -1);
        for(String typedTuple : typedTuples){
            System.out.println(typedTuple);
        }


//        boundZSetOperations.reverseRange(0, -1).stream().forEach(item->{
//            System.out.println(item);
//        });

//        log.info("当前用户g排行：{}", boundZSetOperations.reverseRank("f")+1);

//        log.info("该排行榜中共有{}个用户", boundZSetOperations.size());

//        double oldScore = boundZSetOperations.score("g");
//        double score = boundZSetOperations.incrementScore("g", 9.0-5.0);
//        boundZSetOperations.reverseRange(0,-1).forEach(v -> System.out.println("通过TypedTuple方式新增数据:" + v));

    }

    @Test
    public void rankTest(){
       int star1 = 5;

       int star2 = 6;

        BoundZSetOperations boundZSetOperations = redisTemplate.boundZSetOps("bzso");
        boundZSetOperations.add("a", getScore(star1));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boundZSetOperations.add("b", getScore(star2));

        boundZSetOperations.reverseRange(0,-1).stream().forEach(v->{
            System.out.println(boundZSetOperations.score(v));
            System.out.println(getStar(boundZSetOperations.score(v)));
            System.out.println(v);
        });

    }

    public double getScore(int score){
        double timeStamp = System.currentTimeMillis();
        double finalScore = score + 1 - timeStamp/Math.pow(10,(int)Math.log10(timeStamp)+1);
        return finalScore;
    }

    public int getStar(double score){
        return Double.valueOf(score).intValue();
    }





}
