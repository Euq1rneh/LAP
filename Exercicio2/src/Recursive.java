/**
 * This class implements recursive methods
 * @author Henrique Marques 57153
 *
 */

public class Recursive {
	
	/**
	 * Calculates the hamonic sum of the first k elements
	 * @param k	the k-th term
	 * @return	the harmonic sum of k elements
	 * @requires {@code k > 0}
	 */
	public static double harmonicSum(int k) {
		double sum = 0;
		if(k < 1)
			return sum;
		return harmonicSumAux(sum, k);
	}
	
	/**
	 * Calculates the hamonic sum of the first k elements
	 * @param sum harmonic sum of k elements
	 * @param k the k-th term
	 * @return the harmonic sum of k elements
	 * @requires {@code k > 0}
	 */
	private static double harmonicSumAux(double sum, int k ) {
		if(k < 1)
			return sum;
		return harmonicSumAux(sum + (double)1/k, k-1);
	}
	
	/**
	 * Gets the amount of a certain product according to a product code and box code
	 * @param boxCode		the box code
	 * @param productCode	the product code
	 * @return  the amount of a certain product that is inside a particular box
	 * @requires {@code boxCode.length() >= 4 && productCode.length() == 2}
	 */
	public static int containedQuantity(String boxCode, String productCode) {
		if(boxCode.indexOf(productCode) == -1)
			return 0;
		return containedQuantityAux(boxCode, productCode, 0);
	}
	/**
	 * Gets the amount of a certain product according to a product code and box code
	 * @param boxCode		the box code
	 * @param productCode	the product code
	 * @param index			the current index to check
	 * @return the amount of a certain product that is inside a particular box
	 * @requires {@code boxCode.length() >= 4 && productCode.length() == 2}
	 */
	private static int containedQuantityAux(String boxCode, String productCode, int index) {
		if(index >= boxCode.length())
			return 0;
		if(boxCode.charAt(index) == productCode.charAt(0) && boxCode.charAt(index+1) == productCode.charAt(1))
			return Integer.parseInt(boxCode.charAt(index+2) +""+ boxCode.charAt(index+3));
		
		return containedQuantityAux(boxCode, productCode, index+1);
	}
	/**
	 * Checks if all the elements of an array are between or are equal to two numbers
	 * @param values	the array of values
	 * @param x			lower limit
	 * @param y			upper limit
	 * @return	true if elements are in the interval false otherwise
	 */
	public static boolean allInInterval(int[] values, int x, int y) {
		if(values.length == 1)
			return values[0] >= x && values[0] <= y;
			
		return allInIntervalAux(values, x, y, true, 0);
	}

	/**
	 * Checks if all the elements of an array are between or are equal to two numbers
	 * @param values	the array of values
	 * @param x			lower limit
	 * @param y			upper limit
	 * @param result	the current result
	 * @param acc		counter to advance the index
	 * @return true if elements are in the interval false otherwise
	 */
	private static boolean allInIntervalAux(int[] values, int x, int y, boolean result, int index) {
		
		if(values.length == 2)
			return result && values[1] >= x && values[1] <= y;
		if(index >= values.length)
			return result;
		
		return allInIntervalAux(values, x, y, result && values[index] >= x && values[index] <= y, index+1);
	}
	
	/**
	 * Adds elements in between every two values of an array alternating between two values
	 * @param v	the array
	 * @param a	first element to add
	 * @param b	second element to add
	 * @return	array with new elements
	 */
	public static int[] sandwich(int[] v, int a, int b) {
		if(v.length == 1)
			return v;
		if(v.length == 2) {
			return new int[] {v[0], a, v[1]};
		}
		
		return sandwichAux(v, new int[2*v.length-1], a, b, 0, 0);
	}

	/**
	 * Adds elements in between every two values of an array alternating between two values
	 * @param v 		the array
	 * @param newV 		new array
	 * @param a 		first element to add
	 * @param b			second element to add
	 * @param value		the value to alter
	 * @param acc		counter to advance the index
	 * @return array with new elements
	 */
	private static int[] sandwichAux(int[] v, int[] newV, int a, int b,  int value, int acc) {
		if(v.length == 3)
			return new int[]{v[0], a, v[1], b, v[2]};

		if(acc >= newV.length)
			return newV;
		
		if(acc % 2 == 0 || acc == 0)
			return sandwichAux(v, newV, a, b, newV[acc] = v[acc/2], acc+1);
		
		return sandwichAux(v, newV, b, a, newV[acc] = a, acc+1);
	}
	
	/**
	 * Merges two arrays and sorts the resulting array
	 * @param v an array
	 * @param w an array
	 * @return a sorted array
	 * @requires {@code v.length >= 1 || w.length >= 1}
	 */
	public static int[] merge(int[] v, int[] w) {
		
		if(v.length == 1 && w.length == 1 && v[0] >= w[0])
			return new int[] {w[0], v[0]};
		if(v.length == 1 && w.length == 1 && w[0] >= v[0])
			return new int[] {v[0], w[0]};
		
		int[]merged = new int[v.length+w.length];
		for(int i = 0; i< v.length; i++)
			merged[i] = v[i];
		for(int j = 0; j<w.length; j++) {
			merged[j+v.length-1] = w[j];
		}
		return sort(merged, merged.length);
	}

	/**
	 * Sorts the elements of an array
	 * @param merged	the array to sort
	 * @param counter	counter
	 * @return	sorted array
	 */
	private static int[] sort(int[] merged, int counter) {
		if(counter == 1)
			return merged;
		for(int i = 0; i<counter-1; i++) {
			
			if(merged[i] > merged[i+1]) {
				int tempValue = merged[i+1];
				merged[i+1] = merged[i];
				merged[i] = tempValue;
			}
		}
		return sort(merged, counter-1);
	}
	
	/**
	 * Calculates the n-th negative Lucas number
	 * @param n	the element to calculate
	 * @return	the n-th negative Lucas number
	 * @requires {@code n <= 0}
	 */
	public static long negativeLucasNumber(int n) {
		if(n == 0)
			return 2;
		if(n == -1)
			return -1;
		
		return negativeLucasNumberAux(2, -1, n);
	}
	
	/**
	 * Calculates the n-th negative Lucas number
	 * @param a the n-2 element
	 * @param b	the n-1 element
	 * @param n	the n-th element
	 * @return	the n-th negative Lucas number
	 * @requires {@code n <= 0}
	 */
	private static long negativeLucasNumberAux(int a, int b, int n) {
		if(n == -1)
			return b;
		
		return negativeLucasNumberAux(b, a-b, n+1);
	}
	
}
