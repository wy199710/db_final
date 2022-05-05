package com.example.db_final.model;
import lombok.Data;

@Data
public class Post {
        private int p_id;
        private int u_id;
        private int t_id;
        private String p_title;
        private String p_body;
        private String p_date;
        private String status;
}
