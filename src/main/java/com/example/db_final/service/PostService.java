package com.example.db_final.service;

import com.example.db_final.mapper.PostMapper;
import com.example.db_final.model.Post;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    public Map<String,Object> selectPostById(int p_id){
        return postMapper.selectPostById(p_id);
    }

    public ArrayList<Map<String,Object>> selectAllPost() {
        return postMapper.selectAllPost();
    }



    public int create(Post post) {
        postMapper.insertPost(post.getU_id(), post.getT_id(), post.getP_title(), post.getP_body(), post.getP_date(), post.getStatus());
        return 200;
    }
    public ArrayList<Map<String,Object>> searchPost(String keyword) {
        return postMapper.searchPost(keyword);
    }
}
