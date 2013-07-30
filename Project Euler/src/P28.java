/*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
*/
public class P28 {
	final int GRIDSIZE = 1001;
	
	public void solve(){
		int counter = 1;
		int sum = 0;
		int x = 0;
		int y = 0;
		int sideLength = 1;
		
		bigloop:
		while (true){
			//right
			for (int i=0; i<sideLength; i++){
				if ((x == y) || (x == -1 * y)){
					sum += counter;
				}
				if (counter >= GRIDSIZE * GRIDSIZE){
					break bigloop;
				}
				x++;
				counter++;
			}
			
			//down
			for (int i=0; i<sideLength; i++){
				if ((x == y) || (x == -1 * y)){
					sum += counter;
				}
				if (counter >= GRIDSIZE * GRIDSIZE){
					break bigloop;
				}
				y--;
				counter++;
			}
			
			
			//left
			for (int i=0; i<sideLength+1; i++){
				if ((x == y) || (x == -1 * y)){
					sum += counter;
				}
				if (counter >= GRIDSIZE * GRIDSIZE){
					break bigloop;
				}
				x--;
				counter++;
			}
			
			//up
			for (int i=0; i<sideLength+1; i++){
				if ((x == y) || (x == -1 * y)){
					sum += counter;
				}
				if (counter >= GRIDSIZE * GRIDSIZE){
					break bigloop;
				}
				y++;
				counter++;
			}
			
			sideLength += 2;	
		}
		System.out.println(sum);
	}
}
