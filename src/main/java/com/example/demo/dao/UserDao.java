package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM db_user,db_role WHERE username=#{username} AND db_role.id=db_user.role_id")
    @Results({
            @Result(property = "role.id", column = "role_id"),
            @Result(property = "role.role", column = "role"),
            @Result(property = "role.permission", column = "permission")
    })
    User selectUser(User user);

    @Select(("SELECT * FROM db_user,db_role WHERE db_role.id=db_user.role_id ORDER BY db_user.id"))
    @Results({
            @Result(property = "role.id", column = "role_id"),
            @Result(property = "role.role", column = "role"),
            @Result(property = "role.permission", column = "permission")
    })
    List<User> selectUsers();

    @Insert("INSERT INTO db_user(username,password,role_id) VALUES(#{username},#{password},#{role.id})")
    int insertUser(User user);

    @Update({"<script> " +
            "UPDATE db_user SET " +
            "<if test='username!=null'>username=#{username}</if>" +
            "<if test='password!=null'>,password=#{password}</if>" +
            "<if test='role!=null'>,role_id=#{role.id}</if>" +
            "WHERE db_user.id=#{id}" +
            "</script>"})
    int updateUser(User user);

    @Update("UPDATE db_user SET ban=1 WHERE username=#{username} and ban=0")
    int updateBan(User user);

    @Update("UPDATE db_user SET ban=0 WHERE username=#{username} and ban=1")
    int updateAllow(User user);
}
