package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 获取全部Users
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    // 通过Uid获取单个User
    @RequestMapping(value = "/getUserByUid", method = RequestMethod.GET)
    public User getOneById(
            @RequestParam("id") int id) {
        return userService.getOneByUid(id);
    }

    // 通过Uid获取User.UserName
    @RequestMapping(value = "/getUserNameByUid", method = RequestMethod.GET)
    public String getUserName(
            @RequestParam("id") int uid) {
        return userService.getUserNameByUid(uid);
    }

    // 通过Uid删除单个User
    @RequestMapping(value = "/deleteUserByUid", method = RequestMethod.DELETE)
    public int delete(
            @RequestParam("id") int uid) {
        return userService.deleteOneByUid(uid);
    }

    // 通过RequestParam获得参数更新User
    @RequestMapping(value = "/updateUserByRequestParam", method = RequestMethod.PUT)
    public int updateUserByRequestParam(
            @RequestParam(value = "username", required = false) String userName,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam("id") int uid) {
        User user = new User();
        if (!userName.equals("")) {
            user.setUserName(userName);
        }
        if (!password.equals("")) {
            user.setPassword(password);
        }
        user.setUid(uid);
        return userService.updateUserByUid(user);
    }

    // 通过RequestBody获得参数更新User
    @RequestMapping(value = "/updateUserByRequestBody", method = RequestMethod.PUT)
    public int updateUserByRequestBody(
            @RequestBody User user) {
        return userService.updateUserByUid(user);
    }

    // 通过RequestBody添加User
    @RequestMapping(value = "/addNewUserByRequestBody", method = RequestMethod.POST)
    public int addNewUserByRequestBody(
            @RequestBody User user
    ) {
        return userService.insertNewUser(user);
    }

    // 通过RequestParam添加User
    @RequestMapping(value = "/addNewUserByRequestParam", method = RequestMethod.POST)
    public int addNewUserByRequestParam(
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "password") String password
    ) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.insertNewUser(user);
    }

    // 添加多个Users
    @RequestMapping(value = "/insetMultiUser", method = RequestMethod.POST)
    public int insetMultiUser(
            @RequestBody List<User> list) {
        return userService.insertMultiUsers(list);
    }

    // 通过删除Uid删除多个Users
    @RequestMapping(value = "/deleteMultiUserByUid", method = RequestMethod.DELETE)
    public int deleteMultiUserByUid(
            @RequestBody List<Integer> list) {
        return userService.deleteMultiUsersByUid(list);
    }

    // 更新多个Users
    @RequestMapping(value = "/updateMultiUser", method = RequestMethod.PUT)
    public int updateMultiUser(
            @RequestBody List<User> list) {
        return userService.updateMultiUser(list);
    }
}
