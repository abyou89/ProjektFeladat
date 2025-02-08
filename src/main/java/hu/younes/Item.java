package hu.younes;

/**
 * Az Item osztály egy általános alap osztály a katalógus elemek számára.
 * Minden olyan elem, amely a katalógusban szerepel (például könyv),
 * ezt az osztályt örökli, biztosítva az azonosítót és a címet.
 * Az osztály tartalmazza a közös funkcionalitásokat, mint az elem információinak lekérése,
 * valamint egy egyszerű kulcsszó alapú keresési mechanizmust.
 */
public abstract class Item implements CatalogItem {
    private static int idCounter = 1; // Az automatikusan növekvő azonosítók generálásához
    private int id; // Az elem egyedi azonosítója
    private String title; // Az elem címe

    /**
     * Konstruktor, amely beállítja az elem címét és automatikusan generál egy egyedi azonosítót.
     *
     * @param title Az elem címe, amelyet beállítunk.
     */
    public Item(String title) {
        this.id = idCounter++; // Az új elem azonosítóját beállítjuk, és növeljük a számlálót
        this.title = title; // Az elem címének beállítása
    }

    /**
     * Visszaadja az elem azonosítóját.
     *
     * @return Az elem egyedi azonosítója.
     */
    public int getId() {
        return id;
    }

    /**
     * Beállítja az elem azonosítóját.
     *
     * @param id Az új azonosító, amelyet beállítunk.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Visszaadja az elem címét.
     *
     * @return Az elem címe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Beállítja az elem címét.
     *
     * @param title Az új cím, amelyet beállítunk.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * A metódus ellenőrzi, hogy az elem címe tartalmazza-e a keresett kulcsszót.
     * A keresés nem érzékeny a kis- és nagybetűkre.
     *
     * @param keyword A keresett kulcsszó, amelyet összehasonlítunk az elem címével.
     * @return true, ha a cím tartalmazza a kulcsszót, false, ha nem.
     */
    @Override
    public boolean matches(String keyword) {
        return title != null && title.toLowerCase().contains(keyword.toLowerCase());
    }

    /**
     * Visszaadja az elem részletes információit, amely tartalmazza az azonosítót és címet.
     *
     * @return Az elem információit tartalmazó szöveges leírás.
     */
    @Override
    public String getItemInfo() {
        return "ID: " + id + ", Title: " + title;
    }
}