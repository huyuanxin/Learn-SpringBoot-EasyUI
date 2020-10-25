package com.example.demo.domain.mybatis.mapper;

import com.example.demo.domain.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();

    User getOneByUid(long uid);

    long deleteOneByUid(long uid);

    long updateUserByUid(User user);

    long insertNewUser(User user);

    long insertMultiUsers(List<User> list);

    long deleteMultiUsersByUid(List<Integer> list);

    long updateMultiUser(List<User> list);
}

