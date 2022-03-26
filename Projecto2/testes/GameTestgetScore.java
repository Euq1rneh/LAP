import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class GameTestgetScore {

	

	@Test
	void testGetScore1() {

		Random generator = new Random(2);

		Game game  = new Game(0, generator);

		game.play(1, 1);
		
		int obtained = game.getScore();
		int expected = 4;
		
		assertEquals(expected, obtained);
	}

	@Test
	void testGetScore2() {

		Random generator = new Random(48);

		Game game  = new Game(0, generator);

		game.play(1, 1);
		
		game.flipHorizontal();
		
		game.play(1, 1);
		
		
		int obtained = game.getScore();
		int expected = 8;
		
		assertEquals(expected, obtained);
	}
	

	@Test
	void testGetScore3() {

		Random generator = new Random(48);

		Game game  = new Game(20, generator);

		
		int obtained = game.getScore();
		int expected = 20;
		
		assertEquals(expected, obtained);
	}
	
	
	@Test
	void testGetScore4() {
		
		Random generator = new Random(48);

		Game game  = new Game(0, generator);
		
		
		int obtained = game.getScore();
		int expected = 0;
		
		assertEquals(expected, obtained);
	}
	
}
