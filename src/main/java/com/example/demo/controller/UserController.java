package com.example.demo.controller;

import com.example.demo.api.UserService;
import com.example.demo.domain.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/getUserByUid", method = RequestMethod.GET)
    public User getOneById(HttpServletRequest request){
        int uid= Integer.parseInt(request.getParameter("id"));
        return userService.getOneByUid(uid);
    }

    @RequestMapping(value = "/getUserNameByUid", method = RequestMethod.GET)
    public String getUserName(HttpServletRequest request){
        int uid= Integer.parseInt(request.getParameter("id"));
        return userService.getUserNameByUid(uid);
    }

    @RequestMapping(value = "/deleteUserByUid", method = RequestMethod.DELETE)
    public int delete(HttpServletRequest request){
        int uid= Integer.parseInt(request.getParameter("id"));
        return userService.deleteOneByUid(uid);
    }

    @RequestMapping(value = "/updateUserName", method = RequestMethod.PUT)
    public int changeName(HttpServletRequest request){
        String password= request.getParameter("password");
        String username= request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("id"));
        User user=new User(username,password);
        user.setUid(id);
        return userService.updateUserNameByUid(user);
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public int addNewUser(HttpServletRequest request){
        String password= request.getParameter("password");
        String username= request.getParameter("username");
        User user=new User(username,password);
        return userService.insertNewUser(user);

    }
}
