package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import utils.AddressData;

@Tag("ui")
@Tag("regression")
class FullPurchaseWorkflowTest extends BaseTest  {

	/**
	 * TC06 Egy vásárlási folyamat e2e tesztje
	 */
	@Test
	@DisplayName("TC06 Egy vásárlási folyamat e2e tesztje")
	void fullPurchaseWorkflowE2ETest() {
		
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
			.save().clickHome().clickFirstIMacProduct().clickBuyNow()
			.clickInputPaymentAddressExisting().clickAgreeTermsAndConditionsCheckbox()
		.clickContinue().clickConfirmOrder();
		
		assertEquals("Your order has been placed!",addressBookPage.getSuccessMessage()
				,"Nem sikerült leadni a rendelést.");
	
		// Kijelentkezés
		addressBookPage.clickContinueAfterOrder().clickMyAccount()
		.clickLogout();
	}
}
