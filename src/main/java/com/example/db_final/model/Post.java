package com.example.db_final.model;
import java.util.Date;
import lombok.Data;

@Data
public class Post {
        private Integer pid;
        private Integer uid;
        private Integer tid;
        private String p_title;
        private String p_body;
        private Date p_date;
        private Boolean status;
}
