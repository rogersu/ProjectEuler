package stringOp;
import java.util.Hashtable;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 
letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is 
in compliance with British usage.
*/
public class P17 {
	final int upperLimit = 1000;
	Hashtable<Integer, String> numMapping;
	
	public P17(){
		numMapping = new Hashtable<Integer, String>();
		numMapping.put(1, "one");
		numMapping.put(2, "two");
		numMapping.put(3, "three");
		numMapping.put(4, "four");
		numMapping.put(5, "five");
		numMapping.put(6, "six");
		numMapping.put(7, "seven");
		numMapping.put(8, "eight");
		numMapping.put(9, "nine");
		numMapping.put(10, "ten");
		numMapping.put(11, "eleven");
		numMapping.put(12, "twelve");
		numMapping.put(13, "thirteen");
		numMapping.put(14, "fourteen");
		numMapping.put(15, "fifteen");
		numMapping.put(16, "sixteen");
		numMapping.put(17, "seventeen");
		numMapping.put(18, "eighteen");
		numMapping.put(19, "nineteen");
		numMapping.put(20, "twenty");
		numMapping.put(30, "thirty");
		numMapping.put(40, "forty");
		numMapping.put(50, "fifty");
		numMapping.put(60, "sixty");
		numMapping.put(70, "seventy");
		numMapping.put(80, "eighty");
		numMapping.put(90, "ninety");
		
		numMapping.put(100, "hundred");
		numMapping.put(1000, "thousand");
		
	}
	public void solve(){
		int sum = 0;
		int length;
		String s;
		
		for(int i=1; i<= upperLimit; i++){
			s = getNumString(i);
			System.out.println(s);
			length = s.length();
			sum += length;
		}
		
		System.out.println("Sum:" + sum);
	}
	
	public String getNumString(int n){
		String s = "";
		int multiple;
		
		if (n > 0){
			if (n >= 1000){
				multiple = n / 1000;
				s = getNumString(multiple) + numMapping.get(1000) + getNumString(n % 1000);
				return s; 
			}
			else if (n >= 100){
				multiple = n / 100;
				s = getNumString(multiple) + numMapping.get(100);
				if (n % 100 != 0){
					s += "and" + getNumString(n % 100);
				}
				return s;
			}
			else{
				if (n > 19){
					multiple = n / 10;
					s = numMapping.get(multiple*10);
					if (n % 10 != 0){
						s += numMapping.get(n % 10);
					}
					return s;
				}
				else{
					return numMapping.get(n);
				}
			}
		}
		return s;
	}
}
