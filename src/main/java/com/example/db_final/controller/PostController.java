package com.example.db_final.controller;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import com.example.db_final.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
