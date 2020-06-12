package com.example.demo.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/6/6
 */
@Controller
public class RedisController {
   @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value="/FristBlood/{name}",method= RequestMethod.GET)
    @ResponseBody
    public String hello(@PathVariable("name") String name) {
        return "查询结果：" + redisUtil.get(name) ;
    }



}
