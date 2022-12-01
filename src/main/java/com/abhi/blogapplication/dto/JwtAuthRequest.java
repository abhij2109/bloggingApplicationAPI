package com.abhi.blogapplication.dto;

import lombok.Data;

@Data
public class JwtAuthRequest {
    private String userName;
    private String passWord;
}
