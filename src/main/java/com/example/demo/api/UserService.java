package com.example.demo.api;

import com.example.demo.domain.mybatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String getUserNameByUid(int uid);

    List<User> findAll();

    User getOneByUid(long uid);

    long deleteOneByUid(long uid);

    long updateUserByUid(User user);

    long insertNewUser(User user);

    long insertMultiUsers(List<User> list);

    long deleteMultiUsersByUid(List<Long> list);

    long updateMultiUser(List<User> list);
}
