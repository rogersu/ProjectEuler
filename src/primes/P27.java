package primes;
/*
Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. 
However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly 
when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the 
consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces
the maximum number of primes for consecutive values of n, starting with n = 0.
*/

public class P27{
	public void solve(){
		int max = 0;
		int n;
		int primeCounter;
		int result;
		
		for (int i = -999; i<1000; i++){
			for (int j = -999; j<1000; j++){
				n = 0;
				primeCounter = 0;
				
				while (true){
					result = n*n + i * n + j;
					if (result > 0 && isPrime(result)){
						primeCounter++;
					}
					else{
						break;
					}
					n++;
				}

				if (primeCounter > max){
					max = primeCounter;
					System.out.println(max+ "   " + i + " " + j + " " + i*j);
				}
			}
		}
	}
	
	public boolean isPrime(int n){
		if (n<4) return true;
		else{
			if (n % 2 == 0) return false;
			for (int i = 3; i*i<=n; i+=2){
				if(n % i == 0){
					return false;
				}
			}
		}
		return true;
	}
}