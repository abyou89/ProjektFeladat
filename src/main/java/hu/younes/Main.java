package hu.younes;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();

        // Példakönyvek
        Set<String> authors1 = new HashSet<>();
        authors1.add("szerző 1");
        Book book1 = new Book("cím", authors1, 2024, 5000);

        Set<String> authors2 = new HashSet<>();
        authors2.add("szerző 2");
        Book book2 = new Book("cím 2", authors2, 2023, 4000);

        // Könyvek hozzáadása
        catalog.addBook(book1);
        catalog.addBook(book2);

        // Könyvek mentése szöveges fájlba
        catalog.saveToTextFile("books.txt");

        // Könyvek betöltése szöveges fájlból
        catalog.loadFromTextFile("books.txt");

        // Könyvek mentése bináris fájlba
        catalog.saveToBinaryFile("books.dat");

        // Könyvek betöltése bináris fájlból
        catalog.loadFromBinaryFile("books.dat");

        // Könyvek listázása
        catalog.getBooks().forEach(book -> System.out.println(book.getItemInfo()));
    }
}