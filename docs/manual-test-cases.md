# Manuális tesztesetek dokumentációja

## Cél

A dokumentum tartalmazza azokat a manuális teszteseteket,
amelyek alapján az automatizált Selenium tesztek elkészültek.

Az alábbiakban részletesen, a vizsgaremek követelményeihez igazítva összegyűjtöttem a lépéseket és a teszteseteket a Practice Software Testing - Toolshop ([https://ecommerce-playground.lambdatest.io/](https://ecommerce-playground.lambdatest.io/)) webalkalmazáshoz, amely minden kötelező funkciót lefed.

## Összefoglaló táblázat

Vizsgakövetelmény									Lefedő teszteset(ek)
Regisztráció										TC01, TC02
Bejelentkezés										TC03, 
Adatkezelési nyilatkozat használata					TC01, TC04
Adatok listázása									TC05
Több oldalas lista bejárása							TC06
Új adat bevitel										TC07
Ismételt és sorozatos adatbevitel adatforrásból		TC08
Meglévő adat módosítás								TC09
Adat vagy adatok törlése							TC10
Adatok lementése felületről							TC11
Kijelentkezés										TC01

TODO!!! külön excel kell és ide,csak képet csatolj.

## TC01 Sikeres regisztráció ellenőrzése

Teszt rövid leírása: Új felhasználói fiók sikeres létrehozása.

Előfeltétel: Az email ne szerepeljen az adatbázisban.

Teszt lépések:

1. Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
2. My account → Register kiválasztása.
3. First Name, Last Name, E-Mail, Telephone, Password és Password Confirm kitöltése érvényes adatokkal.
4. A Newsletter: No marad kiválasztva.
5. „I have read and agree to the Privacy Policy” jelölőnégyzet bejelölése.
6. Continue gombra kattintás.

Elvárt eredmény: A fiók létrejön. Az oldalon megjelenik a sikeres regisztrációs üzenet ("Your Account Has Been Created!”), és a felhasználói fiók elérhető, látszik a "Logout" gomb.

## TC02 Sikertelen regisztráció ellenőrzése

Teszt rövid leírása: Új felhasználói fiók sikertelen létrehozása.

Teszt lépések:

1. Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
2. My account → Register kiválasztása.
3. First Name, Last Name, E-Mail, Telephone, Password és Password Confirm kitöltése érvényes adatokkal.
4. Newsletter: No kiválasztása.
5. „I have read and agree to the Privacy Policy” jelölőnégyzet üresen hagyása.
6. Continue gombra kattintás.

Elvárt eredmény: Sikertelen a regisztráció és az oldal tetején megjelenik megjelenik egy hibaüzenet: 
"Warning: You must agree to the Privacy Policy!"

## TC03 Sikertelen bejelentkezés hibás jelszóval

Teszt rövid leírása: Bejelentkezési kísérlet érvényes e-mail-címmel, de hibás jelszóval.

Előfeltétel: Már létező felhasználói fiók.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
My account → Login oldal megnyitása.
Érvényes E-Mail Address megadása.
Hibás Password megadása.
Login gombra kattintás.

Elvárt eredmény: A bejelentkezés sikertelen. Az oldal tetején megjelenik a következő hibaüzenet:

„Warning: No match for E-Mail Address and/or Password.”

A My Account oldal védett funkciói nem érhetők el.

## TC04 Adatkezelési nyilatkozat ellenőrzése

Teszt rövid leírása: A Privacy Policy hivatkozás és az adatkezelési nyilatkozat tartalmának ellenőrzése.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
My account → Register kiválasztása.
Kattintás a „Privacy Policy” hivatkozásra.
A megjelenő ablak címének ellenőrzése.

Elvárt eredmény: A Privacy Policy tartalma olvashatóan megjelenik. 

## TC05 Terméklista+validáció ellenőrzés 

Teszt rövid leírása: A termékek listázásának ellenőrzése egy kiválasztott kategóriában.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A kategóriaválasztó menü megnyitása.
A „Phone, Tablets & Ipod” kategória kiválasztása.
A terméklista betöltődésének megvárása.
A termékkártyák megjelenésének ellenőrzése.
Annak ellenőrzése, hogy minden terméknek van ára.
Annak ellenőrzése, hogy mind a 15 db termék látható a listában.
Utána a fentieket további két kategórián is ellenőrizzük "Components" és "Cameras".

Elvárt eredmény: A "Components", "Cameras" , "Phone, Tablets & Ipod",  kategóriaoldal hiba nélkül betöltődik.
 A terméklisták nem üresek, és a termékek neve, és az áraik megjelennek.

## TC06 Egy vásárlási folyamat e2e tesztje

Teszt rövid leírása: Egy teljes vásárlási folyamat. 

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Regisztráljunk az oldalra, majd jelentkezzünk be. 
Válasszuk ki az "iMac" terméket. Ezután megjelenik a termék oldala.
A "BUY NOW" gombra kattintás.


Elvárt eredmény: Minden kiválasztott oldal megfelelően betöltődik. Az aktív oldalszám és az URL lapozási paramétere megváltozik. Minden megnyitott oldalon termékek jelennek meg, és az utolsó oldalról nem lehet továbblépni.

## TC07 Új cím hozzáadásának ellenőrzése

Teszt rövid leírása: Új cím sikeres hozzáadása a felhasználó címjegyzékéhez.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Regisztráció érvényes felhasználói adatokkal.
My Account → Address Book megnyitása.
Kattintás a „New Address” gombra.
A First Name és Last Name mezők kitöltése.
A Company mező kitöltése, amennyiben szükséges.
Az Address 1, City és Post Code mezők kitöltése.
A Country és Region/State értékek kiválasztása.
A „Default Address” beállításnál a „No” lehetőség kiválasztása.
Kattintás a „Continue” gombra.

Elvárt eredmény: Az új cím sikeresen létrejön. Az oldalon sikeres mentésről szóló üzenet jelenik meg, és az új cím látható az Address Book Entries listában.

## TC08 Ismételt és sorozatos címbevitel adatforrásból

Teszt rövid leírása: Több felhasználó egymás utáni regisztrációjának ellenőrzése külső CSV-adatforrásból beolvasott adatok alapján.

Előfeltétel:

A data/users.csv fájl legalább három érvényes, egymástól eltérő email címet tartalmaz.
A CSV-fájlban szereplő email címek még nincsenek regisztrálva.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A regisztrációs adatok beolvasása a data/users.csv fájlból.
Annak ellenőrzése, hogy a fájl nem üres.
A „My Account” menü megnyitása.
Kattintás a „Register” gombra.
A regisztrációs űrlap kitöltése az aktuális CSV-adatsor értékeivel:
First Name
Last Name
E-Mail
Telephone
Password
Password Confirm
Az adatvédelmi feltételek elfogadása.
Kattintás a „Continue” gombra.
A sikeres regisztrációról szóló üzenet ellenőrzése.
A regisztrációból való kilépés / kijelentkezés.
A folyamat megismétlése a CSV-fájl összes adatsorával.

Elvárt eredmény: 
A rendszer a CSV-fájlban szereplő összes felhasználót sikeresen regisztrálja. 
Minden adatforrásbeli sorhoz pontosan egy felhasználói fiók jön létre, 
és a regisztráció során megadott adatok megfelelnek a CSV-fájl aktuális sorának.

## TC09 Meglévő cím módosításának ellenőrzése

Teszt rövid leírása: Egy korábban létrehozott cím adatainak módosítása.

Teszt lépések:
Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Regisztráció érvényes felhasználói adatokkal.
My Account → Address Book megnyitása.
A módosítandó tesztcím megkeresése.
Kattintás a címhez tartozó „Edit” gombra.
A First Name mező értékének módosítása.
A Last Name mező értékének módosítása.
Kattintás a „Continue” gombra.
A módosított cím megkeresése az Address Book Entries listában.

Elvárt eredmény: A cím módosítása sikeres. Az oldalon sikeres mentésről szóló üzenet jelenik meg. 
A címjegyzékben már az új First Name és Last Name  értékeik láthatóak, 
a korábbi értékek pedig nem jelennek meg.

## TC10 Meglévő cím törlésének ellenőrzése

Teszt rövid leírása: Egy korábban létrehozott cím törlése a felhasználó címjegyzékéből.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Regisztráció érvényes felhasználói adatokkal.
My Account → Address Book megnyitása.
A törlendő tesztcím megkeresése.
A törlendő cím adatainak eltárolása az ellenőrzéshez.
Kattintás a címhez tartozó „Delete” gombra.
A sikeres törlésről szóló üzenet ellenőrzése.
A címjegyzék ismételt ellenőrzése.

Elvárt eredmény: A kiválasztott cím sikeresen törlődik. A törölt cím már nem jelenik meg az Address Book Entries listában, a többi cím pedig változatlanul megmarad.

## TC11 Kosár tartalmának lementése


