package com.example.demo.domain.mybatis.mapper;

import com.example.demo.domain.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();
    User getOneByUid(int uid);
    int deleteOneByUid(int uid);
    int updateUserByUid(User user);
    int insertNewUser(User user);
    int insertMultiUsers(List<User> list);
    int deleteMultiUsersByUid(List<Integer> list);
    int updateMultiUser(List<User> list);
}

