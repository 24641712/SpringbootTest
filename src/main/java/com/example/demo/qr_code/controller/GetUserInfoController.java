package com.example.demo.qr_code.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserInfoController {

    @PostMapping("/getUserInfo")
    public String getUserInfo(){
        System.out.println("hello");
        return "hello world";
    }




}
