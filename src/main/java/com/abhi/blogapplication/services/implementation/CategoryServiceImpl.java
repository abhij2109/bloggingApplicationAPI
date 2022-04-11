package com.abhi.blogapplication.services.implementation;

import com.abhi.blogapplication.dto.CategoryDTO;
import com.abhi.blogapplication.exceptions.ResourceNotFoundException;
import com.abhi.blogapplication.models.Category;
import com.abhi.blogapplication.repositories.CategoryRepository;
import com.abhi.blogapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category=this.modelMapper.map(dto,Category.class);
        Category cat=categoryRepository.save(category);
        return this.modelMapper.map(cat,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO dto, Integer id) {
        Category cat=categoryRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","Id",id)
        );
        cat.setCategoryTitle(dto.getCategoryTitle());
        cat.setDescription(dto.getDescription());
        Category updatedCategory=categoryRepository.save(cat);
        return this.modelMapper.map(updatedCategory,CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer id) {

    }

    @Override
    public CategoryDTO getSingleCategory(Integer id) {
        return null;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return null;
    }
}
