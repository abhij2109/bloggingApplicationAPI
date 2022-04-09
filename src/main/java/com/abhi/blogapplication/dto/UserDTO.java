package com.abhi.blogapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String about;
    private LocalDate userCreated;
}
