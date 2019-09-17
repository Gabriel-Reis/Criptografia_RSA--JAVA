import java.math.BigInteger;

public class Keys {
	
	BigInteger p;	//Numero para descoberta de chave
    BigInteger q;	//Numero para descoberta de chave
    BigInteger n;	//Expoente
    BigInteger z;	//Utiliza para descobrir Função inversa - primo correlacionado
    BigInteger e;	//Chave pública
    BigInteger d;	//Chave privada
	
    public void GerarKeyBasica() {
		p = new BigInteger("241");
	    q = new BigInteger("13");
	    e = new BigInteger("2159");
	    n = p.multiply(q);
	    z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	    d = e.modInverse(z);
	}
    	
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
