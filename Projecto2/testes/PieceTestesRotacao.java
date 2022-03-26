import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PieceTestesRotacao {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	
	@Test
	void testRotate901() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.rotate90();

		Cell[][] rotatedL = {	{B,B,B},	
								{B,F,F},	
								{F,F,F}};
				
		Piece expected = new Piece(rotatedL); 		

		assertTrue(expected.isEqual(obtained));
	}
	
	@Test
	void testRotate902() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.rotate90();
		obtained.rotate90();

		Cell[][] rotatedL = {	{F,B,B},	
								{F,F,B},	
								{F,F,B}};
				
		Piece expected = new Piece(rotatedL); 		

		assertTrue(expected.isEqual(obtained));
	}

	@Test
	void testRotate904() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.rotate90();
		obtained.rotate90();
		obtained.rotate90();
		obtained.rotate90();

				
		Piece expected = new Piece(l); 		

		assertTrue(expected.isEqual(obtained));
	}
	
	
	
	
}
