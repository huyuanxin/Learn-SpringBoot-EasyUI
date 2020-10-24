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

    @RequestMapping(value = "/updateUserByRequestParam", method = RequestMethod.PUT)
    public int changeName(
            @RequestParam("username") String userName,
            @RequestParam("id") int uid) {
        User user = new User();
        user.setUserName(userName);
        user.setUid(uid);
        return userService.updateUserByUid(user);
    }

    @RequestMapping(value = "/updateUserByRequestBody", method = RequestMethod.PUT)
    public int updateUserByRequestBody(
            @RequestBody User user){
        return userService.updateUserByUid(user);
    }

    @RequestMapping(value = "/addNewUserByRequestBody", method = RequestMethod.POST)
    public int addNewUserByRequestBody(
            @RequestBody User user
    ){
        return userService.insertNewUser(user);
    }

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

}
