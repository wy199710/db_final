package com.example.db_final.model;
import java.util.Date;
import lombok.Data;

@Data
public class Answer {
    private Integer aid;
    private Integer uid;
    private Integer pid;
    private Integer tid;
    private String a_content;
    private Date a_date;
    private Integer thumbup;
    private Boolean best_answer;
}
