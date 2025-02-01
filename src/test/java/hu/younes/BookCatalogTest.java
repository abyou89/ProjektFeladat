package hu.younes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookCatalogTest {

    private BookCatalog catalog;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        catalog = new BookCatalog();
        Set<String> authors1 = new HashSet<>();
        authors1.add("szerzo");
        book1 = new Book("cim", authors1, 2025, 4000.0);

        Set<String> authors2 = new HashSet<>();
        authors2.add("szerzo2");
        book2 = new Book("cim2", authors2, 2024, 5000.0);

        catalog.addBook(book1);
        catalog.addBook(book2);
    }

    @Test
    void testAddBook() {
        assertEquals(2, catalog.getBooks().size());
    }

    @Test
    void testRemoveBookById() {
        int idToRemove = book1.getId();
        boolean result = catalog.removeBookById(idToRemove);
        assertTrue(result);
        assertEquals(1, catalog.getBooks().size());
    }

    @Test
    void testRemoveBookByIdNotFound() {
        boolean result = catalog.removeBookById(9999);
        assertFalse(result);
    }

}