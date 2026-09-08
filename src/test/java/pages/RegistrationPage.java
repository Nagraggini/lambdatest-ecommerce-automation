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
	private final By privacyPolicyLink =
	        By.xpath("//form//a[normalize-space()='Privacy Policy']");
	
	private final By privacyPolicyWindowHeader =
	        By.xpath("//h4[normalize-space()='Privacy Policy']");
	
	
	private final By continueButton = By.xpath("//input[@value='Continue']");
	
	private final By warningYouMustAgreeToThePrivacyPolicyLabel=
			By.cssSelector("[class='alert alert-danger alert-dismissible']");
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás waitUntilTextToBe(.. , ..)
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

	public RegistrationPage clickPrivacyPolicyLink() {
		click(privacyPolicyLink);
		return new RegistrationPage(driver);
	}
	
	// Megjelenő üzenet: Privacy Policy
	public String getPrivacyPolicyHeaderText() {
		return getText(privacyPolicyWindowHeader);
	}
	
	public AccountPage clickContinue() {
		click(continueButton);
		return new AccountPage(driver);
	}
	
	public RegistrationPage clickContinueAndNotGoToAccountPage() {
		click(continueButton);
		return this;
	}
	
	// Megjelenő üzenet: Warning: You must agree to the Privacy Policy!
	public String getwarningYouMustAgreeToThePrivacyPolicyMessage() {
		return getText(warningYouMustAgreeToThePrivacyPolicyLabel);
	}

}
