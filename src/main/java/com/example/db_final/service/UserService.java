package com.example.db_final.service;

import com.example.db_final.mapper.UserMapper;
import com.example.db_final.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    private User temp;

    @Resource
    private UserMapper userMapper;

    public int login(User user) {
        temp = userMapper.selectUserByUserName(user.getUsername());
        if(temp != null) {
            if(temp.getPassword().equals(user.getPassword())) {
                return 200;
            }
            return 400;
        }
        else return 404;
    }

    public int register(User user) {
        if(userMapper.selectUserByUserName(user.getUsername()) != null)
            return 400;
        else {
            userMapper.insertUser(user);
            return 200;
        }
    }
}