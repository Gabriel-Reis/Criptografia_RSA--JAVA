import java.math.BigInteger;

public class Keys {
	
	BigInteger p;
    BigInteger q;
    BigInteger e;
    BigInteger n;
    BigInteger z;
	
    public void GerarKeyJAva() {
    	
    }
    
	public void GerarKeyBasica() {
		p = new BigInteger("885320963");
	    q = new BigInteger("238855417");
	    e = new BigInteger("9007");
	    n = p.multiply(q);
	    z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
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
	@Override
	public String toString() {
		return "Keys [p=" + p + ", q=" + q + ", n=" + n + ", z=" + z + ", e=" + e + "]";
	}
}
