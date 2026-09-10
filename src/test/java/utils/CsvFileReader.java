package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class CsvFileReader {

	/**
	 * Külön csv fájl olvasó, ami a User osztály alapján készít egy listát.
	 * @param filePath
	 */
	public static ArrayList<UserData>  readCsvFile(String filePath) {
		
		ArrayList<UserData> userList=new ArrayList(); 
				
		try (BufferedReader scanner=new BufferedReader (new FileReader(filePath))){
			// Az első sor a fejlécet tartalmazza. 
			scanner.readLine();	
			String line = "";
			// Addig megyünk amíg el nem érjük a fájl végét.
			
			while((line=scanner.readLine())!=null) {
				String [] row=line.split(",");	
							
				// A UserData osztály alapján készít egy listát.
				userList.add(new UserData(row[0],row[1],row[2],row[3],row[4]));
			}
						
		} catch (Exception e) {
			System.out.println("Hiba a fájl beolbasásakor:"+e.getMessage());
		}		
		System.out.println("Vége a fájlt olvasásnak");
		return userList;		
	}
}
