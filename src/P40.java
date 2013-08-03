/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
*/
public class P40 {
	
	public void solve(){
		int result = getDigitValue(1) * getDigitValue(10) * getDigitValue(100) * getDigitValue(1000) *
				getDigitValue(10000) * getDigitValue(100000) * getDigitValue(1000000);
				
		System.out.println(result);
	}

	public int getDigitValue(int n){
		int digitValue;
		int counter = 0;
		int digit = 0 ;
		
		while (digit < n){
			digit += getNumDigits(++counter);
		}
		
		digitValue = (counter / (int) Math.pow(10, (digit-n))) % 10;
		return digitValue;
	}
	
	public int getNumDigits(int n){
		int digits = 0;
		
		do {
			digits++;
			n /= 10;
		} while (n > 0);
		
		return digits;
	}
}
