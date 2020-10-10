package com.example.demo.dao;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleDao {
    @Select("SELECT * FROM db_role WHERE role=#{role}")
    Role selectRole(Role role);
}
