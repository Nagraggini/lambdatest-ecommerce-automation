package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

	private final By successfulLabel = By.cssSelector("[class='page-title my-3']");
	private final By content=By.id("content");
	
	private final By addressBookButton = By.xpath("//a[normalize-space()='Address Book']");

	private final By logoutLink = By.linkText("Logout");

	public AccountPage(WebDriver driver) {
		super(driver);
		// Oldalszíntű várakoztatás.
		waitUntilVisible(content);
	}

	// Megjelenő üzenet: Your Account Has Been Created!
	public String getSuccessfulAccountCreatedMessage() {
		return getText(successfulLabel);
	}

	public boolean waitUntilLogoutLinkIsVisible() {
		return isDisplayed(logoutLink);
	}

	public AddressBookPage clickAddressBookButton() {
		click(addressBookButton);
		return new AddressBookPage(driver);
	}

	
	public HomePage clickLogout() {
		click(logoutLink);
		return new HomePage(driver);
	}

}
