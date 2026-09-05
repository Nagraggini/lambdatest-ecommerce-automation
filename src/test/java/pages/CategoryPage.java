package pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage{
	
	private final By descriptionParagraph=By.xpath("//div[@class='description']/p");
	
	private final By inventoryItemCards=By.cssSelector("[class='product-thumb']");
	
	private final By productTitles=By.xpath("//div[@class='product-thumb']//h4[@class='title']//a");
	
	private final By shopByCategoryButton=
			By.xpath("//div[@data-id='217833']//a[@aria-label='Shop by Category']");
	
	private final By componentsButton=
			By.xpath("//span[normalize-space()='Components']");
	
	private final By camerasButton=
			By.xpath("//span[normalize-space()='Cameras']");
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
		// TODO Ez nem annyira jó.
		waitUntilTextToBe(descriptionParagraph, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Semper auctor neque vitae tempus quam pellentesque. Facilisis leo vel fringilla est ullamcorper. Tellus id interdum velit laoreet id donec ultrices tincidunt. Vitae nunc sed velit dignissim sodales. Mi proin sed libero enim sed. Mi quis hendrerit dolor magna eget est lorem ipsum.");
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
	
	public CategoryPage clickShopByCategoryButton() {
		click(shopByCategoryButton);
		return this;
	}
	
	public CategoryPage clickComponentsButton() {
		click(componentsButton);
		return this;
	}
	
	public CategoryPage clickCamerasButton() {
		click(camerasButton);
		return this;
	}
}
