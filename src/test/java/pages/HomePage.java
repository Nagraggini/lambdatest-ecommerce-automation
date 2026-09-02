package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	private final By myAccountButton=By.xpath("//a[@data-toggle='dropdown']//span[normalize-space()='My account'] ");
	private final By loginButton=By.xpath("//span[normalize-space()='Login']");
	private final By registrationButton=By.xpath("//span[normalize-space()='Register']");
	private final By dummyWebsiteLabel=By.xpath("//strong[contains(text(), 'dummy')]");
	
	private final By toptrendingcategoriesLabel=By.xpath("//h3[normalize-space()='Top Trending Categories']");

	// Top Trending Categories
	private final By tabletCategoryButton=By.xpath("//div//h4[normalize-space()='Tablets']");
	
	public HomePage(WebDriver driver) {
		super(driver);		
		
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

	public LoginPage clickMyAccountButton() {
		click(myAccountButton);
		return new LoginPage(driver);
	}
	
		
	public RegistrationPage clickRegistrationButton() {
		click(registrationButton);
		return new RegistrationPage(driver);
	}
	
	public CategoryPage clickTabletCategoryButton() {
		click(tabletCategoryButton);
		return new CategoryPage(driver);
	}
	
	
	
}
