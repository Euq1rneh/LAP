import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PieceTestesEncaixa {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;
	
	public static final String EOL = System.getProperty("line.separator");

	
	@Test
	void testJunta1() {

		Cell[][] cells1 = {{B,B,B},	
						{F,B,F},	
						{F,F,F}};
		
		Cell[][] cells2 = {{F,F,F},	
						{B,F,B},	
						{B,B,B}};
		
		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);
		
		Cell[][] all = {{B,B,B},	
				{B,B,B},	
				{B,B,B}};
		
		Piece expected = new Piece(all);
		
		Piece obtained = piece1.merge(piece2);
		
		assertTrue(expected.isEqual(obtained));
	}
	
	@Test
	void testJunta2() {

		Cell[][] cells1 = {	{B,F,F},	
							{B,F,F},	
							{B,B,F}};
		
		Cell[][] cells2 = {	{F,B,B},	
							{F,B,B},	
							{F,F,B}};
		
		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);
		
		Cell[][] all = {{B,B,B},	
				{B,B,B},	
				{B,B,B}};
		
		Piece expected = new Piece(all);
		
		Piece obtained = piece1.merge(piece2);
		
		assertTrue(expected.isEqual(obtained));
	}
	
	@Test
	void testJunta3() {

		Cell[][] cells1 = {	{B,F,B},	
							{F,B,F},	
							{B,F,B}};
		
		Cell[][] cells2 = {	{F,B,F},	
							{B,F,B},	
							{F,B,F}};
		
		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);
		
		Cell[][] all = {{B,B,B},	
				{B,B,B},	
				{B,B,B}};
		
		Piece expected = new Piece(all);
		
		Piece obtained = piece1.merge(piece2);
		
		assertTrue(expected.isEqual(obtained));
	}

	@Test
	void testJunta4() {

		Cell[][] cells1 = {	{B,F,F},	
							{F,F,B},	
							{B,F,F}};
		
		Cell[][] cells2 = {	{F,B,F},	
							{B,F,F},	
							{F,B,F}};
		
		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);
		
		Cell[][] all = {{B,B,F},	
				{B,F,B},	
				{B,B,F}};
		
		Piece expected = new Piece(all);
		
		Piece obtained = piece1.merge(piece2);
		
		assertTrue(expected.isEqual(obtained));
	}

}
