package hu.younes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A BookCatalogTest osztály a BookCatalog osztály tesztelésére szolgál.
 * A tesztek ellenőrzik a könyvek hozzáadását, törlését és keresését.
 * Minden teszt előtt egy új katalógus példány és könyvek kerülnek inicializálásra.
 */
class BookCatalogTest {

    private BookCatalog catalog; // A könyvkatalógus példány
    private Book book1; // Az első könyv
    private Book book2; // A második könyv

    /**
     * Az alaphelyzetet előkészítő metódus, amely minden teszt előtt fut.
     * Létrehozza a könyvkatalógust és két könyvet hozzáad a katalógushoz.
     */
    @BeforeEach
    void setUp() {
        // Katalógus példányosítása
        catalog = new BookCatalog();

        // Első könyv szerzőkészletének létrehozása
        Set<String> authors1 = new HashSet<>();
        authors1.add("szerzo");
        // Első könyv példányosítása
        book1 = new Book("cim", authors1, 2025, 4000.0);

        // Második könyv szerzőkészletének létrehozása
        Set<String> authors2 = new HashSet<>();
        authors2.add("szerzo2");
        // Második könyv példányosítása
        book2 = new Book("cim2", authors2, 2024, 5000.0);

        // A könyvek hozzáadása a katalógushoz
        catalog.addBook(book1);
        catalog.addBook(book2);
    }

    /**
     * Teszteli, hogy a könyv sikeresen hozzáadódik a katalógushoz.
     * A katalógus méretének 2-nek kell lennie, mivel két könyvet adtunk hozzá.
     */
    @Test
    void testAddBook() {
        assertEquals(2, catalog.getBooks().size(), "A katalógus nem tartalmazza a két hozzáadott könyvet.");
    }

    /**
     * Teszteli, hogy egy könyv sikeresen törölhető a katalógusból ID alapján.
     * A könyv törlése után a katalógus méretének 1-nek kell lennie.
     */
    @Test
    void testRemoveBookById() {
        // Az első könyv ID-jét használjuk törléshez
        int idToRemove = book1.getId();
        // Könyv törlése
        boolean result = catalog.removeBookById(idToRemove);
        assertTrue(result, "A könyvet nem sikerült törölni.");
        assertEquals(1, catalog.getBooks().size(), "A törlés után nem csökkent a katalógus mérete.");
    }

    /**
     * Teszteli, hogy ha egy nem létező könyvet próbálunk törölni, akkor false-t kapunk vissza.
     * A katalógusban nincs olyan könyv, amelynek az ID-ja 9999 lenne.
     */
    @Test
    void testRemoveBookByIdNotFound() {
        // Egy nem létező könyv ID-ját próbáljuk törölni
        boolean result = catalog.removeBookById(9999);
        assertFalse(result, "A nem létező könyv törlése nem adhat pozitív eredményt.");
    }
}