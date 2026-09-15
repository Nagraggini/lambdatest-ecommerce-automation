package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	private final By myAccountButton=By.xpath("//a[@data-toggle='dropdown']//span[normalize-space()='My account'] ");
	
	private final By registrationButton=By.xpath("//span[normalize-space()='Register']");
	
	private final By phoneTabletIpodCategoryButton=
			By.xpath("//span[normalize-space()='Phone, Tablets & Ipod']");
	
	
	private final By firstIMacProduct=
			By.xpath("(//a[@id='mz-product-listing-image-37218399-0-0'])[1]");
	
	
	private final By HTCTouchHDProduct=
			By.xpath("(//h4[@class='title']/a[normalize-space()='HTC Touch HD'])[1]");
		
	private final By cartButton=
			By.xpath("(//a[@href='#cart-total-drawer'])[2]");			
	
	private final By editCartButton=
			By.xpath("//a[normalize-space()=\"Edit cart\"]");	
	
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
	
	public ProductPage clickHTCTouchHDProduct() {
		click(HTCTouchHDProduct);
		return new ProductPage(driver);
	}
	
	public HomePage clickCart() {
		click(cartButton);
		return this;
	}
		
	public CartPage clickEditCart() {
		click(editCartButton);
		return new CartPage(driver);
	}
	
}
