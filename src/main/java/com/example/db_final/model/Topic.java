package com.example.db_final.model;
import lombok.Data;

@Data
public class Topic {
    private Integer tid;
    private String t_name;
    private Integer parent_id;
}
