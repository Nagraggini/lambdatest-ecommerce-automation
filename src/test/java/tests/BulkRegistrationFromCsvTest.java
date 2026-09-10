package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import utils.CsvFileReader;
import utils.TestData;
import utils.UserData;

@Tag("ui")
@Tag("regression")
class BulkRegistrationFromCsvTest extends BaseTest {

	/**
	 * TC08 Ismételt és sorozatos címbevitel adatforrásból

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
	 */
	@Test
	@DisplayName("TC08 Ismételt és sorozatos címbevitel adatforrásból")	
	void bulkRegistrationFromCsvTest() {
	
		ArrayList<UserData> userList=CsvFileReader.readCsvFile("data/users.csv");
		
		for (UserData userData : userList) {
			
			AccountPage account=homePage.clickMyAccount()
				 	 .clickContinue()
				 	 .fillRegistrationForm(userData.firstName(), 
				 			userData.lastName(), 
				 			// Az emailcímnek egyedinek kell lennie. 
				 			testData.getEmail(),
				 			//userData.email(),
				 			userData.telephone(),userData.password())
				 .acceptPrivacyPolicy() 
				 .clickContinue();
			
			// Új teszt emailcím generálása.
			testData=new TestData();
			
			 assertEquals("Your Account Has Been Created!",account.getSuccessfulAccountCreatedMessage());
			 		
			// Kijelentkezés.
			account.clickLogout();	
		}
				
	}


}
