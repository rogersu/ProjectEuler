package path;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
it cannot be solved by brute force, and requires a clever method! ;o)
*/

public class P18 {

	public void solve(){
		FileReader file = null;
		BufferedReader reader = null;
		int lineNum = 0;
		int[][] intArr = new int[15][];
		String[] strArr;
		
		try {
			file = new FileReader("P18.txt");
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
		
		for (int i = 0; i<15; i++ ){
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
		for (int j=0; j<intArr[14].length; j++){
			if (intArr[14][j] > largest){
				largest = intArr[14][j];
			}
		}
		System.out.println(largest);
	}
}
