package primes;
/*By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?*/

public class P7 {
	public static void solve_P7(){
		final int lastPrime = 10001;
		long counter = 1;
		long i = 1;
		
		while(counter <= lastPrime){
			if (isPrime(++i)){
				System.out.println(counter + ": " + i);
				counter++;
			}
		}
		System.out.println(i);
	}
	
	public static boolean isPrime(long n){
		for (int i=2; i<n; i++){
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}
}
