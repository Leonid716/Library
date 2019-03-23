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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
