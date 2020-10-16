package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Role {
    private int id;             // id
    private String role;        // 角色名称
    private String permission;  // 角色权限
}
