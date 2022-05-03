package com.example.db_final.controller;

import com.example.db_final.mapper.TopicMapper;
import com.example.db_final.model.Topic;
import com.example.db_final.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Resource
    private TopicMapper topicMapper;

    @RequestMapping(value = "/topic")
    public Object selectAllTopics() {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        ArrayList<Topic> topics = topicService.selectAllTopics();
        jsondata.put("topic", topics);
        return jsondata;
    }

    @GetMapping(value = "/topic/{id}")
    @ResponseBody
    public Object selectTopicById(@PathVariable("id") int id){
        Map<String,Object> jsondata = new HashMap<String,Object>();
        Topic topic = topicService.selectTopicById(id);
        jsondata.put("topic", topic);
        return jsondata;
    }
}
