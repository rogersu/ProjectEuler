/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 
is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant 
if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written 
as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers 
greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot 
be reduced any further by analysis even though it is known that the greatest number that cannot be expressed 
as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/
public class P23{
	final int upperLimit = 28123;
	boolean[] abundantArray;
	
	public P23(){
		abundantArray = new boolean[upperLimit];
		for (int i=0; i<upperLimit; i++) {
			abundantArray[i] = false;
		}
	}
	
	public void solve(){
		int sum = 0;
		for (int i = 1; i < upperLimit; i++){
			int sumDiv = sumDivisors(i);
			if (sumDiv > i){
				abundantArray[i] = true;
				//System.out.println(i + " abundant");
			}
			if (madeOfTwoAbundant(i) == false){
				sum += i;
				System.out.println(i + " not made of two abundants");
			}
			System.out.println(i + " abundant: " + abundantArray[i]);

		}
		
		System.out.println(sum);
	}
	
	public int sumDivisors(int n){
		int sum = 0;
		for (int i=1; i<n; i++){
			if (n % i == 0){
				sum += i;
			}
		}
		return sum;
	}
	
	public boolean madeOfTwoAbundant(int n){
		
		for (int i = 1; i<=n/2; i++){
			if (abundantArray[i] & abundantArray[n-i]){
				return true;
			}
		}
		return false;
	}
}
