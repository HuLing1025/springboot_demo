package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.HashMap;

public interface UserService {
    /*
    * 登录验证
    * @param user
    * @return
    * */
    HashMap<String, Object> login(User user);

    /*
    * 注册
    * @param user
    * @return
    * */
    HashMap<String, Object> logon(User user);

    /*
    * 封号
    * @param user
    * @return
    * */
    HashMap<String, Object> banLogin(User user);

    /*
    * 解封
    * @param user
    * @return
    * */
    HashMap<String, Object> allowLogin(User user);

}
