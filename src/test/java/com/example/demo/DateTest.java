package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateTest {

    @Test
    public void dayToEnd(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = dateFormat.format(new Date());
        String endStr = nowStr.substring(0, nowStr.indexOf(' ')) + " 23:59:59";
        try {
            log.info("距离这一天结束还有{}秒", (dateFormat.parse(endStr).getTime()-dateFormat.parse(nowStr).getTime())/1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }




}
