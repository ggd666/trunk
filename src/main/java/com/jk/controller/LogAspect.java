package com.jk.controller;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.jk.controller..*.*(..))")
    public void logPoin(){

    }

    @Before("logPoin()")
    public void logBefore(){
        System.out.println("前置通知: 权限记录");
    }

    @After("logPoin()")
    public void logAfter(){
        System.out.println("后置通知:日志记录");
    }


}
