package com.example.demo.controller;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/springboot/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/logon")
    public HashMap<String, Object> logon(@RequestBody User user) {
        Role role = new Role();
        role.setRole("user");
        user.setRole(role);
        return userService.logon(user);
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping("/ban/{username}")
    public HashMap<String, Object> banLogin(@PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        return userService.banLogin(user);
    }

    @PutMapping("/allow/{username}")
    public HashMap<String, Object> allowLogin(@PathVariable String username) {
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
    public HashMap<String, Object> test(@RequestBody User user) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user", user);
        return result;
    }
}
