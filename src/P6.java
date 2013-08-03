
public class P6 {
	public static void solve_P6(){
		int sumOfSquares = 0;
		int individualSum = 0;
		
		for (int i=1; i<=100; i++){
			individualSum += i;
			sumOfSquares += i*i;
		}
		
		System.out.println(individualSum*individualSum - sumOfSquares);
	}
}
