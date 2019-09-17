import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TradutorTexto {
	public static BigInteger StringToBigInteger(String texto) {
		byte[] bytes = texto.getBytes();
		return new BigInteger(bytes);
	}
	
	public static String BigIntegerArrayToString(ArrayList<BigInteger> integer) {
		byte[] bytes = new byte[integer.size()];
		
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = integer.get(i).byteValue();
		}
		
		try {
			return (new String(bytes, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return "fail";
		}
	}
	
	public static String BigIntegerArrayToString(List<BigInteger> integer) {
		byte[] bytes = new byte[integer.size()];
		
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = integer.get(i).byteValue();
		}
		
		try {
			return (new String(bytes, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return "fail";
		}
	}
	
}
