package path;
/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), 
a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve 
this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it 
would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P67 {
	final int maxLines = 100;
	
	public void solve(){
		FileReader file = null;
		BufferedReader reader = null;
		int lineNum = 0;
		int[][] intArr = new int[maxLines][];
		String[] strArr;
		
		try {
			file = new FileReader("P67.txt");
			reader = new BufferedReader(file);
			
			String line = "";

			while ((line = reader.readLine()) != null) {
				strArr = line.split(" ");
				intArr[lineNum] = new int[strArr.length];

				for (int i = 0; i<strArr.length; i++){
					intArr[lineNum][i] = Integer.valueOf(strArr[i]);
					System.out.print(intArr[lineNum][i] + " ");
				}
				lineNum++;
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (file != null) {
				try {
				file.close();
				} catch (IOException e) {
					// Ignore issues during closing 
				}
			}
		}
		
		for (int i = 0; i<maxLines; i++ ){
			for (int j=0; j<intArr[i].length; j++){
				if (i>0){
					if (j == 0){
						intArr[i][j] += intArr[i-1][j];
					}
					else if (j == intArr[i].length-1){
						intArr[i][j] += intArr[i-1][j-1];
					}
					else{
						if (intArr[i-1][j-1] >= intArr[i-1][j]){
							intArr[i][j] += intArr[i-1][j-1];
						}
						else {
							intArr[i][j] += intArr[i-1][j]; 
						}
					}
				}
				System.out.print(intArr[i][j] + " ");
			}
			System.out.println();
		}
		int largest = 0;
		for (int j=0; j<intArr[maxLines-1].length; j++){
			if (intArr[maxLines-1][j] > largest){
				largest = intArr[maxLines-1][j];
			}
		}
		System.out.println(largest);
	}
}