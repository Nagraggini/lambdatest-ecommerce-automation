package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import pages.AccountPage;
import pages.CategoryPage;
import pages.RegistrationPage;

@Tag("ui")
@Tag("regression")
class ListAndTraverseProductsTest extends BaseTest  {

	/**
	 * TC05 Terméklista+validáció ellenőrzés (Traversal Test -> bejárás teszt
	 * a DOM struktúráját csekkolja, hogy be lehet-e járni az adott részt.
	 */
	@Test
	@DisplayName("TC05 Terméklista+validáció ellenőrzés ")	
	void checkProductListTest() {
		CategoryPage categoryPage=homePage.clickShopByCategory()
				.clickPhoneTabletIpodCategory();		
			
		assertTrue(categoryPage.getInventoryItemCards().size()>0,"A termék kártyák nem jelentek meg.");
		
		assertEquals(15, categoryPage.getAllItemnamesAndTheirPrices().size(),"Nem jelent meg mind a 15 db termék.");  		
		
		categoryPage.clickShopByCategoryButton().clickCamerasButton();		
		assertTrue(categoryPage.getInventoryItemCards().size()>0,"A termék kártyák nem jelentek meg.");
		
		assertEquals(15, categoryPage.getAllItemnamesAndTheirPrices().size(),"Nem jelent meg mind a 15 db termék.");  		
		
		
		categoryPage.clickShopByCategoryButton().clickComponentsButton();
		
		assertTrue(categoryPage.getInventoryItemCards().size()>0,"A termék kártyák nem jelentek meg.");
		
		assertEquals(15, categoryPage.getAllItemnamesAndTheirPrices().size(),"Nem jelent meg mind a 15 db termék.");  		
	}


}
