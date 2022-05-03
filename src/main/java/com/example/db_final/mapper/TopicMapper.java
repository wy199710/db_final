package com.example.db_final.mapper;

import com.example.db_final.model.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;

@Mapper
public interface TopicMapper {
    @Select("select * from Topic where tid = #{id}")
    Topic selectTopicById(@Param("t_id") int id);

    @Select({"select * from Topic"})
    ArrayList<Topic> selectAllTopics();
}
