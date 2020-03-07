package com.practicafinal.team.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "idpost", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "titleTra")
    private String traductedTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "contentTra")
    private String traductedContent;

    @Column(name = "lenguage")
    private String lenguage;

    @Column(name = "lenguageTra")
    private String traductedLenguage;

    @Column(name = "date")
    private Date datePost;

    @ManyToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "user_iduser"),
            name = "user_iduser",
            nullable = false)
    private User user;

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTraductedTitle() {
        return traductedTitle;
    }

    public void setTraductedTitle(String traductedTitle) {
        this.traductedTitle = traductedTitle;
    }

    public String getTraductedContent() {
        return traductedContent;
    }

    public void setTraductedContent(String traductedContent) {
        this.traductedContent = traductedContent;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public String getTraductedLenguage() {
        return traductedLenguage;
    }

    public void setTraductedLenguage(String traductedLenguage) {
        this.traductedLenguage = traductedLenguage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }
}
