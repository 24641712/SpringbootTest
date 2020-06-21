package com.example.demo.exception;

public class RocketMQException extends AppException {
    public RocketMQException(){
        super();
    }
    public RocketMQException(int errcode){
        super(errcode);
    }
    public RocketMQException(String errmsg){
        super(errmsg);
    }
    public RocketMQException(int errcode,String errmsg){
        super(errcode,errmsg);
    }

}
