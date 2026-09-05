package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	
	private final By continueButton=By.xpath("//a[text()='Continue']");
	
	private final By newCustomerLabel=By.xpath("//h2[normalize-space()='New Customer']");
	
	private final By emailInput=By.id("input-email");
	private final By passwordInput=By.id("input-password");
	private final By loginButton=By.cssSelector("input[value='Login']");
	
	private final By warningLabel=
			By.cssSelector("[class='alert alert-danger alert-dismissible']");
	
	private final By logoutLink = By.linkText("Logout");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
		waitUntilTextToBe(newCustomerLabel, "New Customer");
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
