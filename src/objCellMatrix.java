import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class objCellMatrix {
	public static final int BOARD_SCALE = 50;
	public static Piece.pieceType[][] pieceMatrix = new Piece.pieceType[8][8];
	public static JLabel[][] pieceLabels = new JLabel[8][8];
	public static boolean currentPlayerIsW  = true;

	public static void resetMatrix() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (row == 1) {
					pieceMatrix[row][column] = Piece.pieceType.b_pawn;
				} else if (row == 6) {
					pieceMatrix[row][column] = Piece.pieceType.w_pawn;
				} else if (row >= 2 && row <= 5) {
					pieceMatrix[row][column] = Piece.pieceType.empty;
				}

				else {
					resetCellPieces(row, column);
				}
			}
		}
	}

	public static void setLables() {
		for (int row = 0; row < 8; row++) {
			for (int c = 0; c < 8; c++) {
				pieceLabels[row][c] = new JLabel();
				pieceLabels[row][c].setName("label_" + row + "_" + c);
				if (row == 0 || row == 1 || row == 6 || row == 7) {
					pieceLabels[row][c].setIcon(new ImageIcon(
							"/home/poseidon/workspace/T/images/"
									+ pieceMatrix[row][c].toString() + ".png"));
				}
				pieceLabels[row][c].setBounds(BOARD_SCALE * c, BOARD_SCALE
						* (row), BOARD_SCALE, BOARD_SCALE);
				Main.frame.add(pieceLabels[row][c]);
				pieceLabels[row][c].addMouseListener(new Mouse_c());
			}
		}
	}

	public static void resetCellPieces(int row, int column) {
		if (row == 0) {
			switch (column) {
			case 0:
				pieceMatrix[row][column] = Piece.pieceType.b_rook;
				break;
			case 7:
				pieceMatrix[row][column] = Piece.pieceType.b_rook;
				break;
			case 1:
				pieceMatrix[row][column] = Piece.pieceType.b_knight;
				break;
			case 6:
				pieceMatrix[row][column] = Piece.pieceType.b_knight;
				break;
			case 2:
				pieceMatrix[row][column] = Piece.pieceType.b_bishop;
				break;
			case 5:
				pieceMatrix[row][column] = Piece.pieceType.b_bishop;
				break;
			case 3:
				pieceMatrix[row][column] = Piece.pieceType.b_queen;
				break;
			case 4:
				pieceMatrix[row][column] = Piece.pieceType.b_king;
				break;
			}
		} else {
			switch (column) {
			case 0:
				pieceMatrix[row][column] = Piece.pieceType.w_rook;
				break;
			case 7:
				pieceMatrix[row][column] = Piece.pieceType.w_rook;
				break;
			case 1:
				pieceMatrix[row][column] = Piece.pieceType.w_knight;
				break;
			case 6:
				pieceMatrix[row][column] = Piece.pieceType.w_knight;
				break;
			case 2:
				pieceMatrix[row][column] = Piece.pieceType.w_bishop;
				break;
			case 5:
				pieceMatrix[row][column] = Piece.pieceType.w_bishop;
				break;
			case 3:
				pieceMatrix[row][column] = Piece.pieceType.w_queen;
				break;
			case 4:
				pieceMatrix[row][column] = Piece.pieceType.w_king;
				break;
			}

		}

	}

	 public void setPieceCell(int row, int column, int piece) {
	 		pieceMatrix[row][column] = piece;
	 }

	 public int[][] getPieceMatrix() {
	 		return pieceMatrix;
	 }

	public boolean checkWinner(int currentPlayer) {

		int checkPlayer = 0;
		if (currentPlayer == 1) {
			checkPlayer = 2;
		} else {
		 	checkPlayer = 1;
		}
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				if (playerMatrix[row][column] == checkPlayer
					&& pieceMatrix[row][column] == 5) // If the enemy's king
					//still remains
					return false;
				}
			}
			return true;	
	}
}
