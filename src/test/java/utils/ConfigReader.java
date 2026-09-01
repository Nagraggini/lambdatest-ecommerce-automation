package utils;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Kiolvassa az adatokat a környezeti változók fájljából (gyökér könyvtárban van a .env fájl).
 */
public class ConfigReader {

	private static final Dotenv dotenv = Dotenv.configure().load();
    
    // Felhasználó adatai
    public static String getEmail() {
        return dotenv.get("USER_EMAIL");
    }

    public static String getPassword() {
        return dotenv.get("USER_PASSWORD");
    }   
    
}
