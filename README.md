# Könyv Katalógus Kezelõ Program

Ez a projekt egy könyv katalógust kezelõ alkalmazás, amely lehetõvé teszi könyvek hozzáadását, törlését, keresését és a katalógus mentését különbözõ fájlformátumokba 
(szöveges és bináris fájlok). 

A program az alábbi fõbb funkciókat tartalmazza:

- Könyvek hozzáadása
- Könyvek törlése
- Könyvek keresése cím és szerzõ alapján
- Könyvek listázása
- Könyvek mentése és betöltése szöveges és bináris fájlokból

## Funkcionalitás

### 1. Könyv hozzáadása
A program képes új könyveket hozzáadni a katalógushoz, amely tartalmazza a címét, szerzõit, kiadási évét és árát.

### 2. Könyv törlése
A könyvek törlésére ID alapján van lehetõség. Ha a könyv nem található, a törlés nem történik meg.

### 3. Könyv keresés
A felhasználó kereshet a katalógusban a könyv címére vagy szerzõjére.

### 4. Könyvek mentése és betöltése
A könyveket szöveges vagy bináris fájlokba lehet menteni és betölteni.

## Telepítés és Futatás

Clone-olni kell a repót GitHub-ról:

   git clone https://github.com/username/repository-name.git

Projekt beállítása: A projekt használatához elõször telepíteni kell a szükséges adatbázist, és létre kell hozni a projektfeladat nevû adatbázist. 
Az adatbázisnak a következõ táblát kell tartalmaznia:


CREATE TABLE konyvek (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cim VARCHAR(255),
    szerzo VARCHAR(255),
    kiadasi_ev INT,
    ar DOUBLE
);
Futtatás: Miután letöltötted és beállítottad a projektet, futtathatod a Main osztályt, hogy interakcióba lépj a könyv katalógussal.

Tesztelés: A projekt tartalmazza a tesztelést, amely a JUnit segítségével futtatható.

Használati Példák
Könyv hozzáadása
A program automatikusan hozzáad egy könyvet a katalógushoz, amikor elindítod.

Könyv keresés
A katalógusban könyvet kereshetsz a következõ módon:

catalog.searchBooks("Java");


Könyv törlés
A törlés a könyv ID-jának megadásával történik:

catalog.removeBookById(1);


Könyvek mentése szöveges fájlba
A könyvek szöveges fájlba mentéséhez használd a következõ kódot:

catalog.saveToTextFile("konyvek.txt");


Könyvek betöltése szöveges fájlból
A könyvek betöltéséhez a következõ kódot használhatod:

catalog.loadFromTextFile("konyvek.txt");


Könyvek mentése bináris fájlba
A könyvek bináris fájlba mentéséhez:

catalog.saveToBinaryFile("konyvek.dat");


Könyvek betöltése bináris fájlból
A könyvek betöltéséhez bináris fájlból:

catalog.loadFromBinaryFile("konyvek.dat");