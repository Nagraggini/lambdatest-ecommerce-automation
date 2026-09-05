package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.AddressBookPage;
import utils.AddressData;

class FullPurchaseWorkflowTest extends BaseTest  {

	@Test
	void fullPurchaseWorkflowE2ETest() {
		
		AddressData address = new AddressData(
		        "John",
		        "Smith",
		        "Test Company",
		        "Test Street 12",
		        "Budapest",
		        "1234",
		        "Hungary",
		        "--- None ---" //value="0"
		);
	var addressBookPage=homePage.clickMyAccount()
			 	 .clickContinue()
			 	 .fillRegistrationForm(testData.getFirstName(), 
					 testData.getLastName(), 
					 testData.getEmail(),
					 testData.getTelephone(),  testData.getPassword())
			 .acceptPrivacyPolicy() 
			 .clickContinue().clickAddressBookButton().clickNewAddress()
			 .fill(address).save().clickHome().clickFirstIMacProduct().clickBuyNow().clickAgreeTermsAndConditionsCheckbox()
		.clickContinue().clickConfirmOrder();
		
		assertEquals("Your order has been placed!",addressBookPage.getSuccessMessage()
				,"Nem sikerült leadni a rendelést.");
	
		// Kijelentkezés
		addressBookPage.clickContinueAfterOrder().clickMyAccount()
		.clickLogout();
	}
}
