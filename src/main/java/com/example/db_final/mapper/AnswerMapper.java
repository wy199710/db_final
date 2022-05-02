package com.example.db_final.mapper;

import com.example.db_final.model.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.ArrayList;
import java.util.Date;
@Mapper
public interface AnswerMapper {
    @Select("select * from Answer where aid = #{id}")
    public Answer selectAnswerById(int id);

    @Select("select * from Answer order by date desc")
    ArrayList<Answer> selectAllAnswer();

    @Select("select * from Answer inner join User on User.uid = Answer.uid and username = #{username} order by thumb_up desc, date desc")
    ArrayList<Answer> selectAnswerByUsername(String username);

    @Select("select * from Answer where pid = #{id} order by thumb_ups desc, date desc")
    ArrayList<Answer> selectAllAnswerByPid(int id);

    @Insert("insert into Answer (uid, pid,tid, a_date, a_content) values(#{uid},#{pid},#{tid},#{a_date},#{a_content})")
    int insertAnswer(int uid, int pid, int tid,Date a_date, String a_content);

    @Update("update Answer set thumb_up = #{thumb_up} where aid = #{id}")
    int updateThumbUp(int id, int thumb_up);

    @Update("update Answer set best_answer = #{best_answer} where aid = #{id}")
    int updateBestAnswer(int id, boolean best_answer);
}
