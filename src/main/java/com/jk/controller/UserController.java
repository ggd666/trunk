package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.user.User;
import com.jk.service.user.UserService;
import com.jk.utils.TestThread;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class UserController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private UserService userService;

    ExecutorService  ExecutorService =  Executors.newSingleThreadExecutor();


    @RequestMapping("send")
    public String send(){

        User user = new User();
        user.setId(1);
        amqpTemplate.convertAndSend("A1804", JSON.toJSONString(user));

        return  "hello world";
    }

    @RequestMapping("ThreadSend")
    public String threadSend(){

        String uuid = UUID.randomUUID().toString();
        ExecutorService.execute(new TestThread(userService,uuid));
        return "hello world";
    }

}
