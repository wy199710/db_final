package com.example.db_final.controller;

import com.example.db_final.action.UserAction;
import com.example.db_final.mapper.UserMapper;
import com.example.db_final.model.User;
import com.example.db_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;

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