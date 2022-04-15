package com.abhi.blogapplication.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name="post_title")
    private String title;

    private String imageName;

    @Column(length = 10000)
    private String content;

    private Date createdDate;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


}
