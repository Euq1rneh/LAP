import java.util.Random;
/**
 * 
 * This class implements a Game of Blocos
 * @author Henrique Marques fc57153
 *
 */
public class Game {
	
	private Random pieceGenerator;
	private int score;
	private Cell[][] board;
	private Piece currentPiece;
	private boolean isFinished;
	private final Piece nullPiece = new Piece(Cell.FREE);
	
	/**
	 * Creates a new instance o the game with a given number spaces filled in
	 * @param dificuldade the number of spaces that will be filled in
	 * @param generator	  the random generator
	 */
	public Game(int dificuldade, Random generator) {
		isFinished = false;
		pieceGenerator = generator;
		board = new Cell[20][12];
		score = dificuldade;
		InitializeBoardValues(dificuldade);
		currentPiece = new Piece(pieceGenerator);
	}

	/**
	 * Creates a new instance of the game with a specific size and number of spaces filled in
	 * @param linhas		the number of rows
	 * @param colunas		the number of columns
	 * @param dificuldade	the number of spaces that will be filled in
	 * @param generator		random generator for the pieces
	 */
	public Game(int linhas, int colunas, int dificuldade, Random generator) {
		isFinished = false;
		pieceGenerator = generator;
		board = new Cell[linhas][colunas];
		score = dificuldade;
		InitializeBoardValues(dificuldade);
		currentPiece = new Piece(pieceGenerator);
	}

	/**
	 * Gets the current piece
	 * @return	the current piece
	 */
	public Piece getCurrentPiece() {
		return currentPiece.copy();
	}

	/**
	 * Checks if the game has finished.
	 * A game is considered to be finished if the board is full 
	 * or the current piece does not fit anywhere
	 * @return true is the game has ended false otherwise
	 */
	public boolean isFinished() {
		return isFinished;
	}

	/**
	 * Rotates thet piece by 90 degrees a given number of times
	 * @param n the number of times that the piece is rotated
	 */
	public void rotatePiece(int n) {
		for(int i = 0; i < n; i++) {
			currentPiece.rotate90();
		}
	}

	/**
	 * Flips the current piece horizontally
	 */
	public void flipHorizontal() {
		currentPiece.flipHorizontal();
	}

	/**
	 * Flips the current piece vertically
	 */
	public void flipVertical() {
		currentPiece.flipVertical();
	}

	/**
	 * Returns a textual representation of the current state of the game
	 */
	@Override
	public String toString() {
		StringBuilder currentBoard = new StringBuilder();
		
		for (int i = 0; i< board.length; i++) {
			for (int j = 0; j<board[i].length; j++) {
				
				if(j == 0)
					currentBoard.append("| ");					
				else 
					currentBoard.append(" | ");
				
				currentBoard.append(board[i][j].toString());
				
				
				if(j == board[i].length-1) {
					currentBoard.append(" | ");
					currentBoard.append(i);
				}
			}
			currentBoard.append("\n");
		}
		currentBoard.append("\n");
		for(int k = 0; k < board.length; k++) {
			currentBoard.append("| "+k +" ");
		}
		currentBoard.append("| \n"
				+ "\n\nProxima Peca:\n"+currentPiece.toString()
				+"\nPontuacao actual:"+score+"\n");
		
		return currentBoard.toString();
	}

	/**
	 * Tries to fit a piece in the board using the center of that piece
	 * @param linha		the Y coordinate of the center in the board
	 * @param coluna	the X coordinate of the center in the board
	 */
	public void play(int linha, int coluna) {
		
		Piece pieceToCheck = MakePiece(linha, coluna);
		
		if(linha == 0 || linha == board.length-1 
		|| coluna == 0 || coluna == board.length-1 
		|| !pieceToCheck.fits(currentPiece))
			
			isFinished = true;
		else {
			score+= currentPiece.weight();
			currentPiece.merge(pieceToCheck);
			// change board
			ChangeBoard(linha, coluna);
			//no final gerar nova peca
			currentPiece = new Piece(pieceGenerator);
		}
	}


