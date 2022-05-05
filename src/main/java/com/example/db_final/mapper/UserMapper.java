package com.example.db_final.mapper;

import com.example.db_final.model.Answer;
import com.example.db_final.model.Post;
import com.example.db_final.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;
@Mapper
public interface UserMapper {
    @Select("select * from user where u_id = #{u_id}")
    User selectUserById(@Param("u_id")int u_id);
    @Select({"select * from User where username = #{username}"})
    User selectUserByUserName(String username);
    @Insert("insert into user(username, password,email,city,state,country,profile) values(#{username}, #{password},#{email},#{city},#{state},#{country},#{profile})")
    int insertUser(User user);

    @Select({"select * from User"})
    ArrayList<User> selectAllUsers();

    @Select("select * from Post natural join User where username = #{username} order by p_date desc")
    ArrayList<Post> selectAllPostByUsername(String username);

    @Select("select * from Answer natural join User where username = #{username} order by a_date desc")
    ArrayList<Answer> selectAllAnswerByUsername(String username);
}
