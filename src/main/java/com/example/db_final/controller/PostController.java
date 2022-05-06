package com.example.db_final.controller;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import com.example.db_final.service.PostService;
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
public class PostController {
    @Autowired
    private PostService postService;

    @Resource
    private PostMapper postMapper;

    @RequestMapping(value = "/post")
    public Object selectAllPosts() {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        ArrayList<Map<String,Object>> posts = postService.selectAllPost();
        jsondata.put("post", posts);
        return jsondata;
    }

    @GetMapping(value = "/post/{id}")
    @ResponseBody
    public Object selectPostById(@PathVariable("id") int id){
        Map<String,Object> jsondata = new HashMap<String,Object>();
        Map<String,Object> post = postService.selectPostById(id);
        jsondata.put("post", post);
        return jsondata;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object createPost(Post post, HttpSession session) {
        Map<String,Object> jsondata = new HashMap<String,Object>();
        int u_id = (int)session.getAttribute("u_id");
        post.setU_id(u_id);
        Date day=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        post.setP_date(sdf.format(day));

        int status = postService.create(post);
        if (status == 500) {
            jsondata.put("status", 500);
        } else {
            jsondata.put("status", 200);
        }
        return jsondata;
    }
}
