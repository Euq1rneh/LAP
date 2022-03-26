import java.util.Random;
/**
 * 
 * This class implements a Piece Object for the game Blocos
 * @author Henrique Marques fc57153
 *
 */
public class Piece {


	public static final int DIM = 3;
	private Cell[][] positions = new Cell[DIM][DIM];
	private int weight = 0;

	/**
	 * Creates a new 3x3 piece according to a matrix of Cell values (FREE or BUSY)
	 * @param shape the matrix of cell values
	 */
	public Piece (Cell[][] shape) {
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				positions[i][j] = shape[i][j];
			}
		}
		this.weight = weight();
	}

	/**
	 * Creates a new 3x3 piece according where all the values are the same
	 * @param type	the value for all cells of the piece (FREE or BUSY)
	 */
	public Piece (Cell type) {
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				positions[i][j] = type;
			}
		}
		this.weight = weight();
	}

	/**
	 * Creates a new 3x3 piece with random values in all of its positions
	 * @param generator the random generator
	 */
	public Piece (Random generator) { 
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				if(generator.nextInt(2) == 1)
					positions[i][j] = Cell.BUSY;
				else
					positions[i][j] = Cell.FREE;
			}
		}
		this.weight = weight();
	}	

	/**
	 * Calculates the value of a piece. The value depends on how many positions are filled
	 * with the <b>BUSY</b> value
	 * @return
	 */
	public int weight() {
		int weight = 0;
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j< positions[i].length; j++) {
				if(positions[i][j].equals(Cell.BUSY)) {
					weight++;
				}
			}
		}
		return weight;
	}

	/**
	 * Gets a copy of the piece's cell values
	 * @return	copy of the piece's cell values
	 */
	public Cell[][] getCells() {
		Cell[][] cells = new Cell[3][3];
		
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = positions[i][j];
			}
		}
		
		return cells;
	}

	/**
	 * Flips a piece <b>vertically</b>
	 */
	public void flipVertical() {
		Cell value;
		for(int i = 0; i< positions.length; i++) {
			for(int j =positions[i].length-1 ; j > 0; j-=2) {
				value = positions[i][j];
				positions[i][j] = positions[i][0];
				positions[i][0] = value;
			}
		}
	}

	/**
	 * Flips a piece <b>horizontally</b>
	 */
	public void flipHorizontal() {
		Cell[] values;
		values = positions[0];
		positions[0] = positions[2];
		positions[2] = values;
	}

	/**
	 * Rotates a piece <b>90 degrees clockwise</b>
	 */
	public void rotate90() {
		Cell[][] transposta = new Cell[DIM][DIM];
		Cell tempPos;
		
		//Trasnsposta
		for(int i = 0; i<positions.length; i++) {
			for(int j = 0; j<positions[i].length; j++) {
				tempPos = positions[i][j];
				transposta[i][j] = positions[j][i];
				transposta[j][i] = tempPos;
			}
		}
		positions = transposta;
		//flipVertical
		flipVertical();
		
	}

	/**
	 * Returns a textual represention of a piece
	 */
	@Override
	public String toString() {
		StringBuilder piece = new StringBuilder();
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				if(j < positions[i].length-1)
					piece.append(positions[i][j].toString()+" ");
				else
					piece.append(positions[i][j].toString());
			}
			piece.append("\r\n");
		}
		return piece.toString();
	}

	/**
	 * Checks if two pieces are the same
	 * @param other	the piece to compare against
	 * @return	true if the pieces are the same false otherwise
	 */
	public boolean isEqual(Piece other) {
		Cell[][] otherPos = other.getCells();
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				if(positions[i][j] != otherPos[i][j])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a two pieces fit inside each other	
	 * @param other	the piece to compare against
	 * @return true if the pieces fit inside each other false otherwise
	 */
	public boolean fits(Piece other) {
		Cell[][] otherPos = other.getCells();
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				if(positions[i][j] == otherPos[i][j] && positions[i][j] == Cell.BUSY)
					return false;
			}
		}
		return true;
	}


	/**
	 * Merges two pieces
	 * @param other the piece to merge with
	 * @return a new piece that is the result of the merge
	 * @requires {@code this.fits(other)}
	 */
	public Piece merge(Piece other) {
		Cell[][] otherPos = other.getCells();
		Cell[][] newPos = new Cell[3][3];
		
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				if((positions[i][j] == Cell.FREE && otherPos[i][j] == Cell.BUSY)||
						(positions[i][j] == Cell.BUSY && otherPos[i][j] == Cell.FREE)	) {
					newPos[i][j] = Cell.BUSY;
				}else {
					newPos[i][j] = Cell.FREE;
				}
				
			}
		}
		return new Piece(newPos);
	}

	/**
	 * Creates a copy of the piece
	 * @return a copy of the piece
	 */
	public Piece copy() {
		return new Piece(this.getCells());
	}

}
