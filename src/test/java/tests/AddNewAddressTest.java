package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import utils.AddressData;
import base.BaseTest;

@Tag("ui")
@Tag("regression")
class AddNewAddressTest extends BaseTest{

	/**
	 * TC07 Új cím hozzáadásának ellenőrzése

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

Elvárt eredmény: Az új cím sikeresen létrejön. Az oldalon sikeres mentésről szóló üzenet jelenik meg, 
és az új cím látható az Address Book Entries listában.
	 */
	@Test
	@DisplayName("TC07 Új cím hozzáadásának ellenőrzése")
	void addNewAddressTest() {
		
		AddressData address = new AddressData(
		        "John",
		        "Smith",
		        "Test Company",
		        "Test Street 12",
		        "Budapest",
		        "1234",
		        "97", // Hungary
		        "0" // text="--- None ---"
		);
	var addressBookPage=homePage.clickMyAccount()
			 	 .clickContinue()
			 	 .fillRegistrationForm(testData.getFirstName(), 
					 testData.getLastName(), 
					 testData.getEmail(),
					 testData.getTelephone(),  testData.getPassword())
			 .acceptPrivacyPolicy() 
			 .clickContinue().clickAddressBookButton().clickNewAddress()
			 .fillWithOutRegion(address)
			.save();
	
	assertEquals("Your address has been successfully added",addressBookPage.getSuccessMessage());
	
	String [] fullAddressFromWebsite=addressBookPage.getLastAddress();
	
	assertAll("Address Book adatainak ellenőrzése",
			() -> assertEquals(address.firstName() + " " + address.lastName(), fullAddressFromWebsite[0]),
			() -> assertEquals(address.company(), fullAddressFromWebsite[1]),
			() -> assertEquals(address.address(), fullAddressFromWebsite[2]),
			() -> assertEquals(address.city() + " " + address.postCode(), fullAddressFromWebsite[3]),
			() -> assertEquals("Hungary", fullAddressFromWebsite[4])
		);
		// Kijelentkezés
		addressBookPage.clickMyAccount()
		.clickLogout();
	}

}
