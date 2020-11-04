package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import com.example.demo.domain.mybatis.entity.easyui.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/getAllUserDto", method = RequestMethod.GET)
    public UserDto dto() {
        List<User> user= userService.findAll();
        return new UserDto(HttpStatus.OK,user,"succeed");
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
    public long delete(
            @RequestParam("id") int uid) {
        return userService.deleteOneByUid(uid);
    }

    // 通过RequestParam获得参数更新User
    @RequestMapping(value = "/updateUserByRequestParam", method = RequestMethod.PUT)
    public long updateUserByRequestParam(
            @RequestParam(value = "username", required = false, defaultValue = "") String userName,
            @RequestParam(value = "password", required = false, defaultValue = "") String password,
            @RequestParam("id") int uid) {
        User user = userService.getOneByUid(uid);
        if (user != null) {
            if (!userName.equals("")) {
                user.setUserName(userName);
            }
            if (!password.equals("")) {
                user.setPassword(password);
            }
            return userService.updateUserByUid(user);
        }
        return 0;
    }

    // 通过RequestBody获得参数更新User
    @RequestMapping(value = "/updateUserByRequestBody", method = RequestMethod.PUT)
    public long updateUserByRequestBody(
            @RequestBody User user) {
        if (user.getUid() != 0) {
            User u = userService.getOneByUid(user.getUid());
            if (u != null) {
                if (user.getUserName().equals("") && user.getPassword().equals("")) {
                    return 0;
                }
                if (!user.getUserName().equals("")) {
                    u.setUserName(user.getUserName());
                }
                if (!user.getPassword().equals("")) {
                    u.setPassword(user.getPassword());
                }
                return userService.updateUserByUid(u);
            }
        }
        return 0;
    }

    // 通过RequestBody添加User
    @RequestMapping(value = "/addNewUserByRequestBody", method = RequestMethod.POST)
    public long addNewUserByRequestBody(
            @RequestBody User user
    ) {
        if (!user.getPassword().equals("") && !user.getUserName().equals("")) {
            return userService.insertNewUser(user);
        }
        return 0;
    }

    // 通过RequestParam添加User
    @RequestMapping(value = "/addNewUserByRequestParam", method = RequestMethod.POST)
    public long addNewUserByRequestParam(
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
    public long insetMultiUser(
            @RequestBody List<User> list) {
        list.removeIf(it -> it.getUserName().equals("") || it.getPassword().equals(""));
        if (list.size() != 0) {
            return userService.insertMultiUsers(list);
        }
        return 0;
    }

    // 通过删除Uid删除多个Users
    @RequestMapping(value = "/deleteMultiUserByUid", method = RequestMethod.DELETE)
    public long deleteMultiUserByUid(
            @RequestBody List<Long> list) {
        list.removeIf(it -> it <= 0);
        if (list.size() != 0) {
            return userService.deleteMultiUsersByUid(list);
        }
        return 0;
    }

    // 更新多个Users
    @RequestMapping(value = "/updateMultiUser", method = RequestMethod.PUT)
    public long updateMultiUser(
            @RequestBody List<User> list) {
        list.removeIf(
                it ->
                        it.getUid() <= 0 ||
                                (it.getUserName().equals("") && it.getPassword().equals(""))
        );
        if (list.size() != 0) {
            for (User it : list
            ) {
                User u = userService.getOneByUid(it.getUid());
                if (u != null) {
                    if (it.getUserName().equals("")) {
                        it.setUserName(u.getUserName());
                    }
                    if (it.getPassword().equals("")) {
                        it.setPassword(u.getPassword());
                    }
                }
            }
            return userService.updateMultiUser(list);
        }
        return 0;
    }
}
