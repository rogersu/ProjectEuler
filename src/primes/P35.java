/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, 
are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
*/

package primes;

import java.util.HashSet;
import java.util.Iterator;

public class P35 {
	
	public void solve(){
		HashSet<Integer> circPrimes = new HashSet<Integer>();
		
		
		for (int i = 2; i< 1000000; i++){
			if (!circPrimes.contains(i)){
				if (PrimeUtils.isPrime(i)){
					
					//check all rotations
					HashSet<Integer> rotations = getRotations(i);
					boolean allPrimes = true;
					
					/*
					Iterator<Integer> it = rotations.iterator();
										
					while (allPrimes && it.hasNext()){
						if (!PrimeUtils.isPrime(it.next())){
							allPrimes = false;
						}
					}*/
					
					for (Integer n: rotations){
						if (!PrimeUtils.isPrime(n)){
							allPrimes = false;
							break;
						}
					}
					
					if (allPrimes){
						for (Integer j: rotations){
							circPrimes.add(j);
						}
					}
				}
			}
		}
		
		//System.out.println(circPrimes.toString());
		System.out.println(circPrimes.size());
	}
	
	public HashSet<Integer> getRotations(int n){
		HashSet<Integer> rotations = new HashSet<Integer>();
		int temp = n;
		int numDigits = getDigits(n);
		
		do{
			rotations.add(temp);
			int dig = temp % 10;
			temp /= 10;
			temp += (int) Math.pow(10, numDigits-1) * dig;
			
		}while (temp != n);
		
		return rotations;
	}
	
	public int getDigits(int n){
		int digits = 0;
		
		do {
			digits++;
			n /= 10;
		} while (n > 0);
		
		return digits;
	}

}
