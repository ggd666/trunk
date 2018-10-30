package com.jk.service;

public class StudentServiceImpl implements StudentService {



    @Override
    public void getUserInfo() {
        System.out.println("username=admin");
    }

    @Override
    public void sendUuid(String uuid) {
        System.out.println(uuid+"啥啊");
    }
}
