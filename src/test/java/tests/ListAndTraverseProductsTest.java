package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.CategoryPage;

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
		
		// Components
		CategoryPage categoryPage=homePage.openCategory(25);			
		assertTrue(categoryPage.getInventoryItemCards().size()>0,"A termék kártyák nem jelentek meg.");
		assertEquals(15, categoryPage.getAllItemnamesAndTheirPrices().size(),"Nem jelent meg mind a 15 db termék.");  		
		
		// Cameras
		categoryPage.clickHomeButton().openCategory(33);		
		assertTrue(categoryPage.getInventoryItemCards().size()>0,"A termék kártyák nem jelentek meg.");
		assertEquals(15, categoryPage.getAllItemnamesAndTheirPrices().size(),"Nem jelent meg mind a 15 db termék.");  		
		
		
		categoryPage.clickHomeButton().openCategory(57);		
		assertTrue(categoryPage.getInventoryItemCards().size()>0,"A termék kártyák nem jelentek meg.");
		assertEquals(15, categoryPage.getAllItemnamesAndTheirPrices().size(),"Nem jelent meg mind a 15 db termék.");  		
	}


}
