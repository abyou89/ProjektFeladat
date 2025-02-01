package hu.younes;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private List<Book> books;

    public BookCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Könyv hozzáadva: " + book.getItemInfo());
    }

    public boolean removeBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Könyv kitörölve: " + book.getItemInfo());
                return true;
            }
        }
        System.out.println("Könyv " + id + " Nem található");
        return false;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Nincs könyv a katalógusban.");
        } else {
            System.out.println("Könyvek a katalógusban: ");
            for (Book book : books) {
                System.out.println(book.getItemInfo());
            }
        }
    }

    public void searchBooks(String keyword) {
        boolean found = false;
        System.out.println("Keresési eredmények: " + keyword);
        for (Book book : books) {
            if (book.matches(keyword)) {
                System.out.println(book.getItemInfo());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nem található könyv " + keyword);
        }
    }
}
