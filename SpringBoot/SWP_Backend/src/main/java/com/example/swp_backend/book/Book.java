package com.example.swp_backend.book;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private String isbn;
    private String description;
    private String image;

    public Book(String title, String author, String genre, int year, String isbn, String description, String image) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.isbn = isbn;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
