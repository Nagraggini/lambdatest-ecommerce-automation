package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.AddressData;

public class AddressFormPage extends BasePage {
	private final By heading = By.cssSelector("#content h1");
	private final By firstNameInput = By.id("input-firstname");
	private final By lastNameInput = By.id("input-lastname");
	private final By companyInput = By.id("input-company");
	private final By addressInput = By.id("input-address-1");
	private final By cityInput = By.id("input-city");
	private final By postCodeInput = By.id("input-postcode");
	private final By countryInput = By.id("input-country");
	private final By regionInput = By.id("input-zone");
	private final By continueButton = By.cssSelector("input[value='Continue']");

	public AddressFormPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(heading);
	}

	public AddressFormPage fillWithOutRegion(AddressData addressData) {
		type(firstNameInput, addressData.firstName());
		type(lastNameInput, addressData.lastName());
		type(companyInput, addressData.company());
		type(addressInput, addressData.address());
		type(cityInput, addressData.city());
		type(postCodeInput, addressData.postCode());
		
		// Megvárjuk, amíg a region legördülő lista ténylegesen feltöltődik opciókkal.
		wait.until(d -> select(countryInput).getOptions().size() > 1);
		selectByValue(countryInput, addressData.country());	

	    // Kis várakozás, hogy a régiókezelés lefusson a háttérben.
	    try {
	        Thread.sleep(1000); 
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
		return this;
	}
	
	public AddressFormPage fillRegion(AddressData addressData) {

		wait.until(d -> select(regionInput).getOptions().size() > 1);
		selectByValue(regionInput, addressData.region());
		return this;
	}
	
	public AddressFormPage fillLastName(String lastName) {
		clearAndType(lastNameInput, lastName);
		return this;
	}
	
	public AddressFormPage fillFirstName(String firstName) {
		clearAndType(firstNameInput, firstName);
		return this;
	}
	
	public AddressBookPage save() {
		click(continueButton);
		return new AddressBookPage(driver);
	}
}
