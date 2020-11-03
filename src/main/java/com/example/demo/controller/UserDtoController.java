package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import com.example.demo.domain.mybatis.entity.easyui.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/EasyUI")
public class UserDtoController {
    final UserService userService;

    @Autowired
    public UserDtoController(UserService userService) {
        this.userService = userService;
    }

    // 获取User(s)
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public UserDto getAllUerWithLimits(
            @RequestParam(value = "page", required = false, defaultValue = "0") long page,
            @RequestParam(value = "rows", required = false, defaultValue = "0") long rows
    ) {
        if (page <= 0 || rows <= 0) {
            List<User> user = userService.findAll();
            UserDto dto = new UserDto(HttpStatus.OK, user, "succeed");
            return dto;
        }
        long size = userService.countUsers();
        long start = (page - 1) * rows;
        List<User> users = userService.getAllUerWithLimits(start, rows);
        return new UserDto(HttpStatus.OK, size, users, "succeed");
    }
}
