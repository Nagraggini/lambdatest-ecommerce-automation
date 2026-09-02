package tests;

import static org.junit.jupiter.api.Assertions.*;

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
class ProductListTest extends BaseTest  {

	/**
	 * TC06 Termékek listázásának ellenőrzése
	 */
	@Test
	@DisplayName("TC06 Termékek listázásának ellenőrzése")	
	void checkProductListTest	() {
		//RegistrationPage registrationPage=
		CategoryPage categoryPage=homePage.clickTabletCategoryButton();		
		
		List<WebElement> items = categoryPage.getInventoryItemCards();
		
		assertTrue(items.size()>1);
			      
		// assertEquals("Privacy Policy",registrationPage.getPrivacyPolicyHeaderText());		 					
	}
		
/**
 * ## TC06 Termékek listázásának ellenőrzése

Teszt rövid leírása: A termékek listázásának ellenőrzése egy kiválasztott kategóriában.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A kategóriaválasztó menü megnyitása.
A „Tablets” kategória kiválasztása.
A terméklista betöltődésének megvárása.
A termékkártyák megjelenésének ellenőrzése.
Annak ellenőrzése, hogy minden termékkártyán megjelenik a termék neve és ára.
Annak ellenőrzése, hogy legalább egy termék látható a listában.

Elvárt eredmény: A „Tablets” kategóriaoldal hiba nélkül betöltődik.
 A terméklista nem üres, és a termékek neve, ára, valamint az „Add to Cart” lehetőség megjelenik.
 */

}
