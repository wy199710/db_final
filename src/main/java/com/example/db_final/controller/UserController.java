package com.example.db_final.controller;

import com.example.db_final.action.UserAction;
import com.example.db_final.mapper.UserMapper;
import com.example.db_final.model.User;
import com.example.db_final.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public Object selectUserById(@PathVariable ("id")int uid) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        User user= userService.selectUserById(uid);
        jsondata.put("user", user);
        return jsondata;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(User user, HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int status = userService.login(user);

        if (status == 200) {
            session.setAttribute("user", user.getUsername());
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
        if(user == null)
        {
            jsondata.put("status", 404);
            return jsondata;
        }
        jsondata.put("status", 200);
        jsondata.put("user", user);
        return jsondata;
    }
}