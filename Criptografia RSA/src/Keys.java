import java.math.BigInteger;

public class Keys {
	
	BigInteger p;	//Numero para descoberta de chave
    BigInteger q;	//Numero para descoberta de chave
    BigInteger n;	//Expoente
    BigInteger z;	//Utiliza para descobrir Função inversa - primo correlacionado
    BigInteger e;	//
    BigInteger d;	//
	
    public void GerarKeyBasica() {
		p = new BigInteger("241");
	    q = new BigInteger("13");n = p.multiply(q);
	    z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	    e = new BigInteger("2159");
	    
	    for(int i=p.intValue()*3;i<500000;i++) {
	    	int mdc = mdc(z.intValue(),i); 
	    	if( mdc == 1) {
	    		e = BigInteger.valueOf( i);
	    		break;
	    	}
	    		
	    }
	    d = e.modInverse(z);
	    
	}
    
    public int mdc( int x, int y ){
        if(x == y){
            return x;
        }
        else if( y > x ){
            return mdc( x, y-x );
        }
        else if( x > y ){
            return mdc( x - y, y );
        }
        return 0;
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
