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
	
	public static boolean isInGrid(int row, int col) {
		try {
			if(row <= 0 || col <= 0) {return false;}
		    if(row >= 7 || col >= 7) {return false;}
		    return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public static boolean[] isAdjacentToOppositePawnColor(Board board,int row,int col) {
		boolean[] arrayOfDirection ={false,false,false,false,false,false,false,false};
			//create object with table of row and table of col
		  //si isInGrid						la valeur du pion dans la case adjacente 	== la valeur opposée du pion de cette même case						  la valeur du pion de la case adjacente != de vide
			if (isInGrid(row-1, col-1) 	&& (board.board[row-1][col-1].getValueOfPawn()	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row-1][col-1].getValueOfPawn() 	!= 0))	arrayOfDirection[0]=true;
			if (isInGrid(row-1, col) 	&& (board.board[row-1][col].getValueOfPawn() 	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row-1][col].getValueOfPawn() 		!= 0))	arrayOfDirection[1]=true;
			if (isInGrid(row-1, col+1) 	&& (board.board[row-1][col+1].getValueOfPawn() 	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row-1][col+1].getValueOfPawn() 	!= 0))	arrayOfDirection[2]=true;
			if (isInGrid(row, col-1) 	&& (board.board[row][col-1].getValueOfPawn() 	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row][col-1].getValueOfPawn() 		!= 0))	arrayOfDirection[3]=true;
			if (isInGrid(row, col+1) 	&& (board.board[row][col+1].getValueOfPawn() 	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row][col+1].getValueOfPawn() 		!= 0))	arrayOfDirection[4]=true;
			if (isInGrid(row+1, col-1) 	&& (board.board[row+1][col-1].getValueOfPawn() 	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row+1][col-1].getValueOfPawn() 	!= 0))	arrayOfDirection[5]=true;
			if (isInGrid(row+1, col) 	&& (board.board[row+1][col].getValueOfPawn()	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row+1][col].getValueOfPawn() 		!= 0))	arrayOfDirection[6]=true;
			if (isInGrid(row+1, col+1) 	&& (board.board[row+1][col+1].getValueOfPawn() 	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && (board.board[row+1][col+1].getValueOfPawn() 	!= 0))	arrayOfDirection[7]=true;
			return arrayOfDirection;
	}
	public static String getDirectionFromBooleanArray(boolean[] arrayOfDirection){
		String s="";
		for (int i=0; i<arrayOfDirection.length;i++) {
			s+=arrayOfDirection[i]+"\t";
		}
		return s;
	}
	
	public boolean isLineCatchable(Board board,int row, int col,boolean[] arrayOfDirection, int currentPlayerColor){
		if(arrayOfDirection[0] == true){
			for(int i=0;i<7;i++){
				if(isInGrid(row-i-1, col-i-1) && ((board.board[row-i-1][col-i-1].getValueOfPawn() == 0))){	
					board.board[row-i-1][col-i-1].setValueOfPawn(currentPlayerColor);break;
				}
				else if(isInGrid(row-i-1, col-i-1) && ((board.board[row-i-1][col-i-1].getValueOfPawn() == currentPlayerColor)))break;
				else if(isInGrid(row-i-1, col-i-1))break;
			}
		};
		if(arrayOfDirection[1] == true){
			for(int i=0;i<7;i++){
			}
		};
		if(arrayOfDirection[2] == true){
			for(int i=0;i<7;i++){
			}
		};
		if(arrayOfDirection[3] == true){
			for(int i=0;i<7;i++){
			}
		};
		if(arrayOfDirection[4] == true){
			for(int i=0;i<7;i++){
			}
		};
		if(arrayOfDirection[5] == true){
			for(int i=0;i<7;i++){
			}
		};
		if(arrayOfDirection[6] == true){
			for(int i=0;i<7;i++){
			}
		};
		if(arrayOfDirection[7] == true){
			for(int i=0;i<7;i++){
			}
		};

		return false;
	}
	

}
