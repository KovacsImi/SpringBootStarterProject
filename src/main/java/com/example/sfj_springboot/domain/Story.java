package com.example.sfj_springboot.domain;

import java.util.Date;

public class Story {

    private String title;
    private String author;
    private Date posted;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + posted +
                ", content='" + content + '\'' +
                '}';
    }
}
