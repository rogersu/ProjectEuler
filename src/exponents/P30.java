package exponents;
/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

public class P30{

	public void solve(){
		int numSum;
		int digit; 
		int totalSum = 0;
		int n;
		
		for (int i = 2; i < 1000000; i++){
			numSum = 0;
			n = i;
			do{
				digit = n % 10;
				n = n / 10;
				numSum += Math.pow(digit, 5);
			} while(n > 0);
			if (numSum == i){
				totalSum += numSum;
			}
		}
		System.out.println(totalSum);
	}
}