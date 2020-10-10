package com.example.demo.pojo;

public class Role {
    private int id;             // id
    private String role;        // 角色名称
    private String permission;  // 角色权限

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
