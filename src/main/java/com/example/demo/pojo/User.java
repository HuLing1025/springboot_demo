package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User{
    private int id;                 // id
    private String username;        // 用户名称
    private String password;        // 登录密码
    private Role role;              // 角色
    private int ban;                // 账号状态
}
