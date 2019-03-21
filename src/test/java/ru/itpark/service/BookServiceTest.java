package ru.itpark.service;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.Book;
import ru.itpark.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    @Test
    public void addBook() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        service.addBook("isbn2232323", "", "", "");
        service.addBook("isbn2232323", "", "", "");

        Book[] books = repository.getAll();
        assertNotEquals(0, books[0].getIsbn());
        assertNotEquals(0, books[1].getIsbn());
        assertNotEquals(0, books[0].getIsbn(), books[1].getIsbn());
    }

    @Test
    public void searchByIsbn() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        service.addBook("isbn222333", "", "", "");
        service.addBook("isbn333244", "", "", "");

        Book[] books = service.search("", "isbn222333", "");

        assertEquals("isbn222333", books[0].getIsbn());

    }

    @Test
    public void searchByAuthor() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        service.addBook("", "King", "", "");
        service.addBook("", "Tolstoy", "", "");

        Book[] books = service.search("Tolstoy", "", "");

        assertEquals("Tolstoy", books[0].getAuthor());
    }

    @Test
    public void searchByGenre() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        service.addBook("", "", "", "Horror, Triller");
        service.addBook("", "", "", "Detective");
        service.addBook("", "", "", "History");
        service.addBook("", "", "", "Biography");
        service.addBook("", "", "", "Horror");
        service.addBook("", "", "", "Fantasy, Horror");


        Book[] books = service.search("", "", "Horror");

        assertEquals("Horror, Triller", books[0].getGenre());
        assertEquals("Horror", books[1].getGenre());
        assertEquals("Fantasy, Horror", books[2].getGenre());

    }

    @Test
    public void resultLimit() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService (repository);
        service.addBook("", "", "", "");
        service.addBook("", "", "", "");
        service.addBook("", "", "", "");
        service.addBook("", "", "", "");

        Book[] books = service.search("", "", "");

        assertEquals("", books[0].getAuthor());
        assertEquals("", books[1].getAuthor());
        assertEquals("", books[2].getAuthor());

    }

    @Test
    public void ifNull() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService (repository);
        service.addBook("", "", "", "");

        Book[] books = service.search(null, null, null);

        assertEquals("", books[0].getAuthor());
        assertEquals("", books[0].getIsbn());
        assertEquals("", books[0].getGenre());
    }
}