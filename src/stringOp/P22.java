package stringOp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over 
five-thousand first names, begin by sorting it into alphabetical order. Then working out the
alphabetical value for each name, multiply this value by its alphabetical position in the list 
to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, 
is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

public class P22 {
	
	public void solve(){
		FileReader file = null;
		BufferedReader reader = null;
		String[] nameString = null;
		TreeSet<String> nameArray = new TreeSet<String>();
		int sum = 0;
		
		try {
			file = new FileReader("P22.txt");
			reader = new BufferedReader(file);
			
			String line = "";

			while ((line = reader.readLine()) != null) {
				nameString = line.split(",");
				//System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String s: nameString){
			String temp = s.substring(1, s.length()-1);
			nameArray.add(temp);
		}
				
		int i = 1;
		for (String s: nameArray){
			int score = getNameValue(s);
			System.out.println(s + " " + score + " " + i);
			sum += i++ * score;
		}
		System.out.println("Sum: " + sum);
	}
	
	public int getNameValue(String s){
		int sum = 0;
		for (char c: s.toCharArray()){
			sum += c - 64;
		}
		return sum;
	}
}
