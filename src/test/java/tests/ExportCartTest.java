package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.CartPage;
import utils.ShoppingCart;

class ExportCartTest extends BaseTest {

	/** TC11 Kosár tartalmának lementése
	 * Teszt rövid leírása: A terméklista adatainak összegyűjtése a felületről 
	 * és CSV-fájlba történő mentése.

Előfeltétel:

A „Tablets” kategória elérhető.
A kimeneti mappa írható.

Teszt lépések:

Navigáció a https://ecommerce-playground.lambdatest.io/ oldalra.
A „Tablets” kategória megnyitása.
A terméklista betöltődésének megvárása.
Az aktuális oldalon látható terméknevek összegyűjtése.
A termékekhez tartozó árak összegyűjtése.
A terméknevek és árak mentése az output/products.csv fájlba.
A létrehozott CSV-fájl visszaolvasása.
A fájl fejlécének ellenőrzése.
A mentett adatsorok számának összehasonlítása a felületről összegyűjtött termékek számával.
Az első és az utolsó mentett termék adatainak összehasonlítása a felületen megjelenő adatokkal.

Elvárt eredmény: Az output/cart.csv fájl sikeresen létrejön. 
A fájl tartalmazza a name és price fejlécet. Az adatsorok száma megegyezik a felületről 
összegyűjtött termékek számával, és a mentett terméknevek és árak helyesek.

	 */
	@Test
	@DisplayName("TC11 Kosár tartalmának lementése")		
	void exportCartTest() {
		
	CartPage cartPage=homePage
		.clickFirstIMacProduct()
		.setQuatity("5").clickAddToCart().clickHome()
		.clickHTCTouchHDProduct()
		.setQuatity("3").clickAddToCart().clickHome().clickCart().clickEditCart();
	
	ArrayList<ShoppingCart> shoppingCartList = cartPage.getShoppingCartProducts();

		for (ShoppingCart shoppingCart : shoppingCartList) {
			System.out.println(shoppingCart.toString());
		}
		/*
		 * A böngészőből leszedem a termék nevét,model, qty, unit price, total
		 * Egy listába elmentem és aztán kiírom egy csvfájlba.
		 * 
		 */
		
		// name,price,qty,total
	}

}
