package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.AddressData;
import base.BaseTest;

@Tag("ui")
@Tag("regression")
class DeleteAddressTest extends BaseTest {

	/**
	 * TC10 Meglévő cím törlésének ellenőrzése
	
	 * Teszt rövid leírása: Egy korábban létrehozott cím törlése a felhasználó
	 * címjegyzékéből.
	 * 
	 * Teszt lépések:	
	 * Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.	  
	 * Regisztráció érvényes felhasználói adatokkal.	  
	 * My Account → Address Book megnyitása. 
	 * A törlendő tesztcím megkeresése. 
	 * A törlendő cím adatainak eltárolása az ellenőrzéshez. 
	 * Kattintás a címhez tartozó „Delete” gombra.
	 *  A sikeres törlésről szóló üzenet ellenőrzése. 
	 * A címjegyzék ismételt ellenőrzése. 
	 * 
	 * Elvárt eredmény: A kiválasztott cím sikeresen törlődik. 
	 * A törölt cím már nem jelenik meg az Address Book Entries listában, 
	 * a többi cím pedig változatlanul megmarad. 
	 */

	@Test
	@DisplayName("TC10 Meglévő cím törlésének ellenőrzése")
	void deleteAddressTest() {
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

		AddressData address2 = new AddressData(
				"John2",
				"Smith2",
				"Test Company2",
				"Test Street 122",
				"Budapest",
				"1234",
				"97", // Hungary
				"0" // text="--- None ---"
		);

		var addressBookPage = homePage.clickMyAccount()
				.clickContinue()
				.fillRegistrationForm(testData.getFirstName(),
						testData.getLastName(),
						testData.getEmail(),
						testData.getTelephone(), testData.getPassword())
				.acceptPrivacyPolicy()
				.clickContinue().clickAddressBookButton()
				// Első cím felvétele.
				.clickNewAddress()
				.fillWithOutRegion(address)
				.save()

				// Második cím felvétele.
				.clickNewAddress()
				.fillWithOutRegion(address2)
				.save()

				// Második cím törlése.
				.clickDeleteSpecificAddress(address2.firstName() + " " + address2.lastName());

		assertEquals("Your address has been successfully deleted", addressBookPage.getSuccessMessage());

		String[] fullAddressFromWebsite = addressBookPage.getLastAddress();

		List<AddressData> addressList = addressBookPage.getAllAddress();

		for (AddressData addressData : addressList) {

		}

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
