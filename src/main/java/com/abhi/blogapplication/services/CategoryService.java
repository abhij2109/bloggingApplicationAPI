package com.abhi.blogapplication.services;

import com.abhi.blogapplication.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO dto);

    CategoryDTO updateCategory(CategoryDTO dto,Integer id);

    void deleteCategory(Integer id);

    CategoryDTO getSingleCategory(Integer id);

    List<CategoryDTO> getCategories();

}
