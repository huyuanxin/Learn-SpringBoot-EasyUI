package com.example.demo;

import com.example.demo.domain.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //不加上会无法创建bean
@DisplayName("测试UserMapper")
public class UserMapperTest{
    @Autowired
    UserMapper mapper;

    @Test
    @DisplayName("测试findAll接口")
    public void findAll(){
        mapper.findAll();
    }
}
