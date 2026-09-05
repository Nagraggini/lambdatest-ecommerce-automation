package utils;

//Java 16-tól lehet ezt használni. Konstans változók. 
//Ez egy Java record deklaráció. 
//A record egy speciális Java osztálytípus, amelyet főként adatok tárolására használnak.
public record AddressData(
		String firstName,
		String lastName,
		String company,
		String address,
		String city,
		String postCode,
		String country,
		String region
){}
