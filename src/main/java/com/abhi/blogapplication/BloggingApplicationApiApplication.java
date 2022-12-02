package com.abhi.blogapplication;

import com.abhi.blogapplication.models.Role;
import com.abhi.blogapplication.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@SpringBootApplication
public class BloggingApplicationApiApplication implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BloggingApplicationApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(passwordEncoder.encode("Ajain@006"));

        Role role=new Role();
        role.setId(501);
        role.setName("ROLE_ADMIN");

        Role role1=new Role();
        role1.setId(502);
        role1.setName("ROLE_NORMAL");

        List<Role> roleList = List.of(role,role1);
        List<Role> results = roleRepository.saveAll(roleList);

        results.forEach(System.out::println);
    }
}
