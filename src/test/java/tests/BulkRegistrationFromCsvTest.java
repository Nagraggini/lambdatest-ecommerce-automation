package tests;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	 */
	@Test
	@DisplayName("TC08 Ismételt és sorozatos címbevitel adatforrásból")
	void bulkRegistrationFromCsvTest() {

		ArrayList<UserData> userList = CsvFileReader.readCsvFile("data/users.csv");

		for (UserData userData : userList) {

			AccountPage account = homePage.clickMyAccount()
					.clickContinue()
					.fillRegistrationForm(userData.firstName(),
							userData.lastName(),
							// Az emailcímnek egyedinek kell lennie.
							testData.getEmail(),
							// userData.email(),
							userData.telephone(), userData.password())
					.acceptPrivacyPolicy()
					.clickContinue();

			// Új teszt emailcím generálása.
			testData = new TestData();

			assertEquals("Your Account Has Been Created!", account.getSuccessfulAccountCreatedMessage());

			// Kijelentkezés.
			account.clickLogout();
		}

	}

}
