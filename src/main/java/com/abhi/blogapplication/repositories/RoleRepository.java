package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
