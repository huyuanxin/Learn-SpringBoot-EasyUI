package com.example.demo.api;

import com.example.demo.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanxin
 * @create 2020/11/11 11:25
 */
@Service("UserService")
public interface UserService {

    /**
     * 通过Uid获得User.UserName
     * @param uid 用户的Uid
     * @return UserName
     */
    String getUserNameByUid(int uid);

    /**
     * 查询表内全部User
     * @return ListUser
     */
    List<User> findAll();

    /**
     * 通过Uid获取一个User
     * @param uid 用户的uid
     * @return User
     */
    User getOneByUid(long uid);


    /**
     * 通过Uid删除一个User
     * @param uid  用户的Uid
     * @return result,若成功返回1,反之为0
     */
    long deleteOneByUid(long uid);

    /**
     * 更新User
     * @param user 单个user
     * @return result,若成功返回1，反正为0
     */
    long updateUserByUid(User user);

    /**
     * 插入新User
     * @param user 插入的用户
     * @return result,若成功返回1,反正为0
     */
    long insertNewUser(User user);

    /**
     * 插入多个User
     * @param list 多个User
     * @return result,返回结果是成功插入的条数
     */
    long insertMultiUsers(List<User> list);

    /**
     * 通过Uid删除多个User
     * @param list 多个User
     * @return result,返回结果是成功插入的条数
     */
    long deleteMultiUsersByUid(List<Long> list);

    /**
     * 更新多个User
     * @param list 多个User
     * @return result，返回结果是成功插入的条数
     */
    long updateMultiUser(List<User> list);

    /**
     * 分页查询的功能
     * @param start 从第几条开始读取
     * @param pageSize 一页有多少
     * @return User,返回查询到的User
     */
    List<User> getAllUerWithLimits(long start,long pageSize);


    /**
     * 查询表内有多少条记录
     * @param tableName 表名
     * @return 结果
     */
    long countTableRows(String tableName);
}
