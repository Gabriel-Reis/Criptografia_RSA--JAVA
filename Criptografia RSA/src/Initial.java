import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Initial {

	private static Encripta encriptador;
	private static Decripta decriptador = new Decripta();
	private static int tamanho = 100;
	
	public static void main(String args[]) {
		
		//Gera Chaves
			Keys keys = new Keys();
			keys.GerarKeyBasica();
			System.out.println(keys);
				
		//Recebe String e converte para BigInteger.
			String teste ="";
			try {
				Path path = Paths.get("src\\teste.txt");
				teste = new String(Files.readAllBytes(path));
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
		//Converte para BigIntegers
			if(tamanho == 0)
				tamanho = teste.length();
			teste = teste.substring(0, tamanho);
			System.out.println("Tamanho do texto: " +teste.length());
			
			long start = System.currentTimeMillis();
			BigInteger input = TradutorTexto.StringToBigInteger(teste);
			System.out.println("Tempo para Converter para Bytes:  " + (System.currentTimeMillis() - start) +"ms ou " + 
															(double) (((System.currentTimeMillis() - start)/1000)%60) +" segundos");
			
		//Encripta
			encriptador = new Encripta();
			start = System.currentTimeMillis();
			ArrayList<BigInteger> codificado = encriptador.encriptar(input, keys);
			System.out.println("Tempo para Encriptar: "+ (System.currentTimeMillis() - start) +"ms ou " + 
															(double) (((System.currentTimeMillis() - start)/1000)%60) +" segundos");
			//System.out.println("Codificado: \t\t\t\t" +TradutorTexto.BigIntegerArrayToString(codificado.subList(0, 100)));
		
		//Decripta BigInteger
			decriptador = new Decripta();
			start = System.currentTimeMillis();
			ArrayList<BigInteger> decriptado = decriptador.decriptar(codificado, keys);
			System.out.println("Tempo para Decriptar: " + (System.currentTimeMillis() - start) +"ms ou " + 
															(double) (((System.currentTimeMillis() - start)/1000)%60) +" segundos");
		
		//Retorna BigInteger para Texto 
			String fim = TradutorTexto.BigIntegerArrayToString(decriptado);
			if(teste.equals(fim))
				System.out.println("Sem erros ao decriptar");
			
		//Imprime início para conferir decriptação
			if(fim.length() > 100)
				System.out.println(fim.substring(0,100));
			else
				System.out.println(fim.substring(0,fim.length()));
	}

}
