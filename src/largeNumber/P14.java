package largeNumber;
import java.util.Hashtable;


/*The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/
public class P14 {
	static Hashtable<Long, Integer> collatzMap;
	//static int[] collatzMap;
	static final Long upperLimit = 1000000L;
	
	public static void solve_P14(){
		collatzMap = new Hashtable<Long, Integer>();
		
		collatzMap.put(1L, 1);
		collatzMap.put(2L, 2);
		collatzMap.put(4L, 3);
		collatzMap.put(8L, 4);
		collatzMap.put(16L, 5);
		collatzMap.put(5L, 6);
		collatzMap.put(10L, 7);
		collatzMap.put(20L, 8);
		collatzMap.put(40L, 9);
		collatzMap.put(13L, 10);		
		
		int largest = 0;
		//int largest_index = 0;
		int chainLength;
		
		for (Long i = 1L; i<upperLimit; i++){
			chainLength = getChainLength(i);
			//System.out.println(i + ": " + chainLength);
			if (chainLength > largest){
				largest = chainLength;
				//largest_index = i;
				System.out.println("LARGEST " + i + ": " + chainLength);
			}
		}	
		
		/*int upperLimit = 1000000;
		collatzMap = new int[upperLimit];
		long sequenceNum;
		int chainLength;
		int longest = 0;
		
		for (int i = 2; i<upperLimit; i++){
			sequenceNum = i;
			chainLength = 1;
			
			while (sequenceNum != 1){
				if (sequenceNum % 2 == 0){
					sequenceNum /= 2;
				}
				else{
					sequenceNum = 3 * sequenceNum + 1;
				}
				chainLength++;
			}
			
			if(chainLength > longest){
				longest = chainLength;
				System.out.println("Longest " + i + " " + longest);
			}
			
		}*/
		
 
		
	}
	
	public static Integer getChainLength(Long n){
		Long nextVal;
		Integer nextLength = 0;
		Integer thisLength = 0;
		
		if(n > upperLimit){
			Long sequenceNum = n;
			thisLength = 1;
			
			while (sequenceNum != 1){
				if (sequenceNum % 2 == 0){
					sequenceNum /= 2;
				}
				else{
					sequenceNum = 3 * sequenceNum + 1;
				}
				thisLength++;
			}
			return thisLength;
		}
		else{
			thisLength = collatzMap.get(n);
			
			if(thisLength == null)
			{
				if (n % 2 == 0){
					nextVal = n / 2;
				}
				else {
					nextVal = 3 * n + 1;
				}
				
				nextLength = collatzMap.get(nextVal);
				if (nextLength == null){
					nextLength = getChainLength(nextVal);
				}
				//System.out.println("Putting " + n + ", " + nextLength+1);
				collatzMap.put(n, nextLength + 1);
				return nextLength + 1;
	
			}
			else{
				return thisLength;
			}
		}
	}
}
