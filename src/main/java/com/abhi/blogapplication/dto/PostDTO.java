package com.abhi.blogapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
public class PostDTO {

    private String title;

    private String content;

    private String imageName;

    private Date createdDate;

    private CategoryDTO category;

    private UserDTO user;

}
