package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookPage extends BasePage {
	private final By heading = By.xpath("//h1[normalize-space()='Address Book Entries']");
	private final By newAddress = By.xpath("//a[normalize-space()='New Address']");

	private final By success = By.cssSelector(".alert-success");
	
	// Home gomb a vízszintes menüsávban.
	private final By homeButton=By.xpath("//span[normalize-space()='Home']");
	
	private final By lastAddress=By.xpath(
			"//table[@class='table table-bordered table-hover']//tr[last()]//td[@class='text-left p-3']");


	
	public AddressBookPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(heading);
	}

	public AddressFormPage clickNewAddress() {
		click(newAddress);
		return new AddressFormPage(driver);
	}	

	// Your address has been successfully added
	public String getSuccessMessage() {
		return getText(success);
				//.replace("×", "").trim();
	}

	
	public HomePage clickHome() {
		click(newAddress);
		return new HomePage(driver);
	}	
	

	

}
