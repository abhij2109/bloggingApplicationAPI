package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
