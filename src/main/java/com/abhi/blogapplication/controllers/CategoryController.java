package com.abhi.blogapplication.controllers;

import com.abhi.blogapplication.dto.ApiResponse;
import com.abhi.blogapplication.dto.CategoryDTO;
import com.abhi.blogapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blogging/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable("id") Integer id) {
        CategoryDTO updatedCat = categoryService.updateCategory(categoryDTO, id);
        return ResponseEntity.ok(updatedCat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getSingleCategory(@PathVariable("id") Integer id) {
        CategoryDTO cat = categoryService.getSingleCategory(id);
        return ResponseEntity.ok(cat);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> allUsers = categoryService.getCategories();
        return ResponseEntity.ok(allUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSingleCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);
    }
}
