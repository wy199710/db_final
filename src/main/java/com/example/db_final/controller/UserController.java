package com.example.db_final.controller;

import com.example.db_final.action.UserAction;
import com.example.db_final.mapper.UserMapper;
import com.example.db_final.model.Answer;
import com.example.db_final.model.Post;
import com.example.db_final.model.User;
import com.example.db_final.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/user")
    @ResponseBody
    public Object selectAllUsers() {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        ArrayList<User> users = userService.selectAllUsers();
        jsondata.put("user", users);
        return jsondata;
    }

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public Object selectUserById(@PathVariable ("id")int u_id) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        User user= userService.selectUserById(u_id);
        jsondata.put("user", user);
        return jsondata;
    }
    @GetMapping(value = "/point/{id}")
    @ResponseBody
    public Object updatePoint(@PathVariable ("id")int u_id) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        userService.updatePoint(u_id);
        User user= userService.selectUserById(u_id);
        jsondata.put("user", user);
        return jsondata;
    }

    @RequestMapping(value = "/level/{id}")
    public Object updateLevel(@PathVariable ("id")int u_id) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        userService.updateLevel(u_id);
        User user= userService.selectUserById(u_id);
        jsondata.put("user", user);
        return jsondata;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(User user, HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int status = userService.login(user);
        if (status == 200) {
            int u_id = userService.selectUserByUserName(user.getUsername()).getU_id();
            session.setAttribute("user", user.getUsername());
            session.setAttribute("u_id", u_id);
        }
        jsondata.put("status", status);
        return jsondata;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(User user) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int status = userService.register(user);
        jsondata.put("status", status);
        return jsondata;
    }

    @RequestMapping(value = "/getuserinfo", method = RequestMethod.GET)
    public Object getUserInfo(HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        if(!new UserAction().islogined(session))
        {
            jsondata.put("status", 404);
            return jsondata;
        }
        User user = userMapper.selectUserByUserName((String)session.getAttribute("user"));
        if(user == null) {
            jsondata.put("status", 404);
            return jsondata;
        }
        jsondata.put("status", 200);
        jsondata.put("user", user);
        return jsondata;
    }

    @RequestMapping(value = "/getuserpost", method = RequestMethod.GET)
    public Object getUserPost(HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        if(!new UserAction().islogined(session))
        {
            jsondata.put("status", 404);
            return jsondata;
        }
        ArrayList<Map<String,Object>> arr = userService.selectAllPostByUsername((String)session.getAttribute("user"));

        jsondata.put("status", 200);
        jsondata.put("postList", arr);
        return jsondata;
    }

    @RequestMapping(value = "/getuseranswer", method = RequestMethod.GET)
    public Object getUserAnswer(HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        if(!new UserAction().islogined(session))
        {
            jsondata.put("status", 404);
            return jsondata;
        }
        ArrayList<Map<String,Object>> arr = userService.selectAllAnswerByUsername((String)session.getAttribute("user"));

        jsondata.put("status", 200);
        jsondata.put("answerList", arr);
        return jsondata;
    }
    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public Object updateProfile(User user, HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int u_id = (int)session.getAttribute("u_id");
        user.setU_id(u_id);
        int status = userService.updateProfile(user);
        if (status == 500) {
            jsondata.put("status", 500);
        } else {
            jsondata.put("status", 200);
        }
        return jsondata;
    }

}