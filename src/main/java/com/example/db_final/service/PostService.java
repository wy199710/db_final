package com.example.db_final.service;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    private Post temp;
    @Resource
    private PostMapper postMapper;

    public Post selectPostById(int id){
        temp = PostMapper.selectPostById(id);
        return temp;
    }

    public ArrayList<Post> selectAllPost() {
        return PostMapper.selectAllPost();
    }

    public ArrayList<Post> selectAllPostByUsername(String username) {
        return PostMapper.selectAllPostByUsername(username);
    }
}
