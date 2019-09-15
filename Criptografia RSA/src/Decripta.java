import java.math.BigInteger;

public class Decripta {

	public BigInteger decriptar(BigInteger inputEncrypted, Keys keys) {
		
		// Recupera Keys Values
        BigInteger e = keys.getE();
        BigInteger n = keys.getN();
        BigInteger z = keys.getZ();
  
        
        // Decripta Entrada
        BigInteger d = e.modInverse(z);
        //System.out.println("Computação intermediária: " + d);
                
        byte[] inputAsBytesEncrypted = inputEncrypted.toByteArray();      
        byte[] inputDecrypted = (new BigInteger(inputAsBytesEncrypted)).modPow(d, n).toByteArray();
        BigInteger decrypted = new BigInteger(inputDecrypted);
        
        return decrypted;
	}
}
