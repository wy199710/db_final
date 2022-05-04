package com.example.db_final.model;
import java.util.Date;
import lombok.Data;

@Data
public class Post {
        private int p_id;
        private int u_id;
        private int t_id;
        private String p_title;
        private String p_body;
        private Date p_date;
        private Boolean status;
}
