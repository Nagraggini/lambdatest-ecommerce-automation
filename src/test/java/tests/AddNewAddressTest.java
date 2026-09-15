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
