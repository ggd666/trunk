package com.jk.utils;

import com.jk.service.user.UserService;
import org.springframework.amqp.core.AmqpTemplate;

public class TestThread implements Runnable{

    private AmqpTemplate amqpTemplate;
    private UserService userService;
    private String uuid;

    public TestThread(UserService userService,String uuid){
        this.userService = userService;
        this.uuid = uuid;
    }

    public  TestThread(AmqpTemplate amqpTemplate){
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void run() {

    }

    public TestThread(){

    }

    public void send(){
        userService.sendUuid(uuid);
    }
}
