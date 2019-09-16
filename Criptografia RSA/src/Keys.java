import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;

public class Keys {
	
	BigInteger p;	//Numero para descoberta de chave
    BigInteger q;	//Numero para descoberta de chave
    BigInteger n;	//Expoente
    BigInteger z;	//Utiliza para descobrir Função inversa - primo correlacionado
    BigInteger e;	//Chave pública
    BigInteger d;	//Chave privada
	
    public void GerarKeyBasica() {
		p = new BigInteger("885320963");
	    q = new BigInteger("238855417");
	    e = new BigInteger("9007");
	    n = p.multiply(q);
	    z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	    d = e.modInverse(z);
	}
    
    /*public void GerarKeyJAva() {
		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(512); //128 bytes de chave
			KeyPair kp = kpg.generateKeyPair();
			//PublicKey pubK = (RSAPublicKey) kp.getPublic();
			//RSAPublicKey rsapubk = (RSAPublicKey) pubK;
			PrivateKey privK = kp.getPrivate();
			RSAPrivateCrtKey rsaprivk = (RSAPrivateCrtKey) privK;
		
			/*System.out.println("Expoente (chave pública): " +rsapubk.getPublicExponent().toString(16));
			System.out.println("Imprimindo a chave privada obtida:" +kp.getPrivate());
			System.out.println("Imprimindo a chave publica obtida:" +kp.getPublic());
			System.out.println("Módulo (chave privada): " + rsaprivk.getModulus().toString(16));
			System.out.println("Expoente (chave privada): " + rsaprivk.getPrivateExponent().toString(16));
			System.out.println("Expoente P (chave privada): " + rsaprivk.getPrimeExponentP().toString(16));
			System.out.println("Expoente Q (chave privada): " + rsaprivk.getPrimeExponentQ().toString(16));
			System.out.println("Coeficiente CRT (chave privada): " + rsaprivk.getCrtCoefficient().toString(16));
		
			p = new BigInteger(rsaprivk.getPrimeP().toString(16).getBytes());
		    q = new BigInteger(rsaprivk.getPrimeQ().toString(16).getBytes());
		    n = p.multiply(q);
		    e = new BigInteger(kp.getPublic().getEncoded());
		    z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		    d =  new BigInteger(kp.getPrivate().getEncoded());
		    
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }*/
	
	/*public void GerarKeyBasica2() {
		p = new BigInteger("241");
		q = new BigInteger("13");
		n = p.multiply(q);
		e = BigInteger.ONE;
		z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	    d = e.modInverse(z);
		
		//mdc(z,e) = 1
		for(int i = z; i>1; i--) {
			if(z%i == 1) {
				e = i;
				break;
			}
		}
		
		if(e.compareTo(BigInteger.ONE) == -1)
			System.out.println("Impossível continuar");
		
		 //e.d mod z = 1
		for(int i = 0; i<z; i++) {
			if( (e*i)%z == 1) {
				d = i;
				break;
			}
		}
	}*/
	
	public BigInteger getP() {
		return p;
	}
	public BigInteger getQ() {
		return q;
	}
	public BigInteger getE() {
		return e;
	}
	public BigInteger getN() {
		return n;
	}
	public BigInteger getZ() {
		return z;
	}
	public BigInteger getD() {
		return d;
	}
	@Override
	public String toString() {
		return "Keys [p=" + p + ", q=" + q + ", n=" + n + ", z=" + z + ", e=" + e + "]";
	}
}
