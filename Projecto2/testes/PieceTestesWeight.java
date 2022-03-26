import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PieceTestesWeight {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	public static final String EOL = System.getProperty("line.separator");

	
	@Test
	void testweight1() {

		Cell[][] cells1 = {{B,B,B},	
						{F,B,F},	
						{F,F,F}};
		
		Piece piece1 = new Piece(cells1);
		
		
		int expected = 4;
		
		int obtained = piece1.weight();
		
		assertEquals(expected,obtained);
	}
	
	@Test
	void testweight2() {

		Cell[][] cells1 = {	{B,F,F},	
							{B,F,F},	
							{B,B,F}};
		
		Piece piece1 = new Piece(cells1);
		
		
		int expected = 4;
		
		int obtained = piece1.weight();
		
		assertEquals(expected,obtained);
	}
	
	@Test
	void testweight3() {

		Piece piece1 = new Piece(B);
		
		
		int expected = 9;
		
		int obtained = piece1.weight();
		
		assertEquals(expected,obtained);
	}

	@Test
	void testweight4() {

		Piece piece1 = new Piece(F);
		
		
		int expected = 0;
		
		int obtained = piece1.weight();
		
		assertEquals(expected,obtained);
	}

}
