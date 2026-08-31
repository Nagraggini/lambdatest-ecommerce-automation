package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

	private final By successfulLabel=By.cssSelector("[class='page-title my-3'] ");
	
	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
	}
	
	public String getSuccessfulAccountCreatedMessage() {
		return getText(successfulLabel);
	}

}
