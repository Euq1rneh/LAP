import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class GameTestFazJogada {

	public static final String EOL = System.getProperty("line.separator");

	@Test
	void testFazJogadaFalse() {


		Random generator = new Random(2);


		Game game  = new Game(0, generator);

		game.play(1, 1);

		game.play(1,1);


		boolean expected = true;

		boolean obtained = game.isFinished();


		assertEquals(expected, obtained);
	}


	@Test
	void testFazJogadaTrueDirect() {


		Random generator = new Random(3);


		Game game  = new Game(0, generator);

		game.play(1, 1);

		game.play(1,2);

		int expected = 8;

		int obtained = game.getScore();


		assertEquals(expected, obtained);
	}

	@Test
	void testFazJogadaTrueRotate90() {


		Random generator = new Random(4);


		Game game  = new Game(0, generator);

		game.play(1, 1);

		game.rotatePiece(1);

		game.play(1,2);


		int expected = 7;

		int obtained = game.getScore();


		assertEquals(expected, obtained);
	}

	@Test
	void testFazJogadaTrueFlipHorizontal() {


		Random generator = new Random(48);


		Game game  = new Game(0, generator);

		game.play(1, 1);



		game.flipHorizontal();

		game.play(1,1);

		int expected = 8;

		int obtained = game.getScore();



		assertEquals(expected, obtained);
	}

	@Test
	void testFazJogadaTrueFlipHorizontalPlusRotation90() {


		Random generator = new Random(78);


		Game game  = new Game(0, generator);

		game.play(1, 1);

		game.flipHorizontal();
		game.rotatePiece(1);

		game.play(1,1);

		int expected = 7;

		int obtained = game.getScore();



		assertEquals(expected, obtained);
	}

}
