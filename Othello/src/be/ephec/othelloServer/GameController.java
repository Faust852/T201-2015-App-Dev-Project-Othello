package be.ephec.othelloServer;

public class GameController {
	
	
	/**
	 * check if isAdjacentToOppositePawnColor, if so, getDirectionFromAdjacentOppositePawnColor, finally check if there isCurrentColorPawnInLine;
	 * @return
	 */
	public boolean isValidMove() {
		//todo
		return false;
	}
	
	/**
	 * 
	 * check in a switch-case what each of the eight possibilities, need to take edge into consideration
	 * idea for edge case : do a boolean isInGrid(intx,inty) 
	 * cf: http://stackoverflow.com/questions/25573199/simple-way-to-ignore-out-of-bounds-exceptions-java
	 * @param board
	 * @param row
	 * @param col
	 * @param currentColor
	 * @return
	 */
	public static boolean isAdjacentToOppositePawnColor(Board board,int row,int col,Pawn currentColor) {
		try {
		if (isInGrid(row-1, col-1) 	&& board.board[row-1][col-1].getPawnColor() == currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row-1, col) 	&& board.board[row-1][col].getPawnColor() 	== currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row-1, col+1) 	&& board.board[row-1][col+1].getPawnColor() == currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row, col-1) 	&& board.board[row][col-1].getPawnColor() 	== currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row, col+1) 	&& board.board[row][col+1].getPawnColor() 	== currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row+1, col-1) 	&& board.board[row-1][col-1].getPawnColor() == currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row+1, col) 	&& board.board[row-1][col].getPawnColor()	== currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		if (isInGrid(row+1, col+1) 	&& board.board[row-1][col+1].getPawnColor() == currentColor.getOppositeColorPawn().getPawnColor() && board.board[row-1][col-1].getPawnColor() != Pawn.getNonePawn().getPawnColor())	return true;
		return false;
		}catch(Exception e){
			return false;
		}
	}
	
	public static boolean isInGrid(int row, int col) {
		try {
			if(row < 0 || col < 0) {return false;}
		    if(row >= 7 || row >= 7) {return false;} //need to do a getSize from board, but issue with static ??
		    return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getDirectionFromAdjacentOppositePawnColor() {
		//todo
		return null;
	}
	
	/**
	 * check if there is current color pawn in this line, if not but opposite color, keep in the loop;
	 * if NONE, return false; 
	 * if indexOutOfBound, return false;  
	 * ifSameColor, return true;
	 * @return
	 */
	public boolean isCurrentColorPawnInLine() {
		//todo
		return false;
	}
}
