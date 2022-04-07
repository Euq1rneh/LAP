import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Executes some simple calls of the functions defined in class Recursive
 * 
 * @author LabP Team
 *
 **/
public class RunRecursive {
	
	/**
	 * Executes some calls to test the functions of the class Recursive
	 * @throws FileNotFoundException 
	 *  
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter out = new PrintWriter("output.txt");
		
		int naturalNumber = 10;
		double sum = Recursive.harmonicSum(naturalNumber);
		out.println("harmonicSum("+ naturalNumber+ ") = "+ sum );
				
		String boxCode = "0409465005111201";
		String prodCode = "05";
		int quant = Recursive.containedQuantity(boxCode, prodCode);
		out.println("containedQuantity(\""+  boxCode + "\", \"" + prodCode + "\") = "+ quant);

		int[] values1 = {5, -7, 3, 5, 10, -11, 14, 3};
		int x1 = 14;
		boolean allIn = Recursive.allInInterval(values1, -x1, x1) ;
		out.println("Are all the values in array "+ Arrays.toString(values1)+ 
				" in the interval [" + (-x1) + " .. " + x1 + "] ?");
		out.println("    " + allIn );
		
		int[] values2 = {1, 2, 3, 4, 5, 6};
		int x2 = 10;
		int[] result = Recursive.sandwich(values2, x2, -x2);
		out.println("The sandwich of array "+ Arrays.toString(values2)+ " with " + 
				x2 + " and " + (-x2) + " is the array:");
		out.println("    " +  Arrays.toString(result) );
		
		int[] values3 = {-11, -7, 3, 3, 5, 5, 10, 14 };
		result = Recursive.merge(values2, values3);
		out.println("The merge of array "+ Arrays.toString(values2)+ " with array " + 
				Arrays.toString(values3) + " is the array: ");
		out.println("    " +  Arrays.toString(result) );
		
		long n = Recursive.negativeLucasNumber( - 5);
		out.println("negativeLucasNumber("+  (-5) + ") = "+ n );
		
		
		out.close();
		
		}
}
	
