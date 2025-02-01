package hu.younes;

import java.io.*;
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


    public List<Book> getBooks() {
        return books;
    }

    // Könyvek mentése szöveges fájlba
    public void saveToTextFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Book book : books) {
                writer.write(book.getItemInfo());
                writer.newLine();
            }
            System.out.println("Könyv elemntve text file-ba " + fileName);
        } catch (IOException e) {
            System.err.println("Hiba a text file-ba mentés közben  " + e.getMessage());
        }
    }

    // Könyvek betöltése szöveges fájlból
    public void loadFromTextFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Beolvasás text fájlból " + line);
                // Itt új Book példányokat is létrehozhatsz, ha szükséges
            }
        } catch (IOException e) {
            System.err.println("Hiba text fájlból olvasás közben " + e.getMessage());
        }
    }

    // Könyvek mentése bináris fájlba
    public void saveToBinaryFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
            System.out.println("Könyv elmentve bináris fájlba: " + fileName);
        } catch (IOException e) {
            System.err.println("Hiba bináris fájlba mentés közben: " + e.getMessage());
        }
    }

    // Könyvek betöltése bináris fájlból
    @SuppressWarnings("unchecked")
    public void loadFromBinaryFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            books = (List<Book>) ois.readObject();
            System.out.println("Könyvek betöltve bináris fájlból " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Hiba bináris fájlból betöltés közben: " + e.getMessage());
        }
    }
}

