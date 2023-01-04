package com.example.myapplication;


public class Book {
    private String title;
    private String authar;

    public Book() {

    }
    public Book(String title, String authar) {
        this.title = title;
        this.authar = authar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthar() {
        return authar;
    }

    public void setAuthar(String authar) {
        this.authar = authar;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title +
                ", authar='" + authar +
                '}';
    }
}

