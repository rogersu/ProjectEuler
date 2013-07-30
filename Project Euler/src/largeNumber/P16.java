package largeNumber;
import java.math.BigInteger;

/*2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/
public class P16 {
	public static void solve_P16(){
		final String bignumber = BigInteger.valueOf(2).pow(1000).toString(10);
		long result = 0;
		for (int i = 0; i < bignumber.length(); i++) {
			result += Integer.valueOf(String.valueOf(bignumber.charAt(i)));
		}
		System.out.println("result: " + result);
	}
	
}
