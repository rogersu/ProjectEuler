package largeNumber;

import java.math.BigInteger;

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
*/
public class P48 {
	final int upperLimit = 1000;
	
	public void solve(){
		BigInteger sum = new BigInteger("0");
		
		for (int i = 1; i<=upperLimit; i++){
			sum = sum.add(new BigInteger(""+i).pow(i));
		}
		String s = sum.toString();
		System.out.println(s.substring(s.length()-10, s.length()));
	}
}
