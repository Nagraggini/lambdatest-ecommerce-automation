package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.AddressData;

public class AddressFormPage extends BasePage {
	private final By heading = By.cssSelector("#content h1");
	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input-lastname");
	private final By company = By.id("input-company");
	private final By address = By.id("input-address-1");
	private final By city = By.id("input-city");
	private final By postCode = By.id("input-postcode");
	private final By country = By.id("input-country");
	private final By region = By.id("input-zone");
	private final By continueButton = By.cssSelector("input[value='Continue']");

	public AddressFormPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(heading);
	}

	public AddressFormPage fillWithOutRegion(AddressData addressData) {
		type(firstName, addressData.firstName());
		type(lastName, addressData.lastName());
		type(company, addressData.company());
		type(address, addressData.address());
		type(city, addressData.city());
		type(postCode, addressData.postCode());
		// Megvárjuk, amíg a region legördülő lista ténylegesen feltöltődik opciókkal.
		wait.until(d -> select(country).getOptions().size() > 1);
		selectByValue(country, addressData.country());	
		return this;
	}
	
	public AddressFormPage fillRegion(AddressData addressData) {

		wait.until(d -> select(region).getOptions().size() > 1);
		selectByValue(region, addressData.region());
		return this;
	}
	
	public AddressBookPage save() {
		click(continueButton);
		return new AddressBookPage(driver);
	}
}
