public class Piece {

	public enum pieceType {
		b_pawn, b_rook, b_knight, b_bishop, b_queen, b_king, w_pawn, w_rook, w_knight, w_bishop, w_queen, w_king, empty;
	}

	public static boolean isWhite(pieceType type) {
		String myName = (type.toString());
		boolean currentPlayer = (myName.charAt(0) == 'w') ? true : false;
		return currentPlayer;
	}

	public static boolean canMove(int startRow, int startColumn, int desRow,
			int desColumn) {
		pieceType myType = objCellMatrix.pieceMatrix[startColumn][startRow];
		boolean currentPlayer = objCellMatrix.currentPlayerIsW;
		switch (myType) {
		case b_pawn:
			return legalMove_pawn(startRow, startColumn, desRow, desColumn,
					currentPlayer);
		case w_pawn:
			return legalMove_pawn(startRow, startColumn, desRow, desColumn,
					currentPlayer);
		case b_rook:
			return legalMove_rook(startRow, startColumn, desRow, desColumn);
		case w_rook:
			return legalMove_rook(startRow, startColumn, desRow, desColumn);
		case b_knight:
			return legalMove_knight(startRow, startColumn, desRow, desColumn);
		case w_knight:
			return legalMove_knight(startRow, startColumn, desRow, desColumn);
		case b_bishop:
			return legalMove_bishop(startRow, startColumn, desRow, desColumn);
		case w_bishop:
			return legalMove_bishop(startRow, startColumn, desRow, desColumn);
		case b_queen:
			return legalMove_queen(startRow, startColumn, desRow, desColumn);
		case w_queen:
			return legalMove_queen(startRow, startColumn, desRow, desColumn);
		case b_king:
			return legalMove_king(startRow, startColumn, desRow, desColumn);
		case w_king:
			return legalMove_king(startRow, startColumn, desRow, desColumn);

		default:
			return false;
		}
	}

	public static boolean legalMove_king(int startRow, int startColumn,
			int desRow, int desColumn) {

		if (desRow == (startRow + 1) && desColumn == startColumn) // S
		{
			return true;
		} else if (desRow == (startRow + 1) && desColumn == (startColumn - 1)) // SW
		{
			return true;
		} else if (desRow == startRow && desColumn == startColumn - 1) // W
		{
			return true;
		} else if (desRow == (startRow - 1) && desColumn == (startColumn - 1)) // NW
		{
			return true;
		} else if (desRow == (startRow - 1) && desColumn == startColumn) // N
		{
			return true;
		} else if (desRow == (startRow - 1) && desColumn == (startColumn + 1)) // NE
		{
			return true;
		} else if (desRow == startRow && desColumn == (startColumn + 1)) // E
		{
			return true;
		} else if (desRow == (startRow + 1) && desColumn == (startColumn + 1)) // SE
		{
			return true;
		} else {
			return false;
		}
	}

	public static boolean legalMove_knight(int startRow, int startColumn,
			int desRow, int desColumn) {
		if (desRow == (startRow - 2) && desColumn == (startColumn - 1)) // 2N,
		// 1E
		{
			return true;
		} else if (desRow == (startRow - 2) && desColumn == (startColumn + 1)) // 2N,
		// 1W
		{
			return true;
		} else if (desRow == (startRow + 2) && desColumn == (startColumn - 1)) // 2S,
		// 1E
		{
			return true;
		} else if (desRow == (startRow + 2) && desColumn == (startColumn + 1)) // 2S,
		// 1W
		{
			return true;
		} else if (desRow == (startRow - 1) && desColumn == (startColumn - 2)) // 1N,
		// 2E
		{
			return true;
		} else if (desRow == (startRow - 1) && desColumn == (startColumn + 2)) // 1N,
		// 2W
		{
			return true;
		} else if (desRow == (startRow + 1) && desColumn == (startColumn - 2)) // 1S,
		// 2E
		{
			return true;
		} else if (desRow == (startRow + 1) && desColumn == (startColumn + 2)) // 1S,
		// 2W
		{
			return true;
		}
		return false;
	}

