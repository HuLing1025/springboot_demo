package com.example.demo.serviceImp;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public HashMap<String, Object> login(User user) {
        User userResult = userDao.selectUser(user);
        HashMap<String, Object> resultMap = new HashMap<>();
        if(userResult != null) {
           String password = userResult.getPassword();
           // MD5加密登录密码
           if(MD5Util.getMD5(user.getPassword()).equals(password)){     //验证密码
               if(userResult.getBan() == 1){
                   resultMap.put("status", 500);
                   resultMap.put("message", "该账号已被封禁!");
               }else if(userResult.getBan() == 0){
                   HashMap<String,String> getToken = new HashMap<>();
                   getToken.put("username", user.getUsername());
                   String token = JwtUtil.getToken(getToken);
                   resultMap.put("status", 200);
                   resultMap.put("message", "登录成功!");
                   resultMap.put("token", token);
               }
            }else{
               resultMap.put("status", 500);
               resultMap.put("message", "密码错误!");
               resultMap.put("token","");
           }
        }else{
            resultMap.put("status", 400);
            resultMap.put("message", "没有该用户!");
            resultMap.put("token","");
        }
        return resultMap;
    }

    @Override
    public HashMap<String, Object> logon(User user) {
        User userResult = userDao.selectUser(user);
        HashMap<String, Object> resultMap = new HashMap<>();
        if(userResult != null) {       // 该用户已注册
            resultMap.put("status", 500);
            resultMap.put("message", "该用户已注册!");
        }else{                         // 注册
            Role roleResult = roleDao.selectRole(user.getRole());
            if(roleResult != null){
                user.setRole(roleResult);
                // MD5加密
                user.setPassword(MD5Util.getMD5(user.getPassword()));
                userDao.insertUser(user);
                resultMap.put("status", 200);
                resultMap.put("message", "注册成功!");
            }else{
                resultMap.put("status", 500);
                resultMap.put("message", "没有该角色!");
            }
        }
        return resultMap;
    }

    @Override
    public HashMap<String, Object> banLogin(User user) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if(userDao.updateBan(user) == 1){
            resultMap.put("status", 200);
            resultMap.put("message", "封号成功!");
        }else{
            resultMap.put("status", 500);
            resultMap.put("message", "封号失败!");
        }
        return resultMap;
    }

    @Override
    public HashMap<String, Object> allowLogin(User user) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if(userDao.updateAllow(user) == 1){
            resultMap.put("status", 200);
            resultMap.put("message", "解封成功!");
        }else{
            resultMap.put("status", 500);
            resultMap.put("message", "解封失败!");
        }
        return resultMap;
    }
}
