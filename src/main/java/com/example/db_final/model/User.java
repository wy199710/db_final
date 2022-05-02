package com.example.db_final.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String profile;
    private String level;
    private String city;
    private String state;
    private String country;
}