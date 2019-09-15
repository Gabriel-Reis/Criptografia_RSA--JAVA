import java.math.BigInteger;
public class Encripta {
	
	public BigInteger encriptar(BigInteger input, Keys keys) {
		
		//Recupera Keys Values
        BigInteger e = keys.getE();
        BigInteger n = keys.getN();
        
        byte[] inputAsBytes = input.toByteArray();        
        byte[] inputAsBytesEncrypted = (new BigInteger(inputAsBytes)).modPow(e, n).toByteArray();
        BigInteger inputEncrypted = new BigInteger(inputAsBytesEncrypted);
    
		return inputEncrypted;
	}
}
