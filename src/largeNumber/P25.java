package largeNumber;
import java.math.BigInteger;

/*The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?
*/

public class P25 {
	public static void solve_P25(){
		int term = 3;
		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");

		while (true){
			first = first.add(second);
			if(first.toString().length() >= 1000){
				break;
			}
			term++;		
			second = second.add(first);
			if (second.toString().length() >= 1000){
				break;
			}
			term++;
		}
		System.out.println(term);
	}
	
}
