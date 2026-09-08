package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

	private final By inputPaymentAddressExisting = 
			By.xpath("//label[@for='input-payment-address-existing']");
	
	private final By agreeTermsAndConditionsCheckbox = By.xpath("//label[@for='input-agree']");
	private final By continueButton = By.id("button-save");

	private final By confirmOrderButton = By.id("button-confirm");
	
	private final By successfulMessage = By.xpath("//h1[@class='page-title my-3']");

	private final By continueAfterOrderButton = By.xpath("//a[normalize-space()='Continue']");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
	}

	// A Billing Address rész, csak akkor jelenik meg, ha a profilban nem szerepel
	// egy sem.
	
	
	public CheckoutPage clickInputPaymentAddressExisting() {
		click(inputPaymentAddressExisting);
		return this;
	}
	
	public CheckoutPage clickAgreeTermsAndConditionsCheckbox() {
		click(agreeTermsAndConditionsCheckbox);
		return this;
	}

	public CheckoutPage clickContinue() {
		click(continueButton);
		return this;
	}
	
	public CheckoutPage clickConfirmOrder() {
		click(confirmOrderButton);
		return this;
	}
	
	// Megjelenő üzenet: Your order has been placed!
	public String getSuccessMessage() {
		return getText(successfulMessage);
	}
	
	public HomePage clickContinueAfterOrder() {
		click(continueAfterOrderButton);
		return new HomePage(driver);
	}
}
