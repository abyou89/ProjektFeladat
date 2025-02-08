package hu.younes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A BookTest osztály a Book osztály tesztelésére szolgál.
 * A tesztek célja, hogy biztosítsák a Book osztály funkcionalitásának helyes működését,
 * beleértve a metódusok eredményeit és a megfelelő viselkedést különböző bemenetekkel.
 */
class BookTest {

    private Book book;
    private Set<String> authors;

    /**
     * A tesztelés előtt meghívódó metódus, amely minden egyes teszt előtt végrehajtódik.
     * Inicializálja a könyv példányt és beállítja a könyv szerzőit.
     */
    @BeforeEach
    void setUp() {
        authors = new HashSet<>();
        authors.add("szerzo");
        book = new Book("cim", authors, 2025, 4000);
    }

    /**
     * Teszteli a {@link Book#getItemInfo()} metódust.
     * Ellenőrzi, hogy a könyv adatai helyesen jelennek meg, beleértve a könyv címét,
     * szerzőit, kiadási évét és árát.
     */
    @Test
    void testGetItemInfo() {
        String expectedInfo = "ID: " + book.getId() + ", Title: cim, Szerző: [szerzo], Év: 2025, Ár: 4000.0 Ft";
        assertEquals(expectedInfo, book.getItemInfo());
    }

    /**
     * Teszteli a {@link Book#matches(String)} metódust a cím alapján.
     * Ellenőrzi, hogy a könyv címének megfelelő kulcsszóval való keresés helyes eredményt ad.
     */
    @Test
    void testMatchesTitle() {
        // Igaz, ha a keresett kulcsszó egyezik a könyv címével
        assertTrue(book.matches("cim"));
        // Hamis, ha a keresett kulcsszó nem egyezik a könyv címével
        assertFalse(book.matches("rosszcim"));
    }

}