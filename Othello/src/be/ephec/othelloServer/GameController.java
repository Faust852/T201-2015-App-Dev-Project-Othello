package be.ephec.othelloServer;

import java.util.Hashtable;

public class GameController {
	
	private static final Hashtable<Integer, Integer> IndexOfRows = new Hashtable<Integer, Integer>(){
        {put(0, -1);put(1, -1);put(2, -1);put(3, 0);put(4, 0);put(5, 1);put(6, 1);put(7, 1);}
    };
	private static final Hashtable<Integer, Integer> IndexOfCols = new Hashtable<Integer, Integer>(){
        {put(0, -1);put(1, 0);put(2, 1);put(3, -1);put(4, 1);put(5, -1);put(6, 0);put(7, 1);}
    };
	/**
	 * check if isAdjacentToOppositePawnColor, if so, getDirectionFromAdjacentOppositePawnColor, finally check if there isCurrentColorPawnInLine;
	 * @return
	 */
    
    public Board UpdateEverything() {
    	//TODO
    	return null;
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
		for (int i=0;i<=7;i++){
			if( (isInGrid(row+IndexOfRows.get(i), col+IndexOfCols.get(i)) 	&& 
				(board.board[row+IndexOfRows.get(i)][col+IndexOfCols.get(i)].getValueOfPawn()	== board.board[row][col].getOppositeColorPawn().getValueOfPawn()) && 
				(board.board[row+IndexOfRows.get(i)][col+IndexOfCols.get(i)].getValueOfPawn() 	!= 0)))	arrayOfDirection[i]=true;
			
		}
		return arrayOfDirection;
	}
	public static String getDirectionFromBooleanArray(boolean[] arrayOfDirection){
		String s="";
		for (int i=0; i<arrayOfDirection.length;i++) {
			s+=arrayOfDirection[i]+"\t";
		}
		return s;
	}
	
	public static void setPossibleLinePosition(Board board,int row, int col,boolean[] arrayOfDirection, int currentPlayerColor){
		for(int i=0;i<7;i++){
			if(arrayOfDirection[i] == true){
				if(	isInGrid(row+IndexOfRows.get(i)+IndexOfRows.get(i), col+IndexOfCols.get(i)+IndexOfCols.get(i)) &&
					board.board[row+IndexOfRows.get(i)+IndexOfRows.get(i)][col+IndexOfCols.get(i)+IndexOfCols.get(i)].getValueOfPawn()==0){
						board.board[row+IndexOfRows.get(i)+IndexOfRows.get(i)][col+IndexOfCols.get(i)+IndexOfCols.get(i)].setValueOfPawn(currentPlayerColor);
				}
				if(	isInGrid(row+IndexOfRows.get(i)+IndexOfRows.get(i), col+IndexOfCols.get(i)+IndexOfCols.get(i)) &&
					board.board[row+IndexOfRows.get(i)+IndexOfRows.get(i)][col+IndexOfCols.get(i)+IndexOfCols.get(i)].getValueOfPawn()==currentPlayerColor){
				}
				
			}
		}
	}
	public static void AllValidMove(Board board, int currentColor) {
		for (int i=0;i<=7;i++){
			for (int j=0; j<=7; j++) {
				if(board.getBoard()[i][j].getValueOfPawn()==currentColor) {
				GameController.setPossibleLinePosition(board, i, j, GameController.isAdjacentToOppositePawnColor(board, i, j),2);
				}
			}
		}
	}
}
