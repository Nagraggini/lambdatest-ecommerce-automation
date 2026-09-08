package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import utils.AddressData;
import base.BaseTest;

@Tag("ui")
@Tag("regression")
class ModifyAddressTest extends BaseTest{

	/**
	 * TC09 Meglévő cím módosításának ellenőrzése

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
	 */
	@Test
	@DisplayName("TC09 Meglévő cím módosításának ellenőrzése")
	void modifyAddressTest() {
		
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
			.save()
			.clickEditSpecificAddress(address.firstName()+" "+address.lastName())
			.fillFirstName("Crazy")
			.fillLastName("Test")
			.save();
	
	assertEquals("Your address has been successfully updated",addressBookPage.getSuccessMessage());
	
	String [] fullAddressFromWebsite=addressBookPage.getLastAddress();
	
	assertAll("Address Book adatainak ellenőrzése",
			() -> assertEquals("Crazy" + " " + "Test", fullAddressFromWebsite[0]),
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
