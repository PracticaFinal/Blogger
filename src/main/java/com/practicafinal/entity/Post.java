package com.practicafinal.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name="postid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "originalTitle",nullable = false)
    private String originalTitle;

    @Column(name = "translatedTitle",nullable = false)
    private String translatedTitle;

    @Column(name = "originalContent")
    private String originalContent;

    @Column(name = "translatedContent")
    private String translatedContent;

    @Column(name = "creationDate")
    private Date date;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "id_user"),name = "id_user",nullable = false)
    private User user;
}
