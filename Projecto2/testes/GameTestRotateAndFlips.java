import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class GameTestRotateAndFlips {

	public static final String EOL = System.getProperty("line.separator");


	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;


	@Test
	void testRotatePiece() {
		
		Random generator = new Random(20);
		Game firstGame  = new Game(20, generator);
		
		firstGame.rotatePiece(2);
		
		Piece obtained = firstGame.getCurrentPiece();
		
		Cell[][] cell1 = {{B,B,B},	
				{F,F,B},	
				{B,F,F}};
		
		Piece expected = new Piece(cell1);
		
		
		assertTrue(expected.isEqual(obtained));
		
	}

	@Test
	void testFlipHorizontal() {
		Random generator = new Random(20);
		Game firstGame  = new Game(240, generator);
		
		firstGame.flipHorizontal();
		
		Piece obtained = firstGame.getCurrentPiece();
		
		Cell[][] cell1 = {{F,F,B},	
				{F,F,B},	
				{F,F,B}};
		

		Piece expected = new Piece(cell1);
		
		
		assertTrue(expected.isEqual(obtained));
		
		
	}

	@Test
	void testFlipVertical() {
		Random generator = new Random(20);
		Game firstGame  = new Game(20, generator);
		
		firstGame.flipVertical();
		
		Piece obtained = firstGame.getCurrentPiece();
		
		
		
		Cell[][] cell1 = {{B,F,F},	
				{F,F,B},	
				{B,B,B}};
		
		Piece expected = new Piece(cell1);
		
		
		assertTrue(expected.isEqual(obtained));
	}


}
