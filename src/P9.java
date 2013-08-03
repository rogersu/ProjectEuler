
public class P9 {
	public static void solve_P9(){
		int squareA;
		int squareB;
		int squareC;
		int result=0;
		
		loop:
		for (int a=1; a<1000; a++){
			for(int b=1; b<1000; b++){
				for (int c=1; c<1000; c++){
					if (a+b+c == 1000){
						squareA = a*a;
						squareB = b*b;
						squareC = c*c;

						if (squareA + squareB == squareC){
							result = a*b*c;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
