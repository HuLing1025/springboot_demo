package com.example.demo.serviceImp;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.ResponseUtil;
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
    public Result login(User user) {
        User userResult = userDao.selectUser(user);
        if(userResult != null) {
           String password = userResult.getPassword();
           // MD5加密登录密码
           if(MD5Util.getMD5(user.getPassword()).equals(password)){     //验证密码
               if(userResult.getBan() == 1){
                   return ResponseUtil.error(500, "该账号已被封禁!");
               }else if(userResult.getBan() == 0){
                   HashMap<String,String> getToken = new HashMap<>();
                   getToken.put("username", user.getUsername());
                   String token = JwtUtil.getToken(getToken);
                   HashMap<String, Object> data = new HashMap<>();
                   data.put("user", userResult);
                   data.put("token", token);
                   return ResponseUtil.success(data, 200, "登录成功!");
               }
            }else{
               return ResponseUtil.error(500,"密码错误!");
           }
        }else{
            return ResponseUtil.error(400,"没有该用户!");
        }
        return null;
    }

    @Override
    public Result logon(User user) {
        User userResult = userDao.selectUser(user);
        if(userResult != null) {       // 该用户已注册
            return ResponseUtil.error(500, "该账号已被注册!");
        }else{                         // 注册
            Role roleResult = roleDao.selectRole(user.getRole());
            if(roleResult != null){
                user.setRole(roleResult);
                // MD5加密
                user.setPassword(MD5Util.getMD5(user.getPassword()));
                userDao.insertUser(user);
                HashMap<String, Object> data = new HashMap<>();
                data.put("user", user);
                return ResponseUtil.success(data, 200, "注册成功!");
            }else{
                return ResponseUtil.error(500, "没有该角色!");
            }
        }
    }

    @Override
    public Result banLogin(User user) {
        if(userDao.updateBan(user) == 1){
            return ResponseUtil.success(200, "封号成功!");
        }else{
            return ResponseUtil.error(500, "封号失败!");
        }
    }

    @Override
    public Result allowLogin(User user) {
        if(userDao.updateAllow(user) == 1){
            return ResponseUtil.success(200, "解封成功!");
        }else{
            return ResponseUtil.error(500, "解封失败!");
        }
    }
}
