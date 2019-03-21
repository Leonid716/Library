package ru.itpark.repository;

import ru.itpark.domain.Book;

public class BookRepository {
    private Book[] books = new Book[100];
    private int nextIndex = 0;

    public void add(Book book) {
        books[nextIndex] = book;
        nextIndex++;
    }

    public Book[] getAll() {
        return books;
    }
}
