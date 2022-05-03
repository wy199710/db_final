package com.example.db_final.model;
import java.util.Date;
import lombok.Data;

@Data
public class Answer {
    private int a_id;
    private int u_id;
    private int p_id;
    private int t_id;
    private Date a_date;
    private String a_content;
    private int thumb_up;
    private Boolean best_answer;
}
