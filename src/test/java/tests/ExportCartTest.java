package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.CartPage;
import utils.CsvFileWriter;
import utils.ShoppingCart;

class ExportCartTest extends BaseTest {

	/**
	 * TC11 Kosár tartalmának lementése  
	 */
	@Test
	@DisplayName("TC11 Kosár tartalmának lementése")
	void exportCartTest() {

		CartPage cartPage = homePage.clickFirstIMacProduct().setQuatity("5").clickAddToCart().clickHome()
				.clickHTCTouchHDProduct().setQuatity("3").clickAddToCart().clickHome().clickCart().clickEditCart();

		ArrayList<ShoppingCart> shoppingCartList = cartPage.getShoppingCartProducts();

		Path path = CsvFileWriter.csvFileWriter(shoppingCartList, "cart.csv");
		
		assertTrue(path.toFile().exists());
		

	}

}
