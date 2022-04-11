package com.abhi.blogapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private int categoryId;

    private String categoryTitle;

    private String description;

}
