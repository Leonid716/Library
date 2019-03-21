package ru.itpark.service;

import ru.itpark.domain.Book;
import ru.itpark.repository.BookRepository;

public class BookService {
    private BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(String isbn, String author, String name, String genre) {
        Book book = new Book(isbn, author, name, genre);
        repository.add(book);
    }

    public Book[] search(String author, String isbn, String genre) {
        Book[] result = new Book[3];
        int resultIndex = 0;

        Book[] books = repository.getAll();
        for (Book book : books) {
            if (book == null) {
                continue;
            }
            if (author != null) {
                if (!book.getAuthor().contains(author)) {
                    continue;
                }
            }
            if (isbn != null) {
                if (!book.getIsbn().equals(isbn)) {
                    continue;
                }
            }
            if (genre != null) {
                if (!book.getGenre().contains(genre)) {
                    continue;
                }
            }

            if (resultIndex == result.length) {
                break;
            }

            result[resultIndex] = book;
            resultIndex++;
        }
        return result;
    }
}
