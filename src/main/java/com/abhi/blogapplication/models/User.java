package com.abhi.blogapplication.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 50)
    private String userEmail;

    @Column(nullable = false, length = 20)
    private String userPassword;

    private String about;

    @Column(insertable = false,updatable = false)
    private Date userCreated;
}
