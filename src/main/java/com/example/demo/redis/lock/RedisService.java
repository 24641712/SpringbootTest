package com.example.demo.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 加锁，自旋重试三次
     *
     * @param
     * @return
     */
    public boolean lock(String key, String requestId) {
        boolean locked = false;
        int tryCount = 3;
        while (!locked && tryCount > 0) {
            locked = redisTemplate.opsForValue().setIfAbsent(key, requestId, 2, TimeUnit.MINUTES);
            tryCount--;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                log.error("线程被中断" + Thread.currentThread().getId(), e);
            }
        }
        return locked;
    }

    /**
     * 非原子解锁，可能解别人锁，不安全
     *
     * @param
     * @return
     */
    public boolean unlock(String key, String requestId) {
        if (key == null || requestId == null)
            return false;
        boolean releaseLock = false;
        String requestId1 = (String) redisTemplate.opsForValue().get(key);
        if (requestId.equals(requestId1)) {
            releaseLock = redisTemplate.delete(key);
        }
        return releaseLock;
    }

    /**
     * 使用lua脚本解锁，不会解除别人锁
     *
     * @param
     * @return
     */
    public boolean unlockLua(String key, String requestId) {
        if (key == null || requestId == null)
            return false;
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        //用于解锁的lua脚本位置
        redisScript.setLocation(new ClassPathResource("unlock.lua"));
        redisScript.setResultType(Long.class);
        //没有指定序列化方式，默认使用上面配置的
        Object result = redisTemplate.execute(redisScript, Arrays.asList(key), requestId);
        return result.equals(Long.valueOf(1));
    }




}
