# K�nyv Katal�gus Kezel� Program

Ez a projekt egy k�nyv katal�gust kezel� alkalmaz�s, amely lehet�v� teszi k�nyvek hozz�ad�s�t, t�rl�s�t, keres�s�t �s a katal�gus ment�s�t k�l�nb�z� f�jlform�tumokba 
(sz�veges �s bin�ris f�jlok). 

A program az al�bbi f�bb funkci�kat tartalmazza:

- K�nyvek hozz�ad�sa
- K�nyvek t�rl�se
- K�nyvek keres�se c�m �s szerz� alapj�n
- K�nyvek list�z�sa
- K�nyvek ment�se �s bet�lt�se sz�veges �s bin�ris f�jlokb�l

## Funkcionalit�s

### 1. K�nyv hozz�ad�sa
A program k�pes �j k�nyveket hozz�adni a katal�gushoz, amely tartalmazza a c�m�t, szerz�it, kiad�si �v�t �s �r�t.

### 2. K�nyv t�rl�se
A k�nyvek t�rl�s�re ID alapj�n van lehet�s�g. Ha a k�nyv nem tal�lhat�, a t�rl�s nem t�rt�nik meg.

### 3. K�nyv keres�s
A felhaszn�l� kereshet a katal�gusban a k�nyv c�m�re vagy szerz�j�re.

### 4. K�nyvek ment�se �s bet�lt�se
A k�nyveket sz�veges vagy bin�ris f�jlokba lehet menteni �s bet�lteni.

## Telep�t�s �s Futat�s

Clone-olni kell a rep�t GitHub-r�l:

   git clone https://github.com/username/repository-name.git

Projekt be�ll�t�sa: A projekt haszn�lat�hoz el�sz�r telep�teni kell a sz�ks�ges adatb�zist, �s l�tre kell hozni a projektfeladat nev� adatb�zist. 
Az adatb�zisnak a k�vetkez� t�bl�t kell tartalmaznia:


CREATE TABLE konyvek (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cim VARCHAR(255),
    szerzo VARCHAR(255),
    kiadasi_ev INT,
    ar DOUBLE
);
Futtat�s: Miut�n let�lt�tted �s be�ll�tottad a projektet, futtathatod a Main oszt�lyt, hogy interakci�ba l�pj a k�nyv katal�gussal.

Tesztel�s: A projekt tartalmazza a tesztel�st, amely a JUnit seg�ts�g�vel futtathat�.

Haszn�lati P�ld�k
K�nyv hozz�ad�sa
A program automatikusan hozz�ad egy k�nyvet a katal�gushoz, amikor elind�tod.

K�nyv keres�s
A katal�gusban k�nyvet kereshetsz a k�vetkez� m�don:

catalog.searchBooks("Java");


K�nyv t�rl�s
A t�rl�s a k�nyv ID-j�nak megad�s�val t�rt�nik:

catalog.removeBookById(1);


K�nyvek ment�se sz�veges f�jlba
A k�nyvek sz�veges f�jlba ment�s�hez haszn�ld a k�vetkez� k�dot:

catalog.saveToTextFile("konyvek.txt");


K�nyvek bet�lt�se sz�veges f�jlb�l
A k�nyvek bet�lt�s�hez a k�vetkez� k�dot haszn�lhatod:

catalog.loadFromTextFile("konyvek.txt");


K�nyvek ment�se bin�ris f�jlba
A k�nyvek bin�ris f�jlba ment�s�hez:

catalog.saveToBinaryFile("konyvek.dat");


K�nyvek bet�lt�se bin�ris f�jlb�l
A k�nyvek bet�lt�s�hez bin�ris f�jlb�l:

catalog.loadFromBinaryFile("konyvek.dat");