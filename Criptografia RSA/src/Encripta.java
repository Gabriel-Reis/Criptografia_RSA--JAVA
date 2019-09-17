import java.math.BigInteger;
import java.util.ArrayList;
public class Encripta {
	
	public ArrayList<BigInteger> encriptar(BigInteger input, Keys keys) {
		
		//Recupera Keys Values
        BigInteger e = keys.getE();
        BigInteger n = keys.getN();
        
        ArrayList<BigInteger> codificado= new ArrayList<>();
        byte[] inputAsBytes = input.toByteArray();
       
        for (int i = 0; i < inputAsBytes.length; i++) {
			codificado.add(BigInteger.valueOf(inputAsBytes[i]).modPow(e, n));
		}
       
    
		return codificado;
	}
}
