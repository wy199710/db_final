package com.example.db_final.mapper;

import com.example.db_final.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User selectUserById(String username);

    @Insert("insert into user(username, password) values(#{username}, #{password})")
    int insertUser(User user);
}
