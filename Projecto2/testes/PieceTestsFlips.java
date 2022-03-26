import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PieceTestsFlips {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	
	
	@Test
	void testFilpVertical1() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.flipVertical();

		Cell[][] fliped = {	{F,F,B},
								{F,F,B},	
								{F,B,B}};
				
		Piece expected = new Piece(fliped); 		

		assertTrue(expected.isEqual(obtained));
	}
	
	@Test
	void testFilpVertical2() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.flipVertical();
		obtained.flipVertical();

		Cell[][] fliped = {{B,F,F},	
							 {B,F,F},	
							 {B,B,F}};
				
		Piece expected = new Piece(fliped); 		

		assertTrue(expected.isEqual(obtained));
	}

	@Test
	void testFilpHorizontal1() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.flipHorizontal();

		Cell[][] fliped = {{B,B,F},	
							 {B,F,F},	
							 {B,F,F}};
				
		Piece expected = new Piece(fliped); 		

		assertTrue(expected.isEqual(obtained));
	}
	
	@Test
	void testFilpHorizontal2() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		obtained.flipHorizontal();
		obtained.flipHorizontal();

		Cell[][] fliped = {{B,F,F},	
							 {B,F,F},	
							 {B,B,F}};
				
		Piece expected = new Piece(fliped); 		

		assertTrue(expected.isEqual(obtained));
	}
	
	@Test
	void testFlipHorizontal3() {

		Cell[][] l = {{F,F,B},	
						{B,B,B},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		
		obtained.flipHorizontal();

		Cell[][] fliped = {{B,B,F},	
							{B,B,B},	
							 {F,F,B}};
				
		Piece expected = new Piece(fliped); 		

		assertTrue(expected.isEqual(obtained));
	}
	
	
	
}
