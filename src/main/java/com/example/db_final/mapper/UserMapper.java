package com.example.db_final.mapper;

import com.example.db_final.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;
@Mapper
public interface UserMapper {
    @Select("select * from user where uid = #{uid}")
    User selectUserById(int uid);
    @Select({"select * from User where username = #{username}"})
    User selectUserByUserName(String username);
    @Insert("insert into user(username, password,email,city,state,country,profile) values(#{username}, #{password},#{email},#{city},#{state},#{country},#{profile}))")
    int insertUser(User user);

    @Select({"select * from User"})
    ArrayList<User> selectAllUsers();
}
