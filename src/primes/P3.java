package primes;

public class P3 {
	
	public static void solve_P3(){
		final long n = 600851475143L;
		
		System.out.println(findLargestPrime(n));
	}
	public static int findLargestPrime(long p){
			
		for (int i=2; i<=(int)Math.sqrt(p); i++){
			
			if (p % i == 0){				
				int largest = i;
				int newLargest = findLargestPrime((long)p/i);
				
				System.out.println(largest + ", " + newLargest);
				
				if (newLargest > largest){
					return newLargest;
				}
				else{
					return largest;
				}
			}
		}
		
		return (int)p;
	}
}
