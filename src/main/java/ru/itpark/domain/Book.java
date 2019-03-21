package ru.itpark.domain;

public class Book {
    private String isbn;
    private String author;
    private String name;
    private String genre;

    public Book(String isbn, String author, String name, String genre) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

}
