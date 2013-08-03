package factors;
import java.util.Arrays;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/		
public class P5 {
	public static void solve_P5(){

		final int limit = 20+1;
		
		int[] factorArray = new int[limit];
		int[] tempArray;
		int result = 1;
		
		for (int i=2; i<=limit; i++){
			tempArray = findFactors(i, new int[limit]);
			System.out.println(Arrays.toString(tempArray));

			for (int j = 2; j<limit; j++){
				if (tempArray[j] > factorArray[j]){
					factorArray[j] = tempArray[j];
				}
			}
		}
		
		System.out.println(Arrays.toString(factorArray));
		
		for (int i=2; i<limit; i++){
			if (factorArray[i] != 0){
				result *= Math.pow(i, factorArray[i]) * i;
			}
		}	
		System.out.println(result);

	}
	public static int[] findFactors(int n, int[] factorArray){
		
		for (int i=2; i<=(int)Math.sqrt(n); i++){
			if (n % i == 0){
				factorArray[i]++;
				return findFactors((int)n/i, factorArray);
			}
		}
		factorArray[n]++;
		return factorArray;
	}
}
