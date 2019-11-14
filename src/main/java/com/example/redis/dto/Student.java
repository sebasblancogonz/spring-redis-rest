package com.example.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;
}

