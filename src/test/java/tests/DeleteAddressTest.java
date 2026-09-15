package tests;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import utils.AddressData;

@Tag("ui")
@Tag("regression")
class DeleteAddressTest extends BaseTest {

	/**
	 * TC10 Meglévő cím törlésének ellenőrzése
	 */
	@Test
	@DisplayName("TC10 Meglévő cím törlésének ellenőrzése")
	void deleteAddressTest() {

		AddressData address1 = new AddressData(
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
				.fillWithOutRegion(address1)
				.save()
				// Második cím felvétele.
				.clickNewAddress()
				.fillWithOutRegion(address2)
				.save()
				// Második cím törlése.
				.clickDeleteSpecificAddress(address2.firstName() + " " + address2.lastName());

		assertEquals("Your address has been successfully deleted", addressBookPage.getSuccessMessage());

		// A megmaradt címek beolvasása az oldalról.
		List<AddressData> remainingAddresses = addressBookPage.getAllAddress();

		// Ellenőrzések (assertAll)
		assertAll("Address Book adatainak ellenőrzése a törlés után.",
				// A lista mérete pontosan 1 kell legyen.
				() -> assertEquals(1, remainingAddresses.size(),
						"A címjegyzékben pontosan 1 címnek kell maradnia."),

				// Az első (megmaradt) cím adatainak ellenőrzése.
				() -> assertEquals(address1.firstName(), remainingAddresses.get(0).firstName()),
				() -> assertEquals(address1.lastName(), remainingAddresses.get(0).lastName()),
				() -> assertEquals(address1.company(), remainingAddresses.get(0).company()),
				() -> assertEquals(address1.address(), remainingAddresses.get(0).address()),

				// Ellenőrizzük, hogy a törölt cím (address2)
				// vezetékneve/keresztneve NEM szerepel egyik megmaradt elemben sem.
				() -> assertTrue(
						remainingAddresses.stream().noneMatch(a -> a.address().equals(address2.address())),
						"A törölt cím Address 1 része még mindig szerepel az oldalon!"));

		// Kijelentkezés
		addressBookPage.clickMyAccount()
				.clickLogout();
	}

}
