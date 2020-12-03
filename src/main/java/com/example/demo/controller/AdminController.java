package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/springboot/admin")
@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @CrossOrigin
    public Result getUserList(){
        // 在这里拦截Header作一个token验证,看是不是admin角色
        return userService.getUserList();
    }

}
