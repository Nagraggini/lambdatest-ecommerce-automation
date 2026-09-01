package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;

class RegistrationTest extends BaseTest {

	@Test
	@DisplayName("Sikeres regisztráció")
	void successfulRegistrationTest	() {
		  
		 assertEquals("Your Account Has Been Created!",homePage.clickMyAccountButton().clickContinueButton()
				 	 .fillRegistrationForm(testData.getFirstName(), 
						 testData.getLastName(), 
						 testData.getEmail(),
						 testData.getTelephone(),  testData.getPassword())
				 .acceptPrivacyPolicy() 
				 .clickContinue().getSuccessfulAccountCreatedMessage());
		 //https://ecommerce-playground.lambdatest.io/index.php?route=account/success
		
	}

	@Test
	@DisplayName("Sikerestelen regisztráció")
	void unsuccessfulRegistrationTest() {
		  
		 assertEquals("Warning: You must agree to the Privacy Policy!",homePage.clickMyAccountButton().clickContinueButton()
				 	 .fillRegistrationForm(testData.getFirstName(), 
						 testData.getLastName(), 
						 testData.getEmail(),
						 testData.getTelephone(),  testData.getPassword())				
				 .clickContinueAndNotGoToAccountPage()
				 .getwarningYouMustAgreeToThePrivacyPolicyMessage());
		 //https://ecommerce-playground.lambdatest.io/index.php?route=account/success
		
	}
}
