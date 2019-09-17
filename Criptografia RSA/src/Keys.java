import java.math.BigInteger;

public class Keys {
	
	BigInteger p;	//Numero para descoberta de chave
    BigInteger q;	//Numero para descoberta de chave
    BigInteger n;	//Expoente
    BigInteger z;	//Utiliza para descobrir Função inversa - primo correlacionado
    BigInteger e;	//Chave publica (n,e)
    BigInteger d;	//Chave privada (d,e)
	
    public void GerarKeyBasica(BigInteger p, BigInteger q) {
    	this.p = p;
    	this.q = q;
	    n = p.multiply(q);
	    z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	    
	    for(BigInteger i=p.multiply(BigInteger.valueOf(3));true;i = i.add(BigInteger.ONE)) {
	    	BigInteger mdc = i.gcd(z);
	    	if( mdc.compareTo(BigInteger.ONE)==0) {
	    		e = i;
	    		break;
	    	}
	    }
	    
	    /*for(int i=p.intValue()*3;true;i++) {
	    	int mdc = mdc(z.intValue(),i);
	    	if( mdc == 1) {
	    		e = BigInteger.valueOf(i);
	    		break;
	    	}
	    }*/
	    
	    d = e.modInverse(z);
	}


	/*public static int mdceu(BigInteger a, BigInteger b){
		while ( a.mod(b).(BigInteger.valueOf(0)) != 0 ) {  
			int a3 = a%b;   
		     a = b;  
		     b = a3;  
		}
		return b;  
	}*/

    public int mdc( int x, int y ){
        if(x == y)
            return x;
        else if( y > x )
            return mdc( x, y-x );
        else if( x > y )
            return mdc( x - y, y );
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
