package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

@Slf4j
public class RankTest {

    final double MAX_TIME = 9999999999L;

    @Test
    public void ranTest(){
        double finalScore1 = getScore(3000);
        double finalScore2 = getScore(3000.001);
        if(finalScore1 > finalScore2){
            log.info("选手1的分数高");
        }else{
            log.info("选手2的分数高");
        }
        log.info("选手1的分数{}，选手2的分数{}", finalScore1, finalScore2);


    }

    public double getScore(double score){
       double timeStamp = System.currentTimeMillis()/1000;
       double finalScore = Math.pow(score,11) +  (MAX_TIME - timeStamp);

       return finalScore;
    }




}
