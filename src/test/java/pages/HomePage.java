package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	private final By myAccountButton=By.xpath("//a[@data-toggle='dropdown']//span[normalize-space()='My account'] ");
	//private final By loginButton=By.xpath("//span[normalize-space()='Login']");
	private final By registrationButton=By.xpath("//span[normalize-space()='Register']");
	//private final By dummyWebsiteLabel=By.xpath("//strong[contains(text(), 'dummy')]");
	
	//private final By topTrendingcategoriesLabel=By.xpath("//h3[normalize-space()='Top Trending Categories']");
	
	private final By phoneTabletIpodCategoryButton=
			By.xpath("//span[normalize-space()='Phone, Tablets & Ipod']");
	
	
	private final By firstIMacProduct=
			By.xpath("(//a[@id='mz-product-listing-image-37218399-0-0'])[1]");
	
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

	public LoginPage clickMyAccount() {
		click(myAccountButton);
		return new LoginPage(driver);
	}
	
		
	public RegistrationPage clickRegistration() {
		click(registrationButton);
		return new RegistrationPage(driver);
	}
	
	public CategoryPage openCategory(int categoryId) {
		driver.get("https://ecommerce-playground.lambdatest.io/"+ "index.php?route=product/category&path=" + categoryId);
        return new CategoryPage(driver);
    }
	
	public CategoryPage clickPhoneTabletIpodCategory() {
		click(phoneTabletIpodCategoryButton);
		return new CategoryPage(driver);
	}
	
	
	public ProductPage clickFirstIMacProduct() {
		click(firstIMacProduct);
		return new ProductPage(driver);
	}
	
	
}
