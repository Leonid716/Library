package ru.itpark.repository;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    @Test
    public void addOneBook() {
        BookRepository repository = new BookRepository();
        Book book = new Book("isbn1124453", "King", "It", "Horror");


        repository.add(book);

        Book[] books = repository.getAll();
        assertEquals(book,books[0]);

    }
}