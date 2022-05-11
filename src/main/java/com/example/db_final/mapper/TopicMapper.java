package com.example.db_final.mapper;

import com.example.db_final.model.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;

@Mapper
public interface TopicMapper {
    @Select("select * from Topic where t_id = #{t_id}")
    Topic selectTopicById(@Param("t_id") int t_id);

    @Select("select * from Topic natural join Post where p_id = #{p_id}")
    Topic selectTopicByPid(@Param("p_id") int p_id);

    @Select({"select * from Topic"})
    ArrayList<Topic> selectAllTopics();
}
