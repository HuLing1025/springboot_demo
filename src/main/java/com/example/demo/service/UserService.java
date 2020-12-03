package com.example.demo.service;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;

public interface UserService {
    /*
    * 登录验证
    * @param user
    * @return
    * */
    Result login(User user);

    /*
    * 注册
    * @param user
    * @return
    * */
    Result logon(User user);

    /*
    * 封号
    * @param user
    * @return
    * */
    Result banLogin(User user);

    /*
    * 解封
    * @param user
    * @return
    * */
    Result allowLogin(User user);

    /*
     * 获取用户列表
     * @return
     * */
    Result getUserList();

    /*
     * 更新用户
     * @param user
     * @return
     * */
    Result updateUser(User user);

}
