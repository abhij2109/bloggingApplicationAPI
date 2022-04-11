package com.abhi.blogapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDTO {
    private int id;

    @NotEmpty
    @Size(min=4,message="Name of the user must be of min 4 character!")
    private String userName;
    @Email(message = "Email address is not valid!")
    private String userEmail;
    @NotNull
    @Size(min=4,max=12,message = "Password must be min of 4 and max of 4 characters!")
    private String userPassword;
    @NotNull
    private String about;
    private LocalDate userCreated;
}
