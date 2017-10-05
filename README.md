# Alkalmazások fejlesztése nagybeadandó (2017/18 I. félév):
### Movierent - Internetes filmkölcsönző alkalmazás

#### 1. Feladat szöveges leírása:
> Egy filmtéka alkalmazása, melynek segítségével lehet kölcsönözni filmeket. Az alkalmazás lehetőséget biztosít a téka adatbázisában nem található filmek igénylésére. Emellett az adatbázisban található filmek összehasonlítására és értékelésére is van lehetőség.

#### A kölcsönző működése:
> A kölcsönzésnek egyszeri díja van, melynek mértéke filmenként 500 Ft. Ezután megszűnik a hozzáférés a filmhez (ha a kölcsönzés nem kerül hosszabbításra).  A kölcsönzés lejárata előtt "filmhossza + 30 perc"-cel kap rendszerértesítést a felhasználó a kölcsönzés lejáratáról. A felhasználó jelezheti, hogy mennyi ideig kívánja még meghosszabbítani a kölcsönzést: 1/2/12/24 óra.

#### 2. Funkcionális követelmények:
	- Regisztráció:
        Teljes név, felhasználói név, e-mail és születési dátum megadásával.
	- Bejelentkezés:
        Felhasználói név és jelszó megadásával.
	- Filmek keresése:
        A filmek szűrése azok attribútumjai alapján.
	- Filmek összehasonlítása:
        Két film attribútumjainak megjelenítése egymás mellé két hasábban.
	- Filmek értékelése:
        Számszerű és szöveges értékelés. A szöveges értékelés opcionális, a vélemények attribútum alatt van lehetőség ezek megtekintésére.
	- Kölcsönzés:
        Filmeket kiválasztva lehetséges azok kölcsönzése. A kölcsönzés a fizetés jóváhagyása után sikeres.
	- Kölcsönzés hosszabbítása:
        Lehetőség a kölcsönzött filmek 1/2/12/24 órával történő hosszabbítására.
	- Hiányzó filmek igénylés:
        A film címével, rendezőjével, megjelenési évévének megadásával lehet igényelni új film felvételét a rendszerbe, melyet az adminisztrátor végezhet.

#### 3. Felhasználói történetek:

  - Kölcsönzés:
      A felhasználó filmet (filmeket) kiválasztva jelzi a foglalási kérelmét. Erről kap egy megerősítő e-mailt melyben található link 3 óráig érvényes. Amennyiben érvényesíti a foglalását (kifizeti) akkor megkapja a hozzáférést a filmhez e-mailben.
  - Hosszabbítás:
      A felhasználó a rendeléseim menüpont alatt kiválasztja az adott filmet és a hosszabbítani kívánt időtartamot. Ezután megnyomja az aktiválódott "Hosszabbít" gombot. Ezután fizetnie kell.
  - Fizetés:
      Fizetést kezelő oldalra irányít. A formot ki kell tölteni valid információval, ezután kap egy e-mailt a sikerességéről.
      
#### 4. Jogosultsági körök (lentről felfelé tartalmazás - superuser tudja amit az alatta lévő kettő):
  - Superuser:
      - Felhasználók kezelése
  - Adminsztrátor:
      - Filmek kezelése (CRUD műveletekkel)
      - Vélemények moderálása
  - Felhasználó:
      - Kölcsönzés
      - Hosszabbítás
      - Filmek értékelése
      - Filmek összehasonlítása
      - Filmek keresése
      - Saját kölcsönzések megtekintése
      - Új film igénylése
      
#### 5. Adatbázis-terv:

![alt text](https://github.com/Regulus93/alkfejl-movierent/blob/master/docs/database_plan.png)
