package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

	private final By buyNowButton=
			By.xpath("//button[@title='Buy now']");	
	
	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
	}
	
	public CheckoutPage clickBuyNow() {
		click(buyNowButton);
		return new CheckoutPage(driver);
	}
	
	
}
