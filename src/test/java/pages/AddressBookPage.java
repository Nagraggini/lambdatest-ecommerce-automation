package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.AddressData;

public class AddressBookPage extends BasePage {
	private final By heading = By.xpath("//h1[normalize-space()='Address Book Entries']");
	private final By newAddress = By.xpath("//a[normalize-space()='New Address']");

	private final By success = By.cssSelector(".alert-success");
	private final By deleteButton = By.cssSelector("[class='btn btn-danger']");
	
	// Home gomb a vízszintes menüsávban.
	private final By homeButton=By.xpath("//span[normalize-space()='Home']");
	
	private final By lastAddress=By.xpath(
			"//table[@class='table table-bordered table-hover']//tr[last()]//td[@class='text-left p-3']");
	
	private final By myAccountButton=By.xpath(
			"//a[@data-toggle='dropdown']//span[normalize-space()='My account'] ");
	
	public AddressBookPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(heading);
	}

	public AddressFormPage clickNewAddress() {
		click(newAddress);
		return new AddressFormPage(driver);
	}	

	// Megjelenő üzenet: Your address has been successfully added
	public String getSuccessMessage() {
		return getText(success);				
	}

	public String [] getLastAddress() {				
		String [] address=getText(lastAddress).split("\n");
		return address;
	}
	
	public HomePage clickHome() {
		click(homeButton);
		return new HomePage(driver);
	}	
	
	public HomePage clickAllDeletes() {
		List<WebElement> deleteButtonList=findAll(deleteButton);
		for (WebElement deleteButton : deleteButtonList) {
			deleteButton.click();
		}		
		return new HomePage(driver);
	}
	
	public LoginPage clickMyAccount() {
		click(myAccountButton);
		return new LoginPage(driver);
	}
	
}
