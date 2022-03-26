import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class PieceTestesConstructors {

	
	public static final String EOL = System.getProperty("line.separator");
	
	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	
	
	@Test
	void testConstructor1() {

		Cell[][] cell1 = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece piece1 = new Piece(cell1);
		
		
		cell1[0][0] = F;
		
		String expected = "B _ _ " + EOL
				+ "B _ _ " + EOL
				+ "B B _ " + EOL;
		
		String obtained = piece1.toString();
		
		
		assertEquals(expected,obtained);
	}
	
	@Test
	void testConstructor2() {

		
		Piece piece1 = new Piece(B);
		
		String expected = "B B B " + EOL
				+ "B B B " + EOL
				+ "B B B " + EOL
				;
		
		String obtained = piece1.toString();
		
		
		assertEquals(expected,obtained);
	}
	
	@Test
	void testConstructor3() {

		
		Piece piece1 = new Piece(F);
		
		String expected = "_ _ _ " + EOL
				+ "_ _ _ " + EOL
				+ "_ _ _ " + EOL
				;
		
		String obtained = piece1.toString();
		
		
		assertEquals(expected,obtained);
	}
	
	
	@Test
	void testConstructor4() {

		Random generator = new Random(1);
		
		Piece piece1 = new Piece(generator);
		
		String expected = "_ B B " + EOL
				+ "B B B " + EOL
				+ "B _ _ " + EOL
				;
		
		String obtained = piece1.toString();
		
		
		assertEquals(expected,obtained);
	}
	
}
