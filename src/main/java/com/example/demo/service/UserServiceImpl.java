package com.example.demo.service;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import com.example.demo.domain.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String getUserNameByUid(int uid) {
        User user = userMapper.getOneByUid(uid);
        if (user != null) {
            return user.getUserName();
        }
        return "noUser";
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User getOneByUid(long uid) {
        return userMapper.getOneByUid(uid);
    }

    public long deleteOneByUid(long uid) {
        return userMapper.deleteOneByUid(uid);
    }

    public long updateUserByUid(User user) {
        return userMapper.updateUserByUid(user);
    }

    public long insertNewUser(User user) {
        return userMapper.insertNewUser(user);
    }

    public long insertMultiUsers(List<User> list) {
        return userMapper.insertMultiUsers(list);
    }

    public long deleteMultiUsersByUid(List<Integer> list) {
        return userMapper.deleteMultiUsersByUid(list);
    }

    public long updateMultiUser(List<User> list) {
        return userMapper.updateMultiUser(list);
    }
}
