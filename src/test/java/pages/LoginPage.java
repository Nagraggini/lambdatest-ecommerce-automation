package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	private final By registrationButton=By.xpath("//a[normalize-space()='Register']");
	private final By continueButton=By.xpath("//a[text()='Continue']");
	
	private final By newCustomerLabel=By.xpath("//h2[normalize-space()='New Customer']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
		wait.until(ExpectedConditions.textToBe(newCustomerLabel, "New Customer"));
	}

	public HomePage clickRegistrationButton() {
		click(registrationButton);
		return new HomePage(driver);
	}
	
	public RegistrationPage clickContinueButton() {
		click(continueButton);
		return new RegistrationPage(driver);
	}
}
