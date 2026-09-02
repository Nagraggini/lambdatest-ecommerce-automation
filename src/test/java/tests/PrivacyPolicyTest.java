package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.RegistrationPage;

@Tag("ui")
@Tag("regression")
class PrivacyPolicyTest extends BaseTest  {

	/**
	 * TC05 Adatkezelési nyilatkozat ellenőrzése
	 */
	@Test
	@DisplayName("TC05 Adatkezelési nyilatkozat ellenőrzése")	
	void successfulRegistrationTest	() {
		RegistrationPage registrationPage=homePage.clickMyAccountButton()
			 	 .clickContinueButton().clickPrivacyPolicyLink();		
		
		 assertEquals("Privacy Policy",registrationPage.getPrivacyPolicyHeaderText());		 					
	}	
}
