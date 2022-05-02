package com.example.db_final.service;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    public Post selectPostById(int id){
        return postMapper.selectPostById(id);
    }

    public ArrayList<Post> selectAllPost() {
        return postMapper.selectAllPost();
    }

    public ArrayList<Post> selectAllPostByUsername(String username) {
        return postMapper.selectAllPostByUsername(username);
    }
}
