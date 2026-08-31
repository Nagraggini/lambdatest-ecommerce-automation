package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{

	private final By firstNameField = By.id("input-firstname");
	private final By lastNameField = By.id("input-lastname");
	private final By emailField = By.id("input-email");
	private final By telephoneField = By.id("input-telephone");
	private final By passwordField = By.id("input-password");
	private final By confirmPasswordField = By.id("input-confirm");
	private final By privacyPolicyCheckbox = By.xpath("//label[@for='input-agree']");
	private final By continueButton = By.xpath("//input[@value='Continue']");

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
	}

	public RegistrationPage fillRegistrationForm(String firstName, String lastName, String email, String phone, String password) {
		type(firstNameField, firstName);
		type(lastNameField, lastName);
		type(emailField, email);
		type(telephoneField, phone);
		type(passwordField, password);
		type(confirmPasswordField, password);
		return this;
	}

	public RegistrationPage acceptPrivacyPolicy() {
		click(privacyPolicyCheckbox);
		return this;
	}

	public AccountPage clickContinue() {
		click(continueButton);
		return new AccountPage(driver);
	}

}
