package utils;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CsvFileWriter {

	/**
	 * Fájlba írás.
	 * @param shoppingCartList
	 * @param fileName
	 * @return
	 */
	public static Path csvFileWriter(ArrayList<ShoppingCart> shoppingCartList, String fileName) {

		// A mappa megadása.
		Path path = Path.of("output");
		Path fullPath=null;

		try {

			// A mappa létrehozása, ha még nem létezik.
			Files.createDirectories(path);

			// A fájl elérési útjának összeállítása.
			fullPath = path.resolve(fileName);

			FileWriter outputfile = new FileWriter(fullPath.toFile());

			CSVWriter writer = new CSVWriter(outputfile);
			List<String[]> data = new ArrayList<String[]>();

			data.add(new String[] { "productName", "model", "quatity", "unitPrice ($)", "total ($)" });

			for (ShoppingCart oneRowFromShoppingCart : shoppingCartList) {
				data.add(new String[] { oneRowFromShoppingCart.productName(), oneRowFromShoppingCart.model(),
						oneRowFromShoppingCart.quatity(), oneRowFromShoppingCart.unitPrice(),
						oneRowFromShoppingCart.total() });
			}

			writer.writeAll(data);

			writer.close();
			System.out.println("Itt találod a fájlt: " + fullPath.toAbsolutePath());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return fullPath;
	}
}
