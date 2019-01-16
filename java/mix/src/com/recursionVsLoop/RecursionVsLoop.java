import java.text.DecimalFormat;

/**
 * App for testing recursion on factorial (mathematic)
 * by measuring time of operations in [ns]
 * 
 * @result
 * not get stack overflow error by recursion calc. method
 *
 */

public class RecursionVsLoop {
	private static double numb = 5000;	//25 is max value for long type of factorial
	
	public static void main(String[] args){
		
		/** Create new object for non static constructors */
		RecursionVsLoop rek = new RecursionVsLoop();
		
		/** Measure time start/end of calc. by recursion */
		double startRecursion = System.nanoTime();
		System.out.println("Factorial of number " +numb+ " calc. by RECURSION equals: " +(long) rek.factorialByRecursion(numb));
		double timeRecursion = System.nanoTime() - startRecursion;
		System.out.println("Time of above operation: " +timeRecursion+ " [ns]\n");
		
		/** Measure time start/end of calc. by loop */
		double startLoop = System.nanoTime();
		System.out.println("Factorial of number " +numb+ " calc. by LOOP equals: " +(long) rek.factorialByLoop(numb));
		double timeLoop = System.nanoTime() - startLoop;
		System.out.println("Time of above operation: " +timeLoop+ " [ns]\n");
		
		/** Difference between above times with formatter */
		double diff = timeRecursion/timeLoop;
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println("Difference in times by division them: " +df.format(diff)+ "x");
		
	}
	
	private double factorialByRecursion(double n){
		double result;
		
		if(n==0){
			return 1;	//when loop goes down to n=0
		}
		result = n * factorialByRecursion(n-1);
		
		return result;
	}
	
	private double factorialByLoop(double n){
		double result = n;
		
		for(double i = n-1; i > 1; i--){
			result = result * i;
		}
		
		return result;
	}
	
}
