package com.example.db_final.mapper;
import com.example.db_final.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Mapper
public interface PostMapper {
    @Select("select * from Post natural join Topic natural join User where p_id = #{p_id}")
    Map<String,Object> selectPostById(@Param("p_id")int p_id);

    @Select("select * from Post natural join User natural join Topic order by p_date desc")
    ArrayList<Map<String,Object>> selectAllPost();

    @Select("select * from Post natural join Topic natural join User where t_name = #{t_name} order by p_date desc")
    ArrayList<Map<String,Object>> selectPostByTname(@Param("t_name")String t_name);

    @Select("select * from Post inner join User on User.u_id = Post.u_id and username = #{username} order by p_date desc")
    ArrayList<Post> selectAllPostByUsername(String username);

    @Select("select * from Post natural join Topic natural join User where t_parent_id = #{t_id} order by p_date desc")
    ArrayList<Map<String,Object>> selectPostByParentid(@Param("t_id")int t_id);

    @Select("select * from Post natural join Topic natural join User where t_parent_id = #{t_id} and t_name = #{t_name}  order by p_date desc")
    ArrayList<Map<String,Object>> selectPostByParentidAndTname(@Param("t_id")int t_id,@Param("t_name")String t_name);

    @Insert("insert into Post (u_id, t_id, p_title, p_body, p_date, status) values(#{u_id},#{t_id},#{p_title},#{p_body},#{p_date})")
    int insertPost(@Param("u_id")int u_id, @Param("t_id")int t_id, String p_title, String p_body,String p_date);

    @Update("update Post set status = #{status} where p_id = #{p_id}")
    int updateStatus(@Param("p_id")int p_id,boolean status);

    @Select("select * from Post natural join User natural join Topic where p_title like '%${keyword}%' or p_body like '%${keyword}%' order by p_date desc")
    ArrayList<Map<String,Object>> searchPost(String keyword);
}
