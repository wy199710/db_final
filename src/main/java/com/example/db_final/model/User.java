package com.example.db_final.model;
import lombok.Data;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String city;
    private String state;
    private String country;
    private String profile;
    private String level;
    private int point;
}