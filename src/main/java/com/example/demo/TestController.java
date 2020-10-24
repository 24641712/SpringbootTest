package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("test")
public class TestController {

    @PostMapping("test")
    public String test(@RequestParam(value = "num")String num){
        log.info(num+"");
        return "成功";
    }




}