	/**
	 * Gets the current score, which is calculated by the number of filled spaces
	 * @return	the current score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Initializes the boards values according to a certain difficulty 
	 * <b>(the higher the number, more spaces will be filled)</b>.
	 * If the difficulty is bigger than the number of spaces available the game will automatically end
	 * @param dificuldade the number of spaces that will be filled
	 */
	private void InitializeBoardValues(int dificuldade) {
		int centerY, centerX;
		// if dificuldade >= width*height
		if(dificuldade >= board.length*board[0].length) {
			for (int i = 0; i< board.length; i++) {
				for (int j = 0; j<board[i].length; j++) {
					board[i][j] = Cell.BUSY;
				}
			}
			isFinished = true;
		}else {
			while(dificuldade > 0) {
				centerY = pieceGenerator.nextInt(board.length-2)+1;
				centerX = pieceGenerator.nextInt(board[0].length-2)+1;
				
				// if it picks the same position
				while(board[centerY][centerX] == Cell.BUSY) {
					centerY = pieceGenerator.nextInt(board.length-2)+1;
					centerX = pieceGenerator.nextInt(board[0].length-2)+1;
				}
				
				board[centerY][centerX] = Cell.BUSY;
				dificuldade--;
			}
		}
		// second pass to set null values
		for(int l = 0; l<board.length; l++) {
			for(int c = 0; c<board[l].length; c++) {
				if(board[l][c] == null) {
					board[l][c] = Cell.FREE;
				}
			}
		}
	}

	/**
	 * Checks all positions for availability cosidering the current piece 
	 * without applying any transformation
	 * @return true if there is a position available false otherwise
	 */
	/*private boolean CheckPositions() {
		Piece pieceToCheck;
		boolean available = false;
		
		for(int i = 1; i<board.length-1; i++) {
			for(int j = 1; j<board.length-1; j++) {
				
				pieceToCheck = MakePiece(i, j);
				
				if(pieceToCheck.fits(currentPiece)) {
					available = true;
				}
			}
		}
		return available;
	}*/
	
	/**
	 * Changes the board according to the current piece
	 * @param linha		the Y coordinate of the center in the board 
	 * @param coluna	the X coordinate of the center in the board
	 */
	private void ChangeBoard(int linha, int coluna) {
		Cell[][] newValues = currentPiece.getCells();
		
		if(newValues[0][0] == Cell.BUSY)
			board[linha-1][coluna-1] = newValues[0][0];
		if(newValues[0][1] == Cell.BUSY)
			board[linha-1][coluna] = newValues[0][1];
		if(newValues[0][2] == Cell.BUSY)
			board[linha-1][coluna+1] = newValues[0][2];
		
		if(newValues[1][0] == Cell.BUSY)
			board[linha][coluna-1] = newValues[1][0];
		if(newValues[1][1] == Cell.BUSY)
			board[linha][coluna] = newValues[1][1];
		if(newValues[1][2] == Cell.BUSY)
			board[linha][coluna+1] = newValues[1][2];
		
		if(newValues[2][0] == Cell.BUSY)
			board[linha+1][coluna-1] = newValues[2][0];
		if(newValues[2][1] == Cell.BUSY)
			board[linha+1][coluna] = newValues[2][1];
		if(newValues[2][2] == Cell.BUSY)
			board[linha+1][coluna+1] = newValues[2][2];
		
		
	}
	
	/**
	 * Makes new pieces with values from the board
	 * @param centerY	the centers Y coordinate
	 * @param centerX	the centers X coordinate
	 * @return	a new piece centered around centerY and centerX
	 * @requires {@code centerY > 0 && centerY < board.length-1}
	 * @requires {@code centerX > 0 && centerX < board.[0].length-1}
	 */
	private Piece MakePiece(int centerY, int centerX) {
		if(centerY == 0 || centerY == board.length-1 
				|| centerX == 0 || centerX == board.length-1)
			return nullPiece;
		
		Cell[][] values = {{board[centerY-1][centerX-1],board[centerY-1][centerX],board[centerY-1][centerX+1]},
						{board[centerY][centerX-1],board[centerY][centerX],board[centerY][centerX+1]},
						{board[centerY+1][centerX-1],board[centerY+1][centerX],board[centerY+1][centerX+1]}};
		Piece piece = new Piece(values);
		
		return piece;
	}
	
}
