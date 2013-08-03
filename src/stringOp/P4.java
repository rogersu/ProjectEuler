package stringOp;

public class P4 {
	public static void solve_P4(){
		int product = 0;
		int largest = 0;
		
		for (int i=999; i>=100; i--){
			for(int j=999; j>=100; j--){
				product = i*j;
				if (isPalindrome(product)){
					System.out.println(product);
					if (product > largest){
						largest = product;
					}
				}
			}
		}
		System.out.println(largest);
	}
	
	public static boolean isPalindrome(int n){
		String s = String.valueOf(n);
		int len = s.length();
		char[] char_array = s.toCharArray();

		for (int i=0; i<len/2; i++){
			if (char_array[i] != char_array[len-1-i]){
				return false;
			}
		}
		return true;
	}
}
