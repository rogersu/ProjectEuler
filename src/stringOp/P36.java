package stringOp;
/*
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
*/


public class P36 {

	public void solve(){
		int sum = 0;
		
		for(int i = 1; i<1000000; i++){
			if (isPalindrome(i,10) && isPalindrome(i, 2)){
				sum += i;
			}
		}
		System.out.println(sum);
		
	}
	
	public boolean isPalindrome(int n, int radix){
		String s;
		int len;
		char[] char_array;
		
		if (radix == 10){
			//check Decimal
			s = String.valueOf(n);
			len = s.length();
			char_array = s.toCharArray();
	
			for (int i=0; i<len/2; i++){
				if (char_array[i] != char_array[len-1-i]){
					return false;
				}
			}
			return true;
		}
		else if (radix == 2){
			//check binary
			s = Integer.toBinaryString(n);
			len = s.length();
			char_array = s.toCharArray();
			for (int i=0; i<len/2; i++){
				if (char_array[i] != char_array[len-1-i]){
					return false;
				}
			}
			return true;
		}
		else { return false;}
	}
}
