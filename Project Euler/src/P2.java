
public class P2 {
	public static void solve_P2(){
		final int limit = 4000000;
		int v1 = 1;
		int v2 = 2;
		int sum = 0;
		
		while (v1 < limit & v2 < limit){
			if (v1 % 2 == 0){
				sum += v1;
			}
			if (v2 % 2 == 0){
				sum += v2;
			}
			v1 = v1 + v2;
			v2 = v1 + v2;
		}
		System.out.println(sum);
	}
}
