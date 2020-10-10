package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM db_user WHERE username=#{username}")
    User selectUser(User user);

    @Insert("INSERT INTO db_user(username,password,role_id) VALUES(#{username},#{password},#{role.id})")
    int insertUser(User user);

    @Update("UPDATE db_user SET ban=1 WHERE username=#{username} and ban=0")
    int updateBan(User user);

    @Update("UPDATE db_user SET ban=0 WHERE username=#{username} and ban=1")
    int updateAllow(User user);
}
