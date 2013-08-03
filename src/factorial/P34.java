package factorial;
/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/
public class P34 {

	public void solve(){
		int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362800};
		final int upperBound = 10000000;
		int sumOfDig;
		int totalSum = 0;
		
		for (int i=3; i<=upperBound; i++){
			sumOfDig = 0;
			int temp = i;
			do {
				sumOfDig += factorial[temp % 10];
				temp /= 10;
			} while (temp > 0);
			
			if (sumOfDig == i){
				System.out.println(i);
				totalSum += i;
			}
		}
		System.out.println(totalSum);
	}
	
}
