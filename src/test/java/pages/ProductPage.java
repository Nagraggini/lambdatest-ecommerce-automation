package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
	
	private final By quatityInput=
			By.xpath("(//input[@name=\"quantity\"])[2]");

	private final By buyNowButton=
			By.xpath("//button[@title='Buy now']");	
	
	private final By addToCartButton=
			By.xpath("(//button[@title='Add to Cart'])[2]");
	
	private final By viewCartButton=
			By.xpath("//a[normalize-space='View Cart']");
	
	private final By homeButton=
			By.xpath("//span[@class='title' and normalize-space()='Home']");
	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
	}
	
	public ProductPage setQuatity(String pc) {
		clearAndType(quatityInput,pc);
		return this;
	}
	
	public CheckoutPage clickBuyNow() {
		click(buyNowButton);
		return new CheckoutPage(driver);
	}	
	
	public ProductPage clickAddToCart() {
		click(addToCartButton);
		return new ProductPage(driver);
	}
	
	/**
	 * Csak néhány másodpercre jelenik meg a felugró ablak.
	 * @return
	 */
	public CartPage clickViewCart() {
		click(viewCartButton);
		return new CartPage(driver);
	}
	
	public HomePage clickHome() {
		click(homeButton);
		return new HomePage(driver);
	}
}
