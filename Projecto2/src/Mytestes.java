import java.util.Random;

public class Mytestes {
	public static final String EOL = System.getProperty("line.separator");
	public static void main(String[] args) {
		Random generator = new Random(30);
		Game firstGame  = new Game(240, generator);
		
		System.out.print(firstGame.toString());
	}

}
