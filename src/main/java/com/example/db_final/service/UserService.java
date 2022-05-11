package com.example.db_final.service;

import com.example.db_final.mapper.UserMapper;
import com.example.db_final.model.Answer;
import com.example.db_final.model.Post;
import com.example.db_final.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

@Service
public class UserService {
    private User temp;

    @Resource
    private UserMapper userMapper;

    public User selectUserById( int u_id){
        return userMapper.selectUserById(u_id);
    }

    public ArrayList<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    public User selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }

    public ArrayList<Map<String,Object>> selectAllPostByUsername(String uname) {
        return userMapper.selectAllPostByUsername(uname);
    }

    public ArrayList<Map<String,Object>> selectAllAnswerByUsername(String uname) {
        return userMapper.selectAllAnswerByUsername(uname);
    }

    public int updateProfile(User user) {
        userMapper.updateProfile(user.getU_id(),user.getEmail(),user.getCity(),user.getState(),user.getCountry(),user.getProfile());
        return 200;
    }

    public int updatePoint(int u_id){return userMapper.updatePoint(u_id);}

    public int updateLevel(int u_id){return userMapper.updateLevel(u_id);}

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