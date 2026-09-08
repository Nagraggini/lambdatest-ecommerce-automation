package pages;

import java.util.ArrayList;
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
	
	private final By allAddress=By.xpath(
			"//table[@class='table table-bordered table-hover']//tr//td[@class='text-left p-3']");
	
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

	/* Megjelenő üzenetek.
	Új cím hozzáadása esetén: Your address has been successfully added
	Régi cím módosítása esetén: Your address has been successfully updated
	Cím törlése esetén: Your address has been successfully deleted*/
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
	
	public AddressBookPage clickAllDeletes() {
		List<WebElement> deleteButtonList=findAll(deleteButton);
		for (WebElement deleteButton : deleteButtonList) {
			deleteButton.click();
		}		
		return this;
	}
	
	public LoginPage clickMyAccount() {
		click(myAccountButton);
		return new LoginPage(driver);
	}
	
	// pl.: John Smith Az első ilyen nevű címnél kattintunk a szerkesztés gombra.
	public AddressFormPage clickEditSpecificAddress(String firstNameAndLastName) {				
		click(By.xpath("(//td[@class='text-left p-3' and starts-with(text(), '"
				+ firstNameAndLastName
				+ "')])[1]/following::td[1]//a[normalize-space()='Edit']"
				));
		return new AddressFormPage(driver);
	}	

	// pl.: John Smith Az első ilyen nevű címnél kattintunk a szerkesztés gombra.
	public AddressBookPage clickDeleteSpecificAddress(String firstNameAndLastName) {				
			click(By.xpath("(//td[@class='text-left p-3' and starts-with(text(), '"
					+ firstNameAndLastName
					+ "')])[1]/following::td[1]//a[normalize-space()='Delete']"
					));
			return this;
		}	
		
	public List<AddressData> getAllAddress() {	
	    List<AddressData> addresses = new ArrayList<>();
	    List<WebElement> allAddressList = findAll(allAddress);

	    for (WebElement oneAddress : allAddressList) {
	        String[] addressLines = oneAddress.getText().split("\n");
	        
	        String fullName = addressLines[0];
	        // Az utolsó szóköz megkeresése, ha nincs benne, akkor -1 lesz az értéke.
	        int lastSpaceIndex = fullName.lastIndexOf(' ');
	        
	        // Ha van szóköz a névben, szétvágjuk, különben az egészet a vezetéknévhez tesszük.
	        String firstName = (lastSpaceIndex != -1) ? fullName.substring(0, lastSpaceIndex) : fullName;
	        // Az oldal nem enged menteni üres mezővel.
	        String lastName = (lastSpaceIndex != -1) ? fullName.substring(lastSpaceIndex + 1) : "";
	        
	        
	        String cityAndPostalCode = addressLines[3];
	        lastSpaceIndex = cityAndPostalCode.lastIndexOf(' ');
	        
	        String city=(lastSpaceIndex != -1) ? cityAndPostalCode.substring(0, lastSpaceIndex) : cityAndPostalCode;
	        // Az oldal nem enged menteni üres mezővel.
	        String postalCode= (lastSpaceIndex != -1) ? cityAndPostalCode.substring(lastSpaceIndex + 1) : "";

	        addresses.add(new AddressData(
	            firstName,
	            lastName,
	            addressLines[1], // company
	            addressLines[2], // address
	            city, 			 // city
	            postalCode,		 // postCode
	            addressLines[4], // country
	            ""  // region/state 
	        ));
	    }

	    return addresses;
	}
	
	
}
