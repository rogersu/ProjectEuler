package largeNumber;
import java.math.BigInteger;

/*n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!*/

public class P20 {
	public static void solve_P20(){
		String s = String.valueOf(factorial(100));
		System.out.println(s);
		int sum = 0;
		for (char c: s.toCharArray()){
			sum += c-48;
		}
		System.out.println(sum);
	}
	public static BigInteger factorial(int n){
		BigInteger temp;
		if (n==1){
			temp = BigInteger.valueOf(1L);
		}
		else {
			temp = factorial(n-1);
			temp = temp.multiply(BigInteger.valueOf((long)n));
		}
		return temp;
	}
}
