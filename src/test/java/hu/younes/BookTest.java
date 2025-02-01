package hu.younes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;
    private Set<String> authors;

    @BeforeEach
    void setUp() {
        authors = new HashSet<>();
        authors.add("szerzo");
        book = new Book("cim", authors, 2025, 4000);
    }

    @Test
    void testGetItemInfo() {
        String expectedInfo = "ID: " + book.getId() + ", Title: cim, Szerző: [szerzo], Év: 2025, Ár: 4000.0 Ft";
        assertEquals(expectedInfo, book.getItemInfo());
    }

    @Test
    void testMatchesTitle() {
        assertTrue(book.matches("cim"));
        assertFalse(book.matches("rosszcim"));
    }

}
