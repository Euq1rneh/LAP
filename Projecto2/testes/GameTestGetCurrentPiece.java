import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class GameTestGetCurrentPiece {

	public static final String EOL = System.getProperty("line.separator");


	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;

	@Test
	void testPiece() {
		
		Random generator = new Random(30);
		Game firstGame  = new Game(240, generator);
		
		Piece obtained = firstGame.getCurrentPiece();
		
		Cell[][] cell1 = {{F,F,F},	
				{F,B,B},	
				{B,B,F}};
		

		Piece expected = new Piece(cell1);
		
		assertTrue(expected.isEqual(obtained));
	}

	

}
