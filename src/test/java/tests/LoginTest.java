package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.LoginPage;
import utils.ConfigReader;

@Tag("ui")
@Tag("regression")
class LoginTest extends BaseTest{
	
	/**
	 * TC03 Sikertelen bejelentkezés hibás jelszóval
	 */
	@Test
	@DisplayName("TC04 Sikertelen bejelentkezés hibás jelszóval")
	void unsuccessfulLoginTest() {
		LoginPage loginPage=homePage.clickMyAccountButton()
				.fillEmailAndPasswordFields(ConfigReader.getEmail(), testData.getPassword())
				.clickLoginButtonAndNotGoToAccountPage();
		 
		assertEquals("Warning: No match for E-Mail Address and/or Password."
				,loginPage.getwarningLabelMessage());
	}

}
