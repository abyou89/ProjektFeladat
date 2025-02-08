package hu.younes;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Book osztály, amely a könyvek adatainak tárolására és kezelésére szolgál.
 * A könyv címét, szerzőit, kiadási évét és árát tárolja.
 * A Book osztály az Item osztályból öröklődik, amely az alapvető azonosítót és címet tartalmazza.
 */
public class Book extends Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Set<String> authors;
    private int publicationYear;
    private double price;

    /**
     * A konstruktor, amely alapértelmezett értékekkel inicializálja a könyvet.
     * A cím "Ismeretlen cim", a szerzők halmaza üres, a kiadási év 0, és az ár 0.0 Ft.
     */
    public Book() {
        super("Ismeretlen cim");
        this.authors = new HashSet<>();
        this.publicationYear = 0;
        this.price = 0.0;
    }

    /**
     * A konstruktor, amely beállítja a könyv címét, szerzőit, kiadási évét és árát.
     *
     * @param title A könyv címe.
     * @param authors A könyv szerzőinek listája.
     * @param publicationYear A könyv kiadási éve.
     * @param price A könyv ára.
     */
    public Book(String title, Set<String> authors, int publicationYear, double price) {
        super(title);
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    /**
     * Visszaadja a könyv szerzőit.
     *
     * @return A könyv szerzőit tartalmazó Set.
     */
    public Set<String> getAuthors() {
        return authors;
    }

    /**
     * Beállítja a könyv szerzőit.
     *
     * @param authors A könyv szerzőit tartalmazó Set.
     */
    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    /**
     * Visszaadja a könyv kiadási évét.
     *
     * @return A könyv kiadási éve.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Beállítja a könyv kiadási évét.
     *
     * @param publicationYear A könyv kiadási éve.
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Visszaadja a könyv árát.
     *
     * @return A könyv ára.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Beállítja a könyv árát.
     *
     * @param price A könyv ára.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Visszaadja a könyv adatait szöveges formában.
     * A könyv információi a cím, szerzők, kiadási év és ár.
     *
     * @return A könyv adatainak szöveges reprezentációja.
     */
    @Override
    public String getItemInfo() {
        return super.getItemInfo() + ", Szerző: " + authors + ", Év: " + publicationYear + ", Ár: " + price + " Ft";
    }

    /**
     * Ellenőrzi, hogy a könyv megfelel-e a keresési kulcsszónak.
     * A könyv akkor tekinthető egyezőnek, ha a cím vagy a szerzők közül bármi tartalmazza a keresett szót.
     *
     * @param keyword A keresett kulcsszó.
     * @return true, ha a könyv címében vagy szerzőiben megtalálható a keresett szó, egyébként false.
     */
    @Override
    public boolean matches(String keyword) {
        return super.matches(keyword) || authors.stream().anyMatch(author -> author.toLowerCase().contains(keyword.toLowerCase()));
    }
}