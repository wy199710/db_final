package com.example.db_final.model;
import lombok.Data;

@Data
public class User {
    private int u_id;
    private String username;
    private String password;
    private String email;
    private String city;
    private String state;
    private String country;
    private String profile;
    private int level;
    private int point;
}