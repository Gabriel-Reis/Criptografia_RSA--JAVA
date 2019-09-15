import java.math.BigInteger;

public class Initial {

	private static Encripta encriptador;
	private static Decripta decriptador = new Decripta();
	
	public static void main(String args[]) {
		
		//Gera Chaves
			Keys keys = new Keys();
			keys.GerarKeyBasica();
			System.out.println(keys);
				
		//Recebe Sting e converte para BigInteger.
			String teste = "1234567";
			System.out.println("Conteúdo original: \t\t\t" +teste);
			BigInteger input = TradutorTexto.StringToBigInteger(teste);
			System.out.println("Conteúdo convertido para encriptação: \t" +input);
	
		//Encripta BigInteger
			encriptador = new Encripta();
			BigInteger codificado = encriptador.encriptar(input, keys);
			System.out.println("Codificado: \t\t\t\t" +String.valueOf(codificado));
		
		//Decripta BigInteger
			decriptador = new Decripta();
			BigInteger decriptado = decriptador.decriptar(codificado, keys);
			System.out.println("Conteúdo decodificado: \t\t\t" +decriptado);
		
		//Retorna BigInteger para Texto 
			System.out.println("Conteúdo traduzido: \t\t\t" +TradutorTexto.BigIntegerToString(decriptado));
	}

}
