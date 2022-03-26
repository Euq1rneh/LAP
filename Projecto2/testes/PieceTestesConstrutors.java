import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PieceTestesConstrutors {

	public static final String EOL = System.getProperty("line.separator");

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	
	
	@Test
	void testToString() {

		Cell[][] l = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece piece = new Piece(l);
		
		String obtained = piece.toString();
		
		String expected = "B _ _ " + EOL
				+ "B _ _ " + EOL
				+ "B B _ " + EOL;
		
		assertEquals(expected,obtained);
	}
	
	
}
