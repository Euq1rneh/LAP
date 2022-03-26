import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


class GameTestConstructor {

	public static final String EOL = System.getProperty("line.separator");

	@Test
	@Timeout(1000)
	void testGame() {
		
		Random generator = new Random(1);
		Game firstGame  = new Game(0, generator);
		
		String obtained = firstGame.toString();
		
		String expected = 
				  "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 0" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 1" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 2" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 3" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 4" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 5" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 6" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 7" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 8" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 9" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 10" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 11" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 12" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 13" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 14" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 15" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 16" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 17" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 18" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | _ | 19" + EOL
				  + "" + EOL
				  + "| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| " + EOL
				  + "" + EOL
				  + "Proxima Peca:" + EOL
				  + "_ B B " + EOL
				  + "B B B " + EOL
				  + "B _ _ " + EOL
				  + "" + EOL
				  + "Pontuacao actual:0" + EOL
				  + "";
		
		assertEquals(expected, obtained);
	}

	@Test
	@Timeout(1000)
	void testGame1() {
		
		Random generator = new Random(20);
		Game firstGame  = new Game(100, generator);
		
		String obtained = firstGame.toString();
		
		String expected = 
				  "| _ | _ | _ | _ | B | _ | _ | B | B | _ | _ | _ | 0" + EOL
				  + "| B | B | _ | _ | _ | B | _ | _ | B | B | B | _ | 1" + EOL
				  + "| B | _ | _ | _ | B | _ | B | _ | _ | _ | _ | B | 2" + EOL
				  + "| _ | _ | _ | B | B | _ | _ | _ | B | _ | B | _ | 3" + EOL
				  + "| B | _ | B | _ | B | _ | _ | _ | B | _ | _ | _ | 4" + EOL
				  + "| B | _ | _ | B | _ | B | B | _ | _ | _ | _ | B | 5" + EOL
				  + "| B | B | B | _ | _ | B | _ | _ | B | B | _ | B | 6" + EOL
				  + "| _ | _ | B | B | B | B | _ | _ | _ | _ | B | _ | 7" + EOL
				  + "| _ | _ | _ | B | _ | B | B | B | B | _ | B | _ | 8" + EOL
				  + "| B | B | _ | B | _ | _ | B | B | _ | B | _ | _ | 9" + EOL
				  + "| _ | _ | _ | _ | _ | B | B | _ | B | _ | _ | _ | 10" + EOL
				  + "| B | B | _ | B | B | _ | _ | _ | _ | _ | _ | B | 11" + EOL
				  + "| _ | _ | _ | _ | _ | _ | _ | B | _ | B | B | B | 12" + EOL
				  + "| _ | B | _ | B | B | _ | _ | _ | B | B | _ | _ | 13" + EOL
				  + "| _ | _ | _ | _ | _ | B | B | _ | _ | B | _ | B | 14" + EOL
				  + "| _ | _ | _ | _ | B | _ | _ | _ | B | B | B | _ | 15" + EOL
				  + "| B | _ | _ | _ | _ | B | B | _ | B | _ | _ | _ | 16" + EOL
				  + "| B | _ | B | B | B | B | B | B | B | B | _ | _ | 17" + EOL
				  + "| _ | B | _ | B | B | B | _ | B | _ | B | _ | B | 18" + EOL
				  + "| B | B | _ | _ | _ | _ | _ | _ | B | B | B | _ | 19" + EOL
				  + "" + EOL
				  + "| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| " + EOL
				  + "" + EOL
				  + "Proxima Peca:" + EOL
				  + "_ _ _ " + EOL
				  + "_ _ _ " + EOL
				  + "B B _ " + EOL
				  + "" + EOL
				  + "Pontuacao actual:100" + EOL
				  + "";
		
		assertEquals(expected, obtained);
	}
	
	
	@Test
	@Timeout(1000)
	void testGame2() {
		
		Random generator = new Random(30);
		Game firstGame  = new Game(240, generator);
		
		String obtained = firstGame.toString();
		
		String expected = 
				    "| B | B | B | B | B | B | B | B | B | B | B | B | 0" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 1" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 2" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 3" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 4" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 5" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 6" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 7" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 8" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 9" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 10" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 11" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 12" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 13" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 14" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 15" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 16" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 17" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 18" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 19" + EOL
				    + "" + EOL
				    + "| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| " + EOL
				    + "" + EOL
				    + "Proxima Peca:" + EOL
				    + "_ _ _ " + EOL
				    + "_ B B " + EOL
				    + "B B _ " + EOL
				    + "" + EOL
				    + "Pontuacao actual:240" + EOL
				    + "";
		
		assertEquals(expected, obtained);
	}
	
	@Test
	void testGame3() {
		
		Random generator = new Random(30);
		Game firstGame  = new Game(1000, generator);
		
		String obtained = firstGame.toString();
		
		String expected = 
				    "| B | B | B | B | B | B | B | B | B | B | B | B | 0" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 1" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 2" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 3" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 4" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 5" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 6" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 7" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 8" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 9" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 10" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 11" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 12" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 13" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 14" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 15" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 16" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 17" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 18" + EOL
				    + "| B | B | B | B | B | B | B | B | B | B | B | B | 19" + EOL
				    + "" + EOL
				    + "| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11| " + EOL
				    + "" + EOL
				    + "Proxima Peca:" + EOL
				    + "_ _ _ " + EOL
				    + "_ B B " + EOL
				    + "B B _ " + EOL
				    + "" + EOL
				    + "Pontuacao actual:240" + EOL
				    + "";
		
		assertEquals(expected, obtained);
	}
}
