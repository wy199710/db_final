package com.example.db_final.mapper;

import com.example.db_final.model.Answer;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;
@Mapper
public interface AnswerMapper {
    @Select("select * from Answer where a_id = #{a_id}")
    Answer selectAnswerById(@Param("a_id")int a_id);

    @Select("select * from Answer order by a_date desc")
    ArrayList<Answer> selectAllAnswer();

    @Select("select * from Answer inner join User on User.u_id= Answer.u_id and username = #{username} order by thumbup desc, a_date desc")
    ArrayList<Answer> selectAnswerByUsername(String username);

    @Select("select * from Answer where p_id = #{p_id} order by thumbup desc, a_date desc")
    ArrayList<Answer> selectAllAnswerByPid(@Param("p_id")int p_id);

    @Insert("insert into Answer (u_id, p_id,t_id, a_date, a_content) values(#{u_id},#{p_id},#{t_id},#{a_date},#{a_content})")
    int insertAnswer(@Param("u_id")int u_id, @Param("p_id")int p_id, @Param("t_id")int t_id,Date a_date, String a_content);

    @Update("update Answer set thumbup = thumbup + 1 where a_id = #{a_id}")
    int updateThumbUp(@Param("a_id")int a_id);

    @Update("update Answer set best_answer = #{best_answer} where a_id = #{a_id}")
    int updateBestAnswer(@Param("a_id") int a_id, boolean best_answer);
}
