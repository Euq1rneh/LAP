import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class PieceTestesIsEqual {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	
	@Test
	void testIsEqual1() {

		Random generator = new Random(2);
		
		Piece piece = new Piece(generator);
		
		Cell[][] l = {{F,B,F},	
						{B,B,F},	
						{F,B,F}};
		
		Piece ele = new Piece(l);
		
		
		assertTrue(piece.isEqual(ele));
	}
	
	@Test
	void testIsEqual2() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece obtained = new Piece(l);
		
		l[0][1] = B;
		
		Piece expected = new Piece(l);
		
		
		assertFalse(obtained.isEqual(expected));
	}
	
		
}
