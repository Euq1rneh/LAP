import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class  tests the methods in class Recursive
 * @author LabP team
 *
 */
public class TestsRecursive {

	// EOL represents whatever end-of-line symbol or symbols are used by a specific operating system
	public static final String EOL = System.getProperty("line.separator");
	
	// DELTA represents the required precision for calculated double values
	public static final double DELTA = 0.0001;

	@Test
	public void testHarmonicSum1 () {

		double obtained = Recursive.harmonicSum(14);
		double expected = 3.25156;
		assertEquals(expected, obtained, DELTA);
		
	}
	@Test
	public void testHarmonicSum2 () {
		double obtained = Recursive.harmonicSum(99);
		double expected = 5.1774;
		assertEquals(expected, obtained, DELTA);				
	}/*
	@Test 
	public void testContainedQuantity1() { 
		int obtained = Recursive.containedQuantity("12046511", "65");
		int expected = 11;
		assertEquals(expected, obtained);
	}
	
	@Test 
	public void testContainedQuantity2() { 
		
		int obtained = Recursive.containedQuantity("05046511120314203099", "30");
		int expected = 99;
		assertEquals(expected, obtained);
	}
*/
	@Test 
	public void testAllInInterval1() { 
		int[] v = {0, -7, 8, 2};
		boolean obtained = Recursive.allInInterval(v,-9, 20);
		boolean expected = true;
		assertEquals(expected, obtained);
	}

	@Test 
	public void testAllInInterval2() { 
		int[] v = {10, 6, -2, 30, 4};
		boolean obtained = Recursive.allInInterval(v,-9, 20);
		boolean expected = false;
		assertEquals(expected, obtained);
	}

	@Test 
	public void testSandwich1() { 
		int[] v = {0, -7, 8, 2};
		int[] obtained = Recursive.sandwich(v, 0, 1);
		int[] expected= {0,0,-7,1,8,0,2};
		assertArrayEquals(expected, obtained);
	}

	@Test 
	public void testSandwich2() { 
		int[] v = {10,20,30,40,50};
		int[] obtained = Recursive.sandwich(v, 0, 1);
		int[] expected= {10,0,20,1,30,0,40,1,50};
		assertArrayEquals(expected, obtained);
	}


	@Test 
	public void testMerge1() { 
		int[] v = {0,1,2,4,5};
		int[] w = {3};
		int[] obtained = Recursive.merge(v, w);
		int[] expected = {0,1,2,3,4,5};
		assertArrayEquals(expected, obtained);		
	}
	
	@Test 
	public void testMerge2() { 
		int[] v = {-6, -5, -3, 0, 2};
		int[] w = {-7, -4, 1};
		int[] obtained = Recursive.merge(v, w);
		int[] expected = {-7, -6, -5, -4, -3, 0, 1, 2};
		assertArrayEquals(expected, obtained);		
	}

	
	@Test
	public void testLucasNumber1 () {

		long obtained = Recursive.negativeLucasNumber(-3);
		long expected = -4L;
		assertEquals(expected, obtained);
	}
		
	@Test
	public void testLucasNumber2 () {

		long obtained = Recursive.negativeLucasNumber(-14);
		long expected = 843L;
		assertEquals(expected, obtained);
	}

}
