package com.example.db_final.service;

import org.springframework.stereotype.Service;
import com.example.db_final.mapper.TopicMapper;
import com.example.db_final.model.Topic;
import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class TopicService{
    @Resource
    public TopicMapper topicMapper;

    public Topic selectTopicById(int id){
        return topicMapper.selectTopicById(id);
    }

    public ArrayList<Topic> selectAllTopics() {
        return topicMapper.selectAllTopics();
    }
}
