package factorial;
import java.util.ArrayList;
import java.util.HashMap;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/

public class P24 {
	
	ArrayList<Integer> numSet;
	HashMap<Integer, Integer> factMap;
	
	public void solve(){
		
		numSet = new ArrayList<Integer>();
		factMap = new HashMap<Integer, Integer>();
		factMap.put(0, 1);
		factMap.put(1, 1);
		factMap.put(2, 2);
		factMap.put(3, 6);
		factMap.put(4, 24);
		factMap.put(5, 120);
		factMap.put(6, 720);
		factMap.put(7, 5040);
		factMap.put(8, 40320);
		factMap.put(9, 362880);
		
		
		for (int i = 0; i<10; i++){
			numSet.add((Integer) i);
		}
		
		int remainder = 1000000-1;
		int quotient;
		int digit = 10;
		int factorial;
		
		for (int i = 1; i <= digit; i++){
			factorial = factMap.get(digit-i);
			quotient = remainder / factorial;
			remainder = remainder % factorial;
			
			System.out.print(numSet.get(quotient));
			numSet.remove(quotient);
			/*
			for (int j: numSet){
				System.out.print(j);
			}
			System.out.println();
*/
			
/*			if (remainder == 0){
				System.out.print(remainder);
				break;
			}*/
		}
		System.out.println();
	}
}
