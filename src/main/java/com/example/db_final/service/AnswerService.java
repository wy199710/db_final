package com.example.db_final.service;

import com.example.db_final.model.Answer;
import com.example.db_final.mapper.AnswerMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class AnswerService {
    @Resource
    private AnswerMapper answerMapper;

    public Answer selectAnswerById(int id){
        return answerMapper.selectAnswerById(id);
    }

    public ArrayList<Answer> selectAllAnswer() {
        return answerMapper.selectAllAnswer();
    }

    public ArrayList<Answer> selectAnswerByUsername(String username) {
        return answerMapper.selectAnswerByUsername(username);
    }

    public ArrayList<Answer> selectAllAnswerByPid(int pid) {
        return answerMapper.selectAllAnswerByPid(pid);
    }

    public int addLike(int aid) {
        return answerMapper.updateThumbUp(aid);
    }
}
