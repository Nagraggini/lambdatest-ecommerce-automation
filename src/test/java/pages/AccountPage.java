package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

	private final By successfulLabel=By.cssSelector("[class='page-title my-3']");
	//private final By myAccountLabel=By.cssSelector("#content h2");
	private final By logoutLink=By.linkText("Logout");
	
	
	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás waitUntilTextToBe(.. , ..)
	}
	
	//Your Account Has Been Created!
	public String getSuccessfulAccountCreatedMessage() {
		return getText(successfulLabel);
	}
	
	public boolean waitUntilLogoutLinkIsVisible() {
		return	isDisplayed(logoutLink);		 
	}

	public HomePage clickLogout() {
		click(logoutLink);
		return new HomePage(driver);
	}
	
	/*public String getMyAccountMessage() {
		return getText(myAccountLabel);
	} */
}
