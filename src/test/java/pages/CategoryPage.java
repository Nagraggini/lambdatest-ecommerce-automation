package pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage{
	
	private final By tabletsLabel=By.cssSelector("[class='h4']");
	
	private final By inventoryItemCards=By.cssSelector("[class='product-thumb']");
	
	private final By productTitles=By.cssSelector("//div[@class='product-thumb']//h4[@class='title']//a");
	// - //div[@class='product-thumb']//div[@class='price']
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
		waitUntilTextToBe(tabletsLabel, "Tablets");
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
}
