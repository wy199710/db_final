package com.example.db_final.mapper;
import com.example.db_final.model.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Map;
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

    @Select("select * from Answer A natural join User U inner join Post P on A.p_id = P.p_id where U.username = #{username} order by A.a_date desc")
    ArrayList<Map<String,Object>> selectAllAnswerByUsername(String username);

    @Select("select * from Post natural join User natural join Topic where username = #{username} order by p_date desc")
    ArrayList<Map<String,Object>> selectAllPostByUsername(String username);

    @Update("update User U inner join (select A.u_id as tid, SUM(A.thumbup) as total FROM Answer A group by A.u_id) tmp on tmp.tid = U.u_id set U.point = tmp.total Where U.u_id = #{id}")
    int updatePoint(@Param("id")int id);

    @Update("update User set level= CASE WHEN point>10 THEN 3  WHEN point>5  THEN 2  ELSE 1 END where u_id = #{id}")
    int updateLevel(@Param("id")int id);

}
