package com.example.db_final.service;

import com.example.db_final.mapper.UserMapper;
import com.example.db_final.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class UserService {
    private User temp;

    @Resource
    private UserMapper userMapper;

    public User selectUserById( int uid){
        return userMapper.selectUserById(uid);
    }

    public ArrayList<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    public User selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }

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