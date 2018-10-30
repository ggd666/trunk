package com.jk.utils;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "A1804")
public class GEtRabbitMqData {

    @RabbitHandler
    public void  getMsg(String msg){

        System.out.println(msg);
    }


}
