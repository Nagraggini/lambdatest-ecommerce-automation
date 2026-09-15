package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private final By continueButton = By.xpath("//a[text()='Continue']");

	// házikó ikon / Account
	private final By accountLabel = By.xpath("//li[@aria-current='page']");

	private final By emailInput = By.id("input-email");
	private final By passwordInput = By.id("input-password");
	private final By loginButton = By.cssSelector("input[value='Login']");

	private final By warningLabel = By.cssSelector("[class='alert alert-danger alert-dismissible']");

	private final By logoutLink = By.linkText("Logout");

	public LoginPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(accountLabel);
	}

	public RegistrationPage clickContinue() {
		click(continueButton);
		return new RegistrationPage(driver);
	}

	public LoginPage fillEmailAndPasswordFields(String email, String password) {
		type(emailInput, email);
		type(passwordInput, password);
		return this;
	}

	public AccountPage clickLoginButton() {
		click(loginButton);
		return new AccountPage(driver);
	}

	public LoginPage clickLoginButtonAndNotGoToAccountPage() {
		click(loginButton);
		return this;
	}

	// Warning: No match for E-Mail Address and/or Password.
	public String getwarningLabelMessage() {
		return getText(warningLabel);
	}

	public HomePage clickLogout() {
		click(logoutLink);
		return new HomePage(driver);
	}
}
