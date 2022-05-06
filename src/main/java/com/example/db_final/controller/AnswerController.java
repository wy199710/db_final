package com.example.db_final.controller;

import com.example.db_final.mapper.AnswerMapper;
import com.example.db_final.mapper.TopicMapper;
import com.example.db_final.model.Answer;
import com.example.db_final.model.Topic;
import com.example.db_final.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Resource
    private TopicMapper topicMapper;

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
        ArrayList<Map<String,Object>> answer = answerService.selectAllAnswerByPid(id);
        jsondata.put("answer", answer);
        return jsondata;
    }

    @RequestMapping(value = "/addlike", method = RequestMethod.POST)
    public Object addLike(int a_id) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int status = answerService.addLike(a_id);
        if (status == 1) jsondata.put("status", 200);
        else jsondata.put("status", 500);
        return jsondata;
    }

    @RequestMapping(value = "/createanswer", method = RequestMethod.POST)
    public Object createAnswer(int p_id, String a_content, HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        Answer answer = new Answer();
        Topic topic = topicMapper.selectTopicByPid(p_id);
        int u_id = (int)session.getAttribute("u_id");
        Date day=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        answer.setU_id(u_id);
        answer.setP_id(p_id);
        answer.setT_id(topic.getT_id());
        answer.setA_content(a_content);
        answer.setA_date(sdf.format(day));
        answer.setThumbup(0);
        answer.setBest_answer(false);

        int status = answerService.insertAnswer(answer);
        if (status == 1) jsondata.put("status", 200);
        else jsondata.put("status", 500);
        return jsondata;
    }
}
