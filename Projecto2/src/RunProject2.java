import java.util.Random;
import java.util.Scanner;

/**
 * This class allows to play the LabP em Blocos game
 * @author LabP
 * March 11th 2022
 */
public class RunProject2 {
	static final int N_LINES = 9;
	static final int N_COLUMNS = 9;

	/**
	 * An instance of the Game class is created after asking the player
	 * for some information and used to play the LabP-em-Blocos game
	 * @param args Not used
	 */
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Escolha um número que vai servir de semente "
				+ "para um gerador de aleatórios.");
		int randomSeed = reader.nextInt();
		Random generator = new Random(randomSeed);
		
		System.out.println("Escolha o grau de dificuldade");
		System.out.println("(corresponde ao "
				+ "número de casas do tabuleiro que começam já ocupadas - "
				+ "máximo " + N_LINES * N_COLUMNS + ").");
		int dificulty = reader.nextInt();

		Game firstGame  = new Game(N_LINES, N_COLUMNS, dificulty, generator);
		System.out.println(firstGame.toString());

		while(!firstGame.isFinished()) {

			String operacao = null;

			do {

				System.out.println("Quer rodar (R), "
						+ "reflectir verticalmente (V) ou "
						+ "reflectir horizontamente (H) a peça?"
						+ " Escreva N se nao pretender mexer.");
				operacao= reader.next();

				apply(operacao, firstGame);

				System.out.println(firstGame.getCurrentPiece());
				
			} while(!operacao.equals("N"));
			
			System.out.println("Escolha agora a linha (entre 1 e " + 
			        N_LINES + ") e a coluna (entre 1 e " + N_COLUMNS +
				    ") da posição onde quer jogar");

			int linha = reader.nextInt();
			int coluna = reader.nextInt();

			firstGame.play(linha, coluna);

			System.out.println(firstGame.toString());
		}

		System.out.println("Game over. "
				+ "O seu Score foi: " + firstGame.getScore());

		reader.close();
	}

	/**
	 * Applies a given operation to the current piece of a given game.
	 * If the operation is not R, H or V, it does nothing.
	 * @param operacao The operation to apply to the current piece or N
	 * @param firstGame The game
	 */
	private static void apply(String operacao, Game firstGame) {
		switch (operacao) {
		case "R": {
			firstGame.rotatePiece(1);
			break;
		}
		case "H": {
			firstGame.flipHorizontal();
			break;
		}
		case "V": {
			firstGame.flipVertical();
			break;
		}
		default:
			break;
		}
	}

}
