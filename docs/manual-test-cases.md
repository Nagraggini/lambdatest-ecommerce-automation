# Manuális tesztesetek dokumentációja

## Cél

A dokumentum tartalmazza azokat a manuális teszteseteket,
amelyek alapján az automatizált Selenium tesztek elkészültek.

Az alábbiakban részletesen, a vizsgaremek követelményeihez igazítva összegyűjtöttem a lépéseket és a teszteseteket a Practice Software Testing - Toolshop ([https://ecommerce-playground.lambdatest.io/](https://ecommerce-playground.lambdatest.io/)) webalkalmazáshoz, amely minden kötelező funkciót lefed.

## Összefoglaló táblázat

Vizsgakövetelmény									Lefedő teszteset(ek)
Regisztráció										TC01, TC02
Bejelentkezés										TC03, TC04
Adatkezelési nyilatkozat használata					TC01, TC05
Adatok listázása									TC06
Több oldalas lista bejárása							TC07
Új adat bevitel										TC08
Ismételt és sorozatos adatbevitel adatforrásból		TC09
Meglévő adat módosítás								TC10, TC13
Adat vagy adatok törlése							TC11, TC13
Adatok lementése felületről							TC12
Kijelentkezés										TC01, TC03

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

## TC03 Sikeres bejelentkezés ellenőrzése

Teszt rövid leírása: A regisztrált fiókkal való sikeres belépés.

Előfeltétel: Már létező felhasználói adatok.

Teszt lépések:

1. Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
2. My account → Login oldal megnyitása.
3. Érvényes E-Mail Address megadása.
4. Érvényes Password megadása.
5. Login gombra kattintás.

Elvárt eredmény: Megjelenik a My Account oldal. Elérhetők a fiókfunkciók pl.: Logout.

## TC04 Sikertelen bejelentkezés hibás jelszóval

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

## TC05 Adatkezelési nyilatkozat ellenőrzése

Teszt rövid leírása: A Privacy Policy hivatkozás és az adatkezelési nyilatkozat tartalmának ellenőrzése.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
My account → Register kiválasztása.
Kattintás a „Privacy Policy” hivatkozásra.
A megjelenő ablak címének ellenőrzése.

Elvárt eredmény: A Privacy Policy tartalma olvashatóan megjelenik. 

## TC06 Termékek listázásának ellenőrzése

Teszt rövid leírása: A termékek listázásának ellenőrzése egy kiválasztott kategóriában.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A kategóriaválasztó menü megnyitása.
A „Tablets” kategória kiválasztása.
A terméklista betöltődésének megvárása.
A termékkártyák megjelenésének ellenőrzése.
Annak ellenőrzése, hogy minden termékkártyán megjelenik a termék neve és ára.
Annak ellenőrzése, hogy legalább egy termék látható a listában.

Elvárt eredmény: A „Tablets” kategóriaoldal hiba nélkül betöltődik. A terméklista nem üres, és a termékek neve, ára, valamint az „Add to Cart” lehetőség megjelenik.

## TC07 Többoldalas terméklista bejárásának ellenőrzése

Teszt rövid leírása: A több oldalból álló terméklista lapozási funkciójának ellenőrzése.

Előfeltétel: A kiválasztott kategória több oldalnyi terméket tartalmaz.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A „Tablets” kategória megnyitása.
A lapozó és az oldalak számát tartalmazó összesítő szöveg ellenőrzése.
A második oldal megnyitása a „2” gombra kattintva.
Annak ellenőrzése, hogy a második oldal aktívvá vált.
Annak ellenőrzése, hogy a terméklista frissült.
Továbblépés a következő oldalra a „>” gomb segítségével.
Az utolsó oldal megnyitása a „>|” gomb segítségével.
Az utolsó oldal terméklistájának ellenőrzése.

Elvárt eredmény: Minden kiválasztott oldal megfelelően betöltődik. Az aktív oldalszám és az URL lapozási paramétere megváltozik. Minden megnyitott oldalon termékek jelennek meg, és az utolsó oldalról nem lehet továbblépni.

## TC08 Új cím hozzáadásának ellenőrzése

Teszt rövid leírása: Új cím sikeres hozzáadása a felhasználó címjegyzékéhez.

Előfeltétel: A felhasználó be van jelentkezve.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Bejelentkezés érvényes felhasználói adatokkal.
My Account → Address Book megnyitása.
Kattintás a „New Address” gombra.
A First Name és Last Name mezők kitöltése.
A Company mező kitöltése, amennyiben szükséges.
Az Address 1, City és Post Code mezők kitöltése.
A Country és Region/State értékek kiválasztása.
A „Default Address” beállításnál a „No” lehetőség kiválasztása.
Kattintás a „Continue” gombra.

Elvárt eredmény: Az új cím sikeresen létrejön. Az oldalon sikeres mentésről szóló üzenet jelenik meg, és az új cím látható az Address Book Entries listában.

## TC09 Ismételt és sorozatos címbevitel adatforrásból

Teszt rövid leírása: Több cím egymás utáni rögzítése külső CSV-adatforrásból beolvasott adatok alapján.

Előfeltétel:

A felhasználó be van jelentkezve.
A data/addresses.csv fájl legalább három érvényes, egymástól eltérő címet tartalmaz.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Bejelentkezés érvényes felhasználói adatokkal.
A címadatok beolvasása a data/addresses.csv fájlból.
Annak ellenőrzése, hogy az adatforrás nem üres.
My Account → Address Book megnyitása.
Kattintás a „New Address” gombra.
A címűrlap kitöltése az aktuális CSV-adatsor értékeivel:
First Name
Last Name
Company
Address 1
City
Post Code
Country
Region/State
Kattintás a „Continue” gombra.
A sikeres mentésről szóló üzenet ellenőrzése.
Annak ellenőrzése, hogy a létrehozott cím megjelent az Address Book Entries listában.
A folyamat megismétlése a CSV-fájl összes adatsorával.

Elvárt eredmény: A rendszer a CSV-fájlban szereplő összes címet sikeresen rögzíti. Minden adatforrásbeli sorhoz pontosan egy cím jön létre, és a felületen megjelenő adatok megegyeznek a CSV-fájl adataival.

## TC10 Meglévő cím módosításának ellenőrzése

Teszt rövid leírása: Egy korábban létrehozott cím adatainak módosítása.

Előfeltétel:

A felhasználó be van jelentkezve.
Legalább egy módosítható tesztcím szerepel a címjegyzékben.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Bejelentkezés érvényes felhasználói adatokkal.
My Account → Address Book megnyitása.
A módosítandó tesztcím megkeresése.
Kattintás a címhez tartozó „Edit” gombra.
A City mező értékének módosítása.
A Post Code mező értékének módosítása.
Kattintás a „Continue” gombra.
A módosított cím megkeresése az Address Book Entries listában.

Elvárt eredmény: A cím módosítása sikeres. Az oldalon sikeres mentésről szóló üzenet jelenik meg. A címjegyzékben már az új City és Post Code értékek láthatók, a korábbi értékek pedig nem jelennek meg.

## TC11 Meglévő cím törlésének ellenőrzése

Teszt rövid leírása: Egy korábban létrehozott cím törlése a felhasználó címjegyzékéből.

Előfeltétel:

A felhasználó be van jelentkezve.
A címjegyzék legalább két címet tartalmaz.
A törlendő cím nem az egyetlen alapértelmezett cím.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
Bejelentkezés érvényes felhasználói adatokkal.
My Account → Address Book megnyitása.
A törlendő tesztcím megkeresése.
A törlendő cím adatainak eltárolása az ellenőrzéshez.
Kattintás a címhez tartozó „Delete” gombra.
A sikeres törlésről szóló üzenet ellenőrzése.
A címjegyzék ismételt ellenőrzése.

Elvárt eredmény: A kiválasztott cím sikeresen törlődik. A törölt cím már nem jelenik meg az Address Book Entries listában, a többi cím pedig változatlanul megmarad.

## TC12 Termékadatok lementésének ellenőrzése

Teszt rövid leírása: A terméklista adatainak összegyűjtése a felületről és CSV-fájlba történő mentése.

Előfeltétel:

A „Tablets” kategória elérhető.
A kimeneti mappa írható.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A „Tablets” kategória megnyitása.
A terméklista betöltődésének megvárása.
Az aktuális oldalon látható terméknevek összegyűjtése.
A termékekhez tartozó árak összegyűjtése.
A terméknevek és árak mentése az output/products.csv fájlba.
A létrehozott CSV-fájl visszaolvasása.
A fájl fejlécének ellenőrzése.
A mentett adatsorok számának összehasonlítása a felületről összegyűjtött termékek számával.
Az első és az utolsó mentett termék adatainak összehasonlítása a felületen megjelenő adatokkal.

Elvárt eredmény: Az output/products.csv fájl sikeresen létrejön. A fájl tartalmazza a name és price fejlécet. Az adatsorok száma megegyezik a felületről összegyűjtött termékek számával, és a mentett terméknevek és árak helyesek.

## TC13 Kosárban lévő termék módosításának és törlésének ellenőrzése

Teszt rövid leírása: Egy termék kosárba helyezése, mennyiségének módosítása, majd a termék törlése.

Előfeltétel: A kiválasztott termék elérhető és kosárba helyezhető.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A „Tablets” kategória megnyitása.
Egy elérhető termék kiválasztása.
Kattintás az „Add to Cart” gombra.
A kosár megnyitása.
Kattintás az „Edit Cart” lehetőségre.
Annak ellenőrzése, hogy a kiválasztott termék megjelent a kosárban.
A termék kezdeti mennyiségének ellenőrzése.
A Quantity mező értékének módosítása 2 értékre.
Kattintás az „Update” gombra.
A mennyiség és a részösszeg frissülésének ellenőrzése.
Kattintás a termékhez tartozó „Remove” gombra.
A kosár tartalmának ellenőrzése.

Elvárt eredmény: A termék sikeresen bekerül a kosárba. A mennyiség módosítása után a kosárban 2 darab jelenik meg, és a részösszeg megfelelően frissül. A törlés után a termék eltűnik, és a kosár üres állapotot jelez.



