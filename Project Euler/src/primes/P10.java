package primes;
/*The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.*/

public class P10 {
	public static void solve_P10(){
		long sum = 2;
		
		for (int i=3; i<=2000000; i++){
			if (isPrime(i)){
				sum += i;
				System.out.println(i + " " + sum);
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isPrime(int n) {
		if (n%2==0) return false;

	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
