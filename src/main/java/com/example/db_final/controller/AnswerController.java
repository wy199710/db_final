package com.example.db_final.controller;

import com.example.db_final.mapper.AnswerMapper;
import com.example.db_final.model.Answer;
import com.example.db_final.model.User;
import com.example.db_final.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Resource
    private AnswerMapper answerMapper;

    @GetMapping(value = "/answer")
    @ResponseBody
    public Object selectAllAnswers() {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        ArrayList<Answer> answers= answerService.selectAllAnswer();
        jsondata.put("answer", answers);
        return jsondata;
    }

    @GetMapping(value = "/answer/{id}")
    @ResponseBody
    public Object selectAnswerById(@PathVariable("id") int id){
        Map<String,Object> jsondata = new HashMap<String,Object>();
        Answer answer = answerService.selectAnswerById(id);
        jsondata.put("answer", answer);
        return jsondata;
    }
}
