package com.example.demo.exception;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class AppException extends RuntimeException {
    private int errcode;
    private String errmsg;
    public AppException(){};
    public AppException(int errcode){
        this.errcode = errcode;
    }
    public AppException(String errmsg){
        this.errmsg = errmsg;
    }

    public AppException(int errcode,String errmsg){
        this.errcode = errcode;
        this.errmsg = errmsg;
    }


}
