package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import com.example.demo.domain.mybatis.entity.easyui.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuanxin
 * @create 2020/11/11 11:25
 */
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

    @RequestMapping(value = "/getAllUserDto", method = RequestMethod.GET)
    public UserDTO dto() {
        List<User> user= userService.findAll();
        return new UserDTO(HttpStatus.OK,user,"succeed");
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
    public long delete(
            @RequestParam("id") int uid) {
        return userService.deleteOneByUid(uid);
    }

    @RequestMapping(value = "/updateUserByRequestParam", method = RequestMethod.PUT)
    public long updateUserByRequestParam(
            @RequestParam(value = "username", required = false, defaultValue = "") String userName,
            @RequestParam(value = "password", required = false, defaultValue = "") String password,
            @RequestParam("id") int uid) {
        User user = userService.getOneByUid(uid);
        if (user != null) {
            if (!"".equals(userName)) {
                user.setUserName(userName);
            }
            if (!"".equals(password)) {
                user.setPassword(password);
            }
            return userService.updateUserByUid(user);
        }
        return 0;
    }

    @RequestMapping(value = "/updateUserByRequestBody", method = RequestMethod.PUT)
    public long updateUserByRequestBody(
            @RequestBody User user) {
        if (user.getUid() != 0) {
            User u = userService.getOneByUid(user.getUid());
            if (u != null) {
                if ("".equals(user.getUserName()) && "".equals(user.getPassword())) {
                    return 0;
                }
                if (!"".equals(user.getUserName())) {
                    u.setUserName(user.getUserName());
                }
                if (!"".equals(user.getPassword())) {
                    u.setPassword(user.getPassword());
                }
                return userService.updateUserByUid(u);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/addNewUserByRequestBody", method = RequestMethod.POST)
    public long addNewUserByRequestBody(
            @RequestBody User user
    ) {
        if (!"".equals(user.getPassword()) && !"".equals(user.getUserName())) {
            return userService.insertNewUser(user);
        }
        return 0;
    }

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

    @RequestMapping(value = "/insetMultiUser", method = RequestMethod.POST)
    public long insetMultiUser(
            @RequestBody List<User> list) {
        list.removeIf(it -> "".equals(it.getUserName()) || "".equals(it.getPassword()));
        if (list.size() != 0) {
            return userService.insertMultiUsers(list);
        }
        return 0;
    }

    @RequestMapping(value = "/deleteMultiUserByUid", method = RequestMethod.DELETE)
    public long deleteMultiUserByUid(
            @RequestBody List<Long> list) {
        list.removeIf(it -> it <= 0);
        if (list.size() != 0) {
            return userService.deleteMultiUsersByUid(list);
        }
        return 0;
    }

    @RequestMapping(value = "/updateMultiUser", method = RequestMethod.PUT)
    public long updateMultiUser(
            @RequestBody List<User> list) {
        list.removeIf(
                it ->
                        it.getUid() <= 0 ||
                                ("".equals(it.getUserName()) && "".equals(it.getPassword()))
        );
        if (list.size() != 0) {
            for (User it : list
            ) {
                User u = userService.getOneByUid(it.getUid());
                if (u != null) {
                    if ("".equals(it.getUserName())) {
                        it.setUserName(u.getUserName());
                    }
                    if ("".equals(it.getPassword())) {
                        it.setPassword(u.getPassword());
                    }
                }
            }
            return userService.updateMultiUser(list);
        }
        return 0;
    }
}
