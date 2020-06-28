package com.example.demo.mq.entity;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Temp {

    public static void main(String[] args) throws IllegalAccessException {

        List<User> list = new ArrayList<>();
        list.add(new User("001","hua"));
        list.add(new User("002","zhao"));
        Map<String, String> map = list.stream().collect(Collectors.toMap(User::getId, User::getUsername, (key1, key2) -> key2));
        log.info(map.toString());

        Map<String, User> map1 = list.stream().collect(Collectors.toMap(User::getId, Function.identity(), (key1, key2) -> key2));
        log.info(map1.toString());

        List<User> collect = list.stream().filter(e1 -> e1.getId().equals("001")).collect(Collectors.toList());
        log.info(collect.toString());

        log.info(new User("002","zhao").getClass().getName());

        User user = new User("003", "wang");
        Field[] fields = user.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            log.info(field.get(user)+"");



        }






    }




}
