import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class TradutorTexto {
	public static BigInteger StringToBigInteger(String texto) {
		byte[] bytes = texto.getBytes();
		return new BigInteger(bytes);
	}
	
	public static String BigIntegerToString(BigInteger integer) {
		try {
			return new String(integer.toByteArray(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
}
