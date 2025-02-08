package hu.younes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A BookCatalog osztály a könyvek kezelésére szolgál.
 * Lehetővé teszi könyvek hozzáadását, eltávolítását, listázását, valamint keresését.
 * A könyveket szöveges és bináris fájlokba is menthetjük, illetve onnan beolvashatjuk.
 */
public class BookCatalog {
    private List<Book> books;

    /**
     * A konstruktor, amely inicializálja a könyvek listáját.
     * Az új könyvek hozzáadására és kezelésére szolgáló műveletek elvégzésére készen áll.
     */
    public BookCatalog() {
        this.books = new ArrayList<>();
    }

    /**
     * Könyv hozzáadása a katalógushoz.
     *
     * @param book A hozzáadni kívánt könyv.
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Könyv hozzáadva: " + book.getItemInfo());
    }

    /**
     * Könyv eltávolítása azonosító alapján.
     * Ha a könyv megtalálható, akkor törli a katalógusból, és visszaadja a törlés sikerességét.
     *
     * @param id Az eltávolítandó könyv azonosítója.
     * @return Igaz, ha a könyvet sikerült eltávolítani, hamis, ha nem található a könyv.
     */
    public boolean removeBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Könyv kitörölve: " + book.getItemInfo());
                return true;
            }
        }
        System.out.println("Könyv " + id + " nem található");
        return false;
    }

    /**
     * A katalógusban lévő összes könyv kiírása.
     * Ha a katalógus üres, akkor figyelmeztető üzenetet ad.
     */
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

    /**
     * A katalógusban található könyvek keresése a megadott kulcsszó alapján.
     * Ha bármely könyv címe vagy szerzője illeszkedik a keresett kulcsszóhoz, azt kiírja.
     *
     * @param keyword A keresett kulcsszó.
     */
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

    /**
     * Visszaadja a könyvek listáját.
     *
     * @return A könyvek listája.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * A könyvek mentése szöveges fájlba.
     * Minden könyv információját kiírja a fájlba.
     *
     * @param fileName A fájl neve, ahová a könyveket menteni kell.
     */
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

    /**
     * A könyvek betöltése szöveges fájlból.
     * A fájlból minden könyvet beolvas, és a konzolra kiírja.
     *
     * @param fileName A fájl neve, ahonnan a könyveket be kell olvasni.
     */
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

    /**
     * A könyvek mentése bináris fájlba.
     * A könyvek listáját bináris formátumban menti el a megadott fájlba.
     *
     * @param fileName A fájl neve, ahová a könyveket bináris formátumban menteni kell.
     */
    public void saveToBinaryFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
            System.out.println("Könyv elmentve bináris fájlba: " + fileName);
        } catch (IOException e) {
            System.err.println("Hiba bináris fájlba mentés közben: " + e.getMessage());
        }
    }

    /**
     * A könyvek betöltése bináris fájlból.
     * A fájlból betölti a könyveket és beállítja azokat a katalógusba.
     *
     * @param fileName A fájl neve, ahonnan a könyveket be kell tölteni.
     */
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