package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/6/12
 */
@Slf4j
public class FastJsonTest {

    @Test
    public void josnArray(){
        String arr = "{'title':'MyInfo'," +
                "'info':[{'name':'张三','age':'23'}," +
                "{'name':'李四','age':'28'}]," +
                "'result':'success'}";
        JSONObject jsonResult = JSONObject.parseObject(arr);
        String jsonInfoString = jsonResult.getString("info");
        JSONArray jsonArray = JSONArray.parseArray(jsonInfoString);
        List<Student> students = jsonArray.toJavaList(Student.class);
        students.stream().forEach(e-> {System.out.println(e.getName());
            System.out.println(e.getAge());
        });

        for(Object object:jsonArray){
            JSONObject jsonObject = (JSONObject) object;
            log.info(jsonObject.toString());
            log.info(jsonObject.getString("name"));

        }

    }

    @Data
    static class Student{
        private String name;
        private int age;
    }


}
