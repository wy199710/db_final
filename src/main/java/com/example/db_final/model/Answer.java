package com.example.db_final.model;
import java.util.Date;
import lombok.Data;

@Data
public class Answer {
    private Integer aid;
    private Integer uid;
    private Integer pid;
    private Integer tid;
    private Date a_date;
    private String a_content;
    private Integer thumb_up;
    private Boolean best_answer;
}
