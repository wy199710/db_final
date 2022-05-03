package com.example.db_final.controller;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import com.example.db_final.model.User;
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
        jsondata.put("posts", posts);
        return jsondata;
    }


    @GetMapping(value = "/post/{id}")
    @ResponseBody
    public Object getQuestionsById(@PathVariable("id") int id){
        Map<String,Object> jsondata = new HashMap<String,Object>();
        Post post = postService.selectPostById(id);
        jsondata.put("post", post);
        return jsondata;
    }




//    @RequestMapping(value = "/post/user")
//    public Object getPostByUsername(String username){
//        Map<ArrayList<Post>,Object> jsondata = new HashMap<ArrayList<Post>,Object>();
//        ArrayList<Post> posts = postService.selectAllPostByUsername(username);
//        if(posts == null){
//            jsondata.put("status", 404);
//            return jsondata;
//        }
//        jsondata.put("status", 200);
//        jsondata.put("posts", posts);
//        return jsondata;
//    }
}
