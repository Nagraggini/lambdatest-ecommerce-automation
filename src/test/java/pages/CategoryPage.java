package pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage{
	
	private final By descriptionParagraph = By.cssSelector(".description p");
	
	private final By inventoryItemCards=By.cssSelector("[class='product-thumb']");
	
	private final By productTitles=By.xpath("//div[@class='product-thumb']//h4[@class='title']//a");
	
	private final By homeButton=
			By.xpath("//span[@class='title' and normalize-space()='Home']");
		
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(descriptionParagraph);
	}

	public List<WebElement> getInventoryItemCards() {
		return findAll(inventoryItemCards);
	}
	
	public List<String> getAllItemName() {		
		List<WebElement> allItemName = findAll(productTitles);

		List<String> onlyAllItemName = new ArrayList<>();
		for (WebElement itemName : allItemName) {
			onlyAllItemName.add(itemName.getText());
		}
		return onlyAllItemName;
	}
	
	public double getPriceofAnItem(String itemName) {
		return Double.parseDouble(getText(By.xpath(
					"//div[@class='product-thumb']//a[normalize-space()='"
					+itemName+
					"']/parent::h4/following::div[@class='price']/span"))
				.substring(1).replace(",", ""));
	}
	
	public LinkedHashMap<String, Double> getAllItemnamesAndTheirPrices() {

		// Megvárjuk, hogy megjelenjenek az árak.
		waitForAllElementsPresent(By.className("price-new"));

		// Lekérjük az összes termék nevét.
		List<WebElement> itemNames = findAll(productTitles);

		// Beszúrási sorrend meg marad a LinkedHashMap-el.
		LinkedHashMap<String, Double> itemsAndPrices = new LinkedHashMap<>();

		for (WebElement itemName : itemNames) {
			itemsAndPrices.put(itemName.getText(), getPriceofAnItem(itemName.getText()));
		}

		return itemsAndPrices;
	}	
	
	public HomePage clickHome() {
		click(homeButton);
		return new HomePage(driver);
	}
	
}
