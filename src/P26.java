import java.util.Hashtable;

/*A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/
public class P26 {
	final int upperLimit = 10000;
	public void solve(){
		int longest = 0;
		boolean found = false;
		int cycleLength;	
		
		for (int i = upperLimit; i>1 && !found; i--){
			cycleLength = getRecurringCycle(i);
			System.out.println(i + ": " + cycleLength);
			if (longest > i){
				found = true;
			}
			else if (cycleLength > longest){
				longest = cycleLength;
			}
		}
		
		System.out.println("Longest: " + longest);
	
	}
	public int getRecurringCycle(int n){
		int cycleLength = 0;
		boolean found = false;
		int remainder = 1;
		int position = 0;
		Hashtable<Integer, Integer> remainderRecord = new Hashtable<Integer, Integer>();
		
		while (!found & remainder != 0){
			remainder = (remainder*10) % n;
			if (remainderRecord.get(remainder) != null){
				cycleLength = position - remainderRecord.get(remainder);
				found = true;
			}
			else{
				remainderRecord.put(remainder, position++);
			}
		}
		return cycleLength;
	}
}
