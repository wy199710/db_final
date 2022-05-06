package com.example.db_final.controller;

import com.example.db_final.mapper.AnswerMapper;
import com.example.db_final.model.Answer;
import com.example.db_final.model.User;
import com.example.db_final.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Resource
    private AnswerMapper answerMapper;

    @RequestMapping(value = "/answer")
    public Object selectAllAnswers() {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        ArrayList<Answer> answers = answerService.selectAllAnswer();
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

    @GetMapping(value = "/answerbypid/{id}")
    @ResponseBody
    public Object selectAllAnswerByPid(@PathVariable("id") int id){
        Map<String,Object> jsondata = new HashMap<String,Object>();
        ArrayList<Answer> answer = answerService.selectAllAnswerByPid(id);
        jsondata.put("answer", answer);
        return jsondata;
    }

    @RequestMapping(value = "/addlike", method = RequestMethod.POST)
    public Object addLike(int a_id) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int status = answerService.addLike(a_id);
        if (status == 1) jsondata.put("status", 200);
        else jsondata.put("status", 200);
        return jsondata;
    }
}
