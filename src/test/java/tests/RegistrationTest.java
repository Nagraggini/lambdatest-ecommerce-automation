package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;

@Tag("ui")
@Tag("regression")
class RegistrationTest extends BaseTest {

	/**
	 * TC01 Sikeres regisztráció és bejelentkezés ellenőrzése
	 */
	@Test
	@DisplayName("TC01 Sikeres regisztráció és bejelentkezés ellenőrzése")	
	void successfulRegistrationTest	() {
		AccountPage account=homePage.clickMyAccount()
			 	 .clickContinue()
			 	 .fillRegistrationForm(testData.getFirstName(), 
					 testData.getLastName(), 
					 testData.getEmail(),
					 testData.getTelephone(),  testData.getPassword())
			 .acceptPrivacyPolicy() 
			 .clickContinue();
		
		 assertEquals("Your Account Has Been Created!",account.getSuccessfulAccountCreatedMessage());
		 		
		// Kijelentkezés.
		account.clickLogout();			
	}

	/**
	 * TC02 Sikertelen regisztráció ellenőrzése
	 */
	@Test
	@DisplayName("TC02 Sikertelen regisztráció ellenőrzése")
	void unsuccessfulRegistrationTest() {		  
		 assertEquals("Warning: You must agree to the Privacy Policy!",homePage.clickMyAccount()
				 	 .clickContinue()
				 	 .fillRegistrationForm(testData.getFirstName(), 
						 testData.getLastName(), 
						 testData.getEmail(),
						 testData.getTelephone(),  testData.getPassword())				
				 .clickContinueAndNotGoToAccountPage()
				 .getwarningYouMustAgreeToThePrivacyPolicyMessage());			
	}
}
