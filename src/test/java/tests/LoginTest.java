package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import utils.ConfigReader;

@Tag("ui")
@Tag("regression")
class LoginTest extends BaseTest{

	/**
	 * TC03 Bejelentkezés.
	 */
	@Test
	@DisplayName("TC03 - Sikeres bejelentkezés ellenőrzése.")
	void loginTest() {
		AccountPage account=homePage.clickMyAccountButton()
				.fillEmailAndPasswordFields(ConfigReader.getEmail(), ConfigReader.getPassword())
				.clickLoginButton();
		
		assertTrue(account.waitUntilLogoutLinkIsVisible());
		
		// Kijelentkezés.
		account.clickLogout();		
		
	}

}
