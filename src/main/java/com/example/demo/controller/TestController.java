package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    // 测试接口
    @PostMapping("/testRedis")
    public Result test(@RequestBody User user) {
        System.out.println(redisTemplate.execute(RedisConnectionCommands::ping));
        ValueOperations<String, Object> valueTemplate = redisTemplate.opsForValue();
        // 60s 生存期
        valueTemplate.set("login", user, 60, TimeUnit.SECONDS);
        // 获取
        user = (User) valueTemplate.get("login");
        HashMap<String, Object> data = new HashMap<>();
        data.put("user", user);
        return ResponseUtil.success(data);
    }
}
