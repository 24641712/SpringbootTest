package com.example.demo.mq.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;

    public User(){};

    public User(String id,String username){
        this.id = id;
        this.username = username;
    }
}
