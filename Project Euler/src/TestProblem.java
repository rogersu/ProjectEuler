import factors.*;
import largeNumber.*;
import path.*;
import primes.*;
import stringOp.*;

public class TestProblem {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		new P28().solve();
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime + "ms");
		
	}

}
