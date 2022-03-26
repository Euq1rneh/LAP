import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PieceTestesgetCells {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	
	
	@Test
	void testGetCells1() {

		Cell[][] cell1 = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece piece1 = new Piece(cell1);
		
		
		String expected = "B__B__BB_";
		
		Cell[][] cells = piece1.getCells();
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				res.append(cells[i][j]);
			}
		}
		String obtained = res.toString();
		
		
		
		assertEquals(expected,obtained);
	}
	
	@Test
	void testGetCells2() {

		Cell[][] cell1 = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece piece1 = new Piece(cell1);
		
		cell1[0][0] = F;
		
		String expected = "B__B__BB_";
		
		Cell[][] cells = piece1.getCells();
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				res.append(cells[i][j]);
			}
		}
		String obtained = res.toString();
		
		
		
		assertEquals(expected,obtained);
	}
	
	@Test
	void testGetCells3() {

		Cell[][] cell1 = {{B,F,F},	
						{B,F,F},	
						{B,B,F}};
		
		Piece piece1 = new Piece(cell1);
		
		
		String expected = "B__B__BB_";
		
		Cell[][] cells = piece1.getCells();
		
		cells[0][0] = Cell.FREE;
		
		Cell[][] cellsAfter = piece1.getCells();
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < cellsAfter.length; i++) {
			for (int j = 0; j < cellsAfter[i].length; j++) {
				res.append(cellsAfter[i][j]);
			}
		}
		String obtained = res.toString();
		
		
		
		assertEquals(expected,obtained);
	}
	
}
