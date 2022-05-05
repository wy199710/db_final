package com.example.db_final.mapper;
import com.example.db_final.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;
@Mapper
public interface PostMapper {
    @Select("select * from Post where p_id = #{p_id}")
    Post selectPostById(@Param("p_id")int p_id);

    @Select("select * from Post order by p_date desc")
    ArrayList<Post> selectAllPost();

    @Select("select * from Post inner join User on User.u_id = Post.u_id and username = #{username} order by p_date desc")
    ArrayList<Post> selectAllPostByUsername(String username);

    @Select("select * from Post where t_id = #{t_id} order by p_date desc")
    ArrayList<Post> selectAllPostByTid(@Param("t_id")int t_id);

    @Select("select * from Post where u_id = #{u_id} and t_id = #{t_id} order by p_date desc")
    ArrayList<Post> selectAllPostByByUidAndTid(@Param("p_id")int u_id, @Param("t_id")int t_id);

    @Insert("insert into Post (u_id, t_id, p_title, p_body, p_date, status) values(#{u_id},#{t_id},#{p_title},#{p_body},#{p_date},#{status})")
    int insertPost(@Param("u_id")int u_id, @Param("t_id")int t_id, String p_title, String p_body,String p_date, String status);

    @Update("update Post set status = #{status} where p_id = #{p_id}")
    int updateStatus(@Param("p_id")int p_id,boolean status);

}
