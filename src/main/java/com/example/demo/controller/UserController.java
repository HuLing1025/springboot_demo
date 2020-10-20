package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/springboot/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/logon")
    public Result logon(@RequestBody User user) {
        Role role = new Role();
        role.setRole("user");
        user.setRole(role);
        return userService.logon(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping("/ban/{username}")
    public Result banLogin(@PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        return userService.banLogin(user);
    }

    @PutMapping("/allow/{username}")
    public Result allowLogin(@PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        return userService.allowLogin(user);
    }

    @GetMapping("/logout")
    public HashMap<String, Object> logout() {

        return null;
    }

    // 测试接口
    @GetMapping("/test")
    @ResponseBody
    public Result test() {
        System.out.println(redisTemplate.execute(RedisConnectionCommands::ping));
        return ResponseUtil.success();
    }
}
