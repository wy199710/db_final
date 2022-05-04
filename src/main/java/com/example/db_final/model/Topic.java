package com.example.db_final.model;
import lombok.Data;

@Data
public class Topic {
    private int t_id;
    private String t_name;
    private int parent_id;
}
