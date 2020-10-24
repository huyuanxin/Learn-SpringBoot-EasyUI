package com.example.demo.api;

import com.example.demo.domain.mybatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    String getUserNameByUid(int uid);
    List<User> findAll();
    User getOneByUid(int uid);
    int deleteOneByUid(int uid);
    int updateUserNameByUid(User user);
    int insertNewUser(User user);
    int insertMultiUsers(List<User> list);
}
