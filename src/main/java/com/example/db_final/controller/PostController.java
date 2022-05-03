package com.example.db_final.controller;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import com.example.db_final.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        ArrayList<Post> posts = postService.selectAllPost();
        jsondata.put("post", posts);
        return jsondata;
    }


    @GetMapping(value = "/post/{id}")
    @ResponseBody
    public Object selectPostById(@PathVariable("id") int id){
        Map<String,Object> jsondata = new HashMap<String,Object>();
        Post post = postService.selectPostById(id);
        jsondata.put("post", post);
        return jsondata;
    }
}
