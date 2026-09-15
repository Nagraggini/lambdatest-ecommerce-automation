package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ShoppingCart;

public class CartPage extends BasePage {
	
	final private By allQuantityInputs=By.xpath("//tbody//input");

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO oldal betöltésének validálása validálás
	}

	public double getSpecificProductUnitPrice(String productName) {
		By price = By.xpath("(//table[@class='table table-bordered']//tbody//" + "a[normalize-space()='" 
						+ productName
				+ "'])[1]" + "/following::td[contains(@class, 'text-right')][1]");

		return Double.parseDouble(getText(price).replace("$", ""));
	}

	public ArrayList<ShoppingCart> getShoppingCartProducts() {
		List<WebElement> allQuantityInputsList=findAll(allQuantityInputs);
		int productCount=allQuantityInputsList.size();
				
		ArrayList<ShoppingCart> shoppingCartList = new ArrayList<>();
	
		for (int i=1; i<=productCount;i++) {
			String productName=getText
					(By.xpath("(//table[@class='table table-bordered']//tbody//tr//td[@class='text-left']"
							+ "//a)["+i+"]"));
			// 
			String model=getText(By.xpath("(//table[@class='table table-bordered']//tbody//a[normalize-space()='"
					+productName+
					 "'])[1]/following::td[contains(@class, 'text-left')][1]"));
			
			//(//table[@class='table table-bordered']//tbody//a[normalize-space()='iMac'])[1]/following::td[contains(@class, 'text-left')][2]//input
			
			String quantity=find(By.xpath("(//table[@class='table table-bordered']//tbody//a[normalize-space()='"
					+productName+
					 "'])[1]/following::td[contains(@class, 'text-left')][2]//input")).getAttribute("value");
			
			String unitPrice=String.valueOf(getSpecificProductUnitPrice(productName));
			
			// (//table[@class='table table-bordered']//tbody//a[normalize-space()='iMac'])[1]/following::td[contains(@class, 'text-right')][2]
			
			String total=getText(By.xpath("(//table[@class='table table-bordered']//tbody//a[normalize-space()='"
					+productName+
					 "'])[1]/following::td[contains(@class, 'text-right')][2]")).replace("$", "");
			
			ShoppingCart oneShoppingCartRow=new ShoppingCart(productName,model,quantity,unitPrice,total);
			shoppingCartList.add(oneShoppingCartRow);
		}	

		return shoppingCartList;
	}
}
