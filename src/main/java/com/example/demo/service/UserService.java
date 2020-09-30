package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {
    /*
    * 登录验证
    * @param name
    * @param password
    * */
    public User selectUser(String name, String password);
}
