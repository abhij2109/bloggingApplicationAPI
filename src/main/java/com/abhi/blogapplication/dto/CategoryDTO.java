package com.abhi.blogapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private int categoryId;

    @NotEmpty
    @Size(min=4,message = "Title must be greater than 4.")
    private String categoryTitle;

    @NotEmpty
    @Size(min=4,message = "Description must be greater than 4.")
    private String description;

}
