package hu.younes;

import java.sql.*;

/**
 * A fő osztály, amely a program működését irányítja.
 * Itt történik az adatbázis kapcsolódás, adatbevitel, adatlekérdezés és adat törlés.
 * A tranzakciók kezelése is itt valósul meg.
 */
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/projektfeladat";
        String username = "root";
        String password = "";

        Connection con = null;
        try {
            // Kapcsolódás az adatbázishoz
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            System.out.println("Kapcsolódás sikeres");

            /**
             * Könyv hozzáadása az adatbázishoz.
             * A metódus egy új könyvet szúr be a `konyvek` táblába.
             *
             * @param stm A PreparedStatement objektum, amely a beszúró SQL lekérdezést tartalmazza.
             * @throws SQLException Hiba léphet fel az adatbázis műveletek végrehajtása során.
             */
            String insSqlQuery = "INSERT INTO `konyvek` (`cim`, `szerzo`, `kiadasi_ev`, `ar`) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stm = con.prepareStatement(insSqlQuery)) {
                stm.setString(1, "Java Programming");
                stm.setString(2, "Author One");
                stm.setInt(3, 2020);
                stm.setDouble(4, 29.99);
                int sorDb = stm.executeUpdate();
                System.out.println(sorDb + " könyv beszúrása megtörtént");
            }

            /**
             * Könyvek lekérdezése az adatbázisból.
             * A metódus kiírja az összes könyv adatait az adatbázisból.
             *
             * @param stm Az SQL lekérdezést végrehajtó Statement objektum.
             * @param eredmeny Az adatbázisból lekért eredmények tárolása.
             * @throws SQLException Hibák jelentkezhetnek az adatbázis műveletek során.
             */
            String selSqlQuery = "SELECT * FROM `konyvek` WHERE 1;";
            try (Statement stm = con.createStatement(); ResultSet eredmeny = stm.executeQuery(selSqlQuery)) {
                System.out.println("Adatok az adatbázisból:");
                while (eredmeny.next()) {
                    int id = eredmeny.getInt("id");
                    String cim = eredmeny.getString("cim");
                    String szerzo = eredmeny.getString("szerzo");
                    int kiadasiEv = eredmeny.getInt("kiadasi_ev");
                    double ar = eredmeny.getDouble("ar");
                    System.out.printf("ID: %d, Cím: %s, Szerző: %s, Év: %d, Ár: %.2f\n", id, cim, szerzo, kiadasiEv, ar);
                }
            }

            /**
             * Könyv törlésének végrehajtása az adatbázisból.
             * A metódus törli a megadott ID-vel rendelkező könyvet a `konyvek` táblából.
             *
             * @param stm A PreparedStatement objektum, amely a törlési SQL lekérdezést tartalmazza.
             * @throws SQLException Hiba történhet a törlés során.
             */
            String delSqlQuery = "DELETE FROM `konyvek` WHERE `id` = ?";
            try (PreparedStatement stm = con.prepareStatement(delSqlQuery)) {
                stm.setInt(1, 1);
                int sorDb = stm.executeUpdate();
                if (sorDb > 0) {
                    System.out.println("Könyv törlésére sikerült: " + 1);
                } else {
                    System.out.println("Könyv nem található.");
                    con.rollback();
                    System.out.println("A tranzakció visszavonva.");
                }
            }

            con.commit();
            System.out.println("Tranzakció sikeres");

        } catch (SQLException e) {
            // Hiba kezelése a tranzakció során
            System.err.println("Hiba történt: " + e.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Tranzakció visszavonva.");
                } catch (SQLException rollbackException) {
                    System.err.println("A tranzakció visszavonása sem sikerült: " + rollbackException.getMessage());
                }
            }
        } finally {
            // Kapcsolat lezárása
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("Hiba a kapcsolat bezárásakor: " + e.getMessage());
                }
            }
        }
    }
}