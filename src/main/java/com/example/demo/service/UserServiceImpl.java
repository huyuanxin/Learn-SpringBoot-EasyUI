package com.example.demo.service;

import com.example.demo.api.UserService;
import com.example.demo.po.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanxin
 * @create 2020/11/11 11:25
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String getUserNameByUid(int uid) {
        User user = userMapper.getUserByUserUid(uid);
        if (user != null) {
            return user.getUserName();
        }
        return "noUser";
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User getUserByUserUid(long uid) {
        return userMapper.getUserByUserUid(uid);
    }

    @Override
    public long deleteOneByUid(long uid) {
        return userMapper.deleteOneByUid(uid);
    }

    @Override
    public long updateUserByUid(User user) {
        return userMapper.updateUserByUid(user);
    }

    @Override
    public long insertNewUser(User user) {
        return userMapper.insertNewUser(user);
    }

    @Override
    public long insertMultiUsers(List<User> list) {
        return userMapper.insertMultiUsers(list);
    }

    @Override
    public long deleteMultiUsersByUid(List<Long> list) {
        return userMapper.deleteMultiUsersByUid(list);
    }

    @Override
    public long updateMultiUser(List<User> list) {
        return userMapper.updateMultiUser(list);
    }

    @Override
    public List<User> getAllUerWithLimits(long start, long pageSize) {
        return userMapper.getAllUerWithLimits(start, pageSize);
    }

    @Override
    public long countTableRows(String tableName) {
        return userMapper.counter(tableName);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}
