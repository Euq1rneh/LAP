import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PieceTestesMerge {

	Cell F = Cell.FREE;
	Cell B = Cell.BUSY;


	@Test
	void testEncaixa1() {

		Cell[][] cells1 = {{B,B,B},	
				{F,B,F},	
				{F,F,F}};

		Cell[][] cells2 = {{F,F,F},	
				{B,F,B},	
				{B,B,B}};

		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);


		Boolean expected = true;

		Boolean obtained = piece1.fits(piece2);

		assertEquals(expected, obtained);
	}

	@Test
	void testEncaixa2() {

		Cell[][] cells1 = {	{B,F,F},	
				{B,F,F},	
				{B,B,F}};

		Cell[][] cells2 = {	{F,B,B},	
				{F,B,B},	
				{F,F,B}};

		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);

		Boolean expected = true;

		Boolean obtained = piece1.fits(piece2);

		assertEquals(expected, obtained);
	}

	@Test
	void testEncaixa3() {

		Cell[][] cells1 = {	{B,F,B},	
				{F,B,F},	
				{B,F,B}};

		Cell[][] cells2 = {	{F,B,F},	
				{B,F,B},	
				{F,B,F}};

		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);

		Boolean expected = true;

		Boolean obtained = piece1.fits(piece2);

		assertEquals(expected, obtained);
	}

	@Test
	void testEncaixa4() {

		Cell[][] cells1 = {	{B,F,F},	
				{F,F,B},	
				{B,F,F}};

		Cell[][] cells2 = {	{F,B,F},	
				{B,F,F},	
				{F,B,F}};

		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);

		Boolean expected = true;

		Boolean obtained = piece1.fits(piece2);

		assertEquals(expected, obtained);
	}
	
	@Test
	void testEncaixa5() {

		Cell[][] cells1 = {	{F,F,F},	
				{F,F,F},	
				{B,F,F}};

		Piece piece1 = new Piece(cells1);

		Boolean expected = false;

		Boolean obtained = piece1.fits(piece1);

		assertEquals(expected, obtained);
	}
	
	@Test
	void testEncaixa6() {

		Cell[][] cells1 = {	{F,F,F},	
				{F,F,F},	
				{B,F,F}};
		
		Cell[][] cells2 = {	{B,B,B},	
				{B,B,B},	
				{F,B,B}};

		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);

		Boolean expected = true;

		Boolean obtained = piece1.fits(piece2);

		assertEquals(expected, obtained);
	}
	
	@Test
	void testEncaixa7() {

		Cell[][] cells1 = {	{F,F,F},	
				{F,B,F},	
				{F,F,F}};
		
		Cell[][] cells2 = {	{B,B,B},	
				{B,B,B},	
				{F,B,B}};

		Piece piece1 = new Piece(cells1);
		Piece piece2 = new Piece(cells2);

		Boolean expected = false;

		Boolean obtained = piece1.fits(piece2);

		assertEquals(expected, obtained);
	}

}
