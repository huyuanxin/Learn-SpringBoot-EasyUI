package com.example.demo;

import com.example.demo.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //不加上会无法创建bean
public class Test1{
    @Autowired
    UserService service;
    @Test
    public void Test(){
        System.out.print("TEST1");
    }
    @Test
    public void findAll(){
        service.findAll();
    }
}
