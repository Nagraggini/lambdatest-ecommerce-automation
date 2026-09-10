package utils;

//Java 16-tól lehet ezt használni. Konstans változók. 
//Ez egy Java record deklaráció. 
//A record egy speciális Java osztálytípus, amelyet főként adatok tárolására használnak.
public record UserData(
		String firstName,
		String lastName,		
		String email,
		String telephone,
		String password		
){}
