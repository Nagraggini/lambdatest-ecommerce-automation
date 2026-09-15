package utils;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Kiolvassa az adatokat a környezeti változók fájljából (gyökér könyvtárban van a .env fájl).
 */
public class ConfigReader {

	/*Tesztek létrehozásához, hogy ne kelljen mindig új fiókot létrehozni 
	a debuggoláskor.*/
	private static final Dotenv dotenv = Dotenv.configure().load();
    
    // Felhasználó adatai
    public static String getEmail() {
        return dotenv.get("USER_EMAIL");
    }

    public static String getPassword() {
        return dotenv.get("USER_PASSWORD");
    }   
    
}