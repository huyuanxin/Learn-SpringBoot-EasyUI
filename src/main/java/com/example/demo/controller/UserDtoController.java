package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.po.User;
import com.example.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanxin
 * @create 2020/11/11 11:25
 */
@RestController
@RequestMapping("/EasyUI")
public class UserDtoController {
    final UserService userService;

    @Autowired
    public UserDtoController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public UserDTO getAllUerWithLimits(
            @RequestParam(value = "page", required = false, defaultValue = "0") long page,
            @RequestParam(value = "rows", required = false, defaultValue = "0") long rows
    ) {
        if (page <= 0 || rows <= 0) {
            List<User> user = userService.findAll();
            return new UserDTO(HttpStatus.OK, user, "succeed");
        }
        long size = userService.countTableRows("user");
        long start = (page - 1) * rows;
        List<User> users = userService.getAllUerWithLimits(start, rows);
        return new UserDTO(HttpStatus.OK, size, users, "succeed");
    }
}
