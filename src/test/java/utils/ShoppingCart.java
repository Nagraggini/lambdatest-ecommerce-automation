package utils;

//Java 16-tól lehet ezt használni. Konstans változók. 
//Ez egy Java record deklaráció. 
//A record egy speciális Java osztálytípus, amelyet főként adatok tárolására használnak.

public record ShoppingCart(
		String productName,
		String model,		
		String quatity,
		String unitPrice,
		String total		
){}