	public static boolean legalMove_pawn(int startRow, int startColumn,
			int desRow, int desColumn, boolean currentPlayerIsWhite) {
		boolean legalMove = true;
		int[] playerPawnStart = { 6, 1 };

		if ((currentPlayerIsWhite && desRow >= startRow)
				|| (!currentPlayerIsWhite && desRow <= startRow)) {
			legalMove = false;
		} else if (desColumn != startColumn)
		{
			if ((desColumn > startColumn && desColumn == (startColumn + 1))
					|| (desColumn < startColumn && desColumn == (startColumn - 1)))
			{
				if ((desRow == (startRow + 1) && !currentPlayerIsWhite)
						|| (desRow == (startRow - 1) && currentPlayerIsWhite)) {
					if (objCellMatrix.pieceMatrix[desRow][desColumn] == pieceType.empty)
					{
						legalMove = false;
					}
				} else {
					legalMove = false;
				}
			} else {
				legalMove = false;
			}
		} else if ((currentPlayerIsWhite && desRow < (startRow - 1))
				|| (!currentPlayerIsWhite && desRow > (startRow + 1))) 
		{
			if ((currentPlayerIsWhite && desRow == (startRow - 2))
					|| (!currentPlayerIsWhite && desRow == (startRow + 2)))
			{
				int current = -1;
				if (currentPlayerIsWhite)
					current = 1;
				else
					current = 2;
				if (playerPawnStart[current - 1] != startRow) {
					legalMove = false;
				}
			} else {
				legalMove = false;
			}
		}
		if (legalMove) {
		}
		return legalMove;
	}

	public static boolean legalMove_queen(int startRow, int startColumn,
			int desRow, int desColumn) {
		boolean axis = true;

		if (startRow == desRow ^ startColumn == desColumn)
		{
			axis = true;
		} else if (startRow != desRow && startColumn != desColumn) {
			axis = false;
		} else {
			return false;
		}
		return axisMove(startRow, startColumn, desRow, desColumn, axis);
	}

	public static boolean legalMove_rook(int startRow, int startColumn,
			int desRow, int desColumn) {
		if (startRow != desRow && startColumn != desColumn)
		{
			return false;
		}
		return axisMove(startRow, startColumn, desRow, desColumn, true);
	}

	private static boolean checkAxisMove(int newRow, int newColumn) {
		if (objCellMatrix.pieceMatrix[newRow][newColumn] != pieceType.empty)
		{
			return false;
		}
		return true;
	}

	public static boolean axisMove(int startRow, int startColumn, int desRow,
			int desColumn, boolean straightAxis) {
		if (straightAxis) 
		{
			if ((startColumn == desColumn) && (startRow != desRow)) 
			{
				if (desRow < startRow) 
				{
					for (int newRow = (startRow - 1); newRow > desRow; newRow--) {
						if (!checkAxisMove(newRow, desColumn)) {
							return false;
						}
					}
				} else 
				{
					for (int newRow = (startRow + 1); newRow < desRow; newRow++) {
						if (!checkAxisMove(newRow, desColumn)) {
							return false;
						}
					}
				}
			} else if ((startRow == desRow) && (startColumn != desColumn)) 
			{
				if (desColumn < startColumn) 
				{
					for (int newColumn = (startColumn - 1); newColumn > desColumn; newColumn--) {
						if (!checkAxisMove(desRow, newColumn)) {
							return false;
						}
					}
				} else 
				{
					for (int newColumn = (startColumn + 1); newColumn < desColumn; newColumn++) {
						if (!checkAxisMove(desRow, newColumn)) {
							return false;
						}
					}
				}
			} else 
			{
				return false;
			}
		} else 
		{
			int newColumn = 0;
			if (desRow < startRow && desColumn < startColumn) 
			{
				
				if ((desRow - startRow) == (desColumn - startColumn)) {
					for (int newRow = (startRow - 1); newRow > desRow; newRow--) {
						newColumn = startColumn - (startRow - newRow);
						if (!checkAxisMove(newRow, newColumn)) {
							return false;
						}
					}
				} else {
					return false;
				}
			} else if (desRow < startRow && desColumn > startColumn)
			{
				if ((desRow - startRow) == (startColumn - desColumn)) {
					for (int newRow = (startRow - 1); newRow > desRow; newRow--) {
						newColumn = startColumn + (startRow - newRow);

						if (!checkAxisMove(newRow, newColumn)) {
							return false;
						}
					}
				} else {
					return false;
				}

			} else if (desRow > startRow && desColumn < startColumn)
			{
				if ((startRow - desRow) == (desColumn - startColumn)) {
					for (int newRow = (startRow + 1); newRow < desRow; newRow++) {
						newColumn = startColumn - (newRow - startRow);
						if (!checkAxisMove(newRow, newColumn)) {
							return false;
						}
					}
				} else {
					return false;
				}
			} else if (desRow > startRow && desColumn > startColumn)
			{
				if ((startRow - desRow) == (startColumn - desColumn)) {
					for (int newRow = (startRow + 1); newRow < desRow; newRow++) {

						newColumn = startColumn + (newRow - startRow);

						if (!checkAxisMove(newRow, newColumn)) {
							return false;
						}
					}
				} else {
					return false;
				}

			} else 
			{
				return false;
			}
		}

		return true;

	}

	public static boolean legalMove_bishop(int startRow, int startColumn,
			int desRow, int desColumn) {
		if (startRow == desRow || startColumn == desColumn) 
		{
			return false;
		}
		return axisMove(startRow, startColumn, desRow, desColumn, false);
	}

}
