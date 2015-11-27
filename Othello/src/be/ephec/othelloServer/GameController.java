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
	public boolean isAdjacentToOppositePawnColor(Board board,int row,int col,Pawn currentColor) {
		//todo
		board.board[row][col].getPawnColor();
		return false;
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
