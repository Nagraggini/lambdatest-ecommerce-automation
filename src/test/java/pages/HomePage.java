package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	private final By myAccountButton=By.xpath("//span[normalize-space()='My account']");
	private final By dummyWebsiteLabel=By.xpath("//strong[contains(text(), 'dummy')]");

	public HomePage(WebDriver driver) {
		super(driver);
	
		/*wait.until(ExpectedConditions.textToBe
				(dummyWebsiteLabel, "This is a dummy website for Web Automation Testing"));*/
	}
	
	/**
	 * Megnyitja a weboldalt és validálja is.
	 */
	public HomePage open() {
		driver.get("https://ecommerce-playground.lambdatest.io/");
		// Validáljuk, hogy betöltött-e az oldal. Oldal szintű várakoztatás.

		System.out.println("HomePage open() metódus: ");
		System.out.println("Aktuális URL: " + driver.getCurrentUrl());
		System.out.println("Oldal címe: " + driver.getTitle());
		System.out.println("HTML hossza: " + driver.getPageSource().length());

		return this;
	}

	public HomePage clickMyAccountButton() {
		click(myAccountButton);
		return new HomePage(driver);
	}
	
	
}
