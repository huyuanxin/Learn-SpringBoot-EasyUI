package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/getUserByUid", method = RequestMethod.GET)
    public User getOneById(
            @RequestParam("id") int id) {
        return userService.getOneByUid(id);
    }

    @RequestMapping(value = "/getUserNameByUid", method = RequestMethod.GET)
    public String getUserName(
            @RequestParam("id") int uid) {
        return userService.getUserNameByUid(uid);
    }

    @RequestMapping(value = "/deleteUserByUid", method = RequestMethod.DELETE)
    public int delete(
            @RequestParam("id") int uid) {
        return userService.deleteOneByUid(uid);
    }

    @RequestMapping(value = "/updateUserName", method = RequestMethod.PUT)
    public int changeName(
            @RequestParam("username") String userName,
            @RequestParam("id") int uid) {
        User user = new User();
        user.setUserName(userName);
        user.setUid(uid);
        return userService.updateUserNameByUid(user);
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public int addNewUser(
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "password") String password
    ) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.insertNewUser(user);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public int count(
            @RequestBody List<String> list) {
        return list.size();
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUserList(
            @RequestBody List<User> list) {
        return list;
    }
}
