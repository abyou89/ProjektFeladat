package hu.younes;

/**
 * A CatalogItem interfész a katalógusba tartozó elemek alapvető jellemzőit határozza meg.
 * Minden olyan osztálynak, amely könyveket vagy egyéb elemeket képvisel a katalógusban,
 * implementálnia kell ezt az interfészt.
 */
public interface CatalogItem {

    /**
     * Visszaadja az adott katalógus elem részletes információit, amely tartalmazza az
     * elem azonosítóját és címét.
     *
     * @return Az elem információit tartalmazó szöveges leírás.
     */
    String getItemInfo();

    /**
     * Ellenőrzi, hogy az adott katalógus elem megfelel-e a keresett kulcsszónak.
     * A keresés a cím vagy a szerző alapján történhet, attól függően, hogy az implementáló
     * osztály milyen típusú adatokat tartalmaz.
     *
     * @param keyword A keresett kulcsszó, amelyet az elem címével vagy más jellemzőivel
     *                kell összehasonlítani.
     * @return true, ha az elem címében vagy más jellemzőiben megtalálható a kulcsszó,
     *         false, ha nem.
     */
    boolean matches(String keyword);
}