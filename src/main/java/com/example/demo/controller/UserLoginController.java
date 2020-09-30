package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;

@RestController
@RequestMapping("/zb/user")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HashMap<String, Object> login(@PathParam("name") String name, @PathParam("password") String password) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            HashMap<String, String> getToken = new HashMap<>();
            User user = userService.selectUser(name, password);
            getToken.put("name", user.getName());
            getToken.put("id", user.getMailbox());
            String token = JwtUtil.getToken(getToken);
            map.put("token", token);
            map.put("status", true);
            map.put("msg", "认证成功");
        }catch (Exception e){
            map.put("status", false);
            map.put("msg", "认证失败");
        }
        return map;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public HashMap<String, Object> test() {
        HashMap<String, Object> map = new HashMap<>();

        map.put("status", true);
        map.put("msg","OK");
        return map;
    }

}
