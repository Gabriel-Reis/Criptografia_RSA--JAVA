import java.math.BigInteger;
import java.util.ArrayList;

public class Decripta {

	public ArrayList<BigInteger> decriptar(ArrayList<BigInteger> codificado, Keys keys) {
		
		// Recupera Keys Values
        BigInteger n = keys.getN();
        BigInteger d = keys.getD();
        ArrayList<BigInteger> decodificado = new ArrayList<>();
                
        for (int i = 0; i < codificado.size(); i++) {
			decodificado.add(codificado.get(i).modPow(d, n));
		}
       
        return decodificado;
	}
}
