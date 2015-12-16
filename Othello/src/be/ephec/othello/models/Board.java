package be.ephec.othello.models;

import java.util.Hashtable;

/**
 * @author David Micciche
 * @version 0.0
 * Main logic class, this class handle things like moves, flipping pawns, check if a move is possible...
 *
 */
public class Board {
	private int boardSize = 8;
	protected Pawn[][] board = new Pawn[boardSize][boardSize];
	/**
	 * Array of direction of x axis, allowing us to get the right direction from a given starting point.
	 * format :
	 * 0 1 2
	 * 3 X 4
	 * 5 6 7
	 */
	private static final Hashtable<Integer, Integer> IndexOfRows = new Hashtable<Integer, Integer>(){
        {put(0, -1);put(1, -1);put(2, -1);put(3, 0);put(4, 0);put(5, 1);put(6, 1);put(7, 1);}
    };
	/**
	 * Array of direction of x axis, allowing us to get the right direction from a given starting point.
	 * format :
	 * 0 1 2
	 * 3 X 4
	 * 5 6 7
	 */
	private static final Hashtable<Integer, Integer> IndexOfCols = new Hashtable<Integer, Integer>(){
        {put(0, -1);put(1, 0);put(2, 1);put(3, -1);put(4, 1);put(5, -1);put(6, 0);put(7, 1);}
    };
	/**
	 * Main constructor, start with an initial board where the center pawns are already set.
	 */
	public Board() {
		for (int row=0; row<this.board.length; row++) {
			for (int col=0;col<this.board[row].length;col++) {
				Pawn tmp = new Pawn(0);
				tmp.setValueOfPawn(Pawn.getNonePawn());
				board[row][col] = tmp;
			}
		}
		Pawn tmpB1 = new Pawn(0); //no idea why I have to separate them... if change the value of the precedent pawn if I do that.
		Pawn tmpB2 = new Pawn(0);
		Pawn tmpN1 = new Pawn(0);
		Pawn tmpN2 = new Pawn(0);
		tmpB1.setValueOfPawn(Pawn.getWhitePawn());
		tmpB2.setValueOfPawn(Pawn.getWhitePawn());
		board[3][3] = tmpB1;
		board[4][4] = tmpB2;
		tmpN1.setValueOfPawn(Pawn.getBlackPawn());
		tmpN2.setValueOfPawn(Pawn.getBlackPawn());
		board[3][4] = tmpN1;
		board[4][3] = tmpN2;
	}
	/**
	 * Constructor from a already given board (might be used for loading a save for instance).
	 * @param board
	 */
	public Board(Pawn[][] board){
		this.board=board;
	}
	/**
	 * return the board on his Pawn[][] format
	 * @return Pawn[][]
	 */
	public Pawn[][] getBoard(){
		return this.board;
	}
	public int getSizeBoard(){
		return boardSize;
	}
	/**
	 * This method check whether a coordinate is inside the board or not, prevent OutOfBound error.
	 * @param row, x axis
	 * @param col, y axis
	 * @return true if a case is in the board, return false if not
	 */
	public boolean isInGrid(int row, int col) {
		try {
			if(row < 0 || col < 0) {return false;}
		    if(row > 7 || col > 7) {return false;}
		    return true;
		}catch(Exception e){ //if outOfBound, return false
			return false;
		}
	}
	/**
	 * This method check whether a case has opposite pawns beside it. If it does, set its coordinate to true (to utilise alongside the arrays of direction).
	 * @param row
	 * @param col
	 * @param currentPawnColor, color of current player
	 * @return boolean[] arrayOfDirection where true is the direction of a pawn of different color direcly siding it. false if not
	 * format :
	 * 0 1 2
	 * 3 X 4
	 * 5 6 7
	 */
	public boolean[] isAdjacentToOppositePawnColor(int row,int col, Pawn currentPawnColor) {
		boolean[] arrayOfDirection ={false,false,false,false,false,false,false,false};
		for (int i=0;i<=7;i++){
			if( (isInGrid(row+IndexOfRows.get(i), col+IndexOfCols.get(i)) 	&&  //If (row,col) is inbound of the board
				this.getBoard()[row+IndexOfRows.get(i)][col+IndexOfCols.get(i)].getValueOfPawn() == currentPawnColor.getOppositeColorPawn().getValueOfPawn() && //If has opposite pawn color around this (row,col)
				this.getBoard()[row][col].getValueOfPawn() == 0))	arrayOfDirection[i]=true; //  if (row,col) is empty case
		}
		return arrayOfDirection;
	}
	/**
	 * This method check if you can put a pawn in a given coordinate by looking on the offset of a direction and meeting the right criteria
	 * @param row
	 * @param col
	 * @param currentPawnColor
	 * @return true if you can put a pawn in the coordinate
	 */
	public boolean isPossibleMove(int row, int col, Pawn currentPawnColor){
		boolean[] arrayOfDirection=this.isAdjacentToOppositePawnColor(row, col, currentPawnColor);
		boolean isValid = false;
		for(int i=0;i<=7;i++){
			if(arrayOfDirection[i] == true){
				int offsetRow = row+(IndexOfRows.get(i));
				int offsetCol = col+(IndexOfCols.get(i));
				boolean hasOppPieceBetween = false;
				while(isInGrid(offsetRow,offsetCol)){
					if(this.getBoard()[offsetRow][offsetCol].getValueOfPawn()==currentPawnColor.getOppositeColorPawn().getValueOfPawn()){
						hasOppPieceBetween=true;
					}
					else if (this.getBoard()[offsetRow][offsetCol].getValueOfPawn()==currentPawnColor.getValueOfPawn() && hasOppPieceBetween) {
						isValid = true;
						break;
					}
					else {break;}
					offsetRow+=(IndexOfRows.get(i));
					offsetCol+=(IndexOfCols.get(i));
				}
			}
			if (isValid)
				return isValid;
		}
		return isValid;
	}
	
	/**
	 * This method flip the opposite pawn color between to pawn of current color
	 * @param row
	 * @param col
	 * @param pawnToSet
	 */
	public void flipPawn(int row, int col, Pawn pawnToSet) {
		if(this.getBoard()[row][col].getValueOfPawn()==Pawn.getPossiblePawn()){
			this.getBoard()[row][col].setValueOfPawn(0);
			boolean[] arrayOfDirection=this.isAdjacentToOppositePawnColor(row, col, pawnToSet);
			this.getBoard()[row][col].setValueOfPawn(pawnToSet.getValueOfPawn());
			int x=0;
			int y=0;
			for(int i=0;i<=7;i++){
				if(arrayOfDirection[i] == true){
					int offsetRow = row+(IndexOfRows.get(i));
					int offsetCol = col+(IndexOfCols.get(i));
					while(isInGrid(offsetRow,offsetCol)){
						if(this.getBoard()[offsetRow][offsetCol].getValueOfPawn()==pawnToSet.getValueOfPawn()){break;}
						offsetRow+=(IndexOfRows.get(i));
						offsetCol+=(IndexOfCols.get(i));
						x=offsetRow;
						y=offsetCol;
					}
					if(isInGrid(x,y) && this.getBoard()[x][y].getValueOfPawn()==pawnToSet.getValueOfPawn()){
						offsetRow = row+(IndexOfRows.get(i));
						offsetCol = col+(IndexOfCols.get(i));
						while(isInGrid(offsetRow,offsetCol)){
							if(this.getBoard()[offsetRow][offsetCol].getValueOfPawn()==pawnToSet.getValueOfPawn()){break;}
							this.getBoard()[offsetRow][offsetCol].setValueOfPawn(pawnToSet.getValueOfPawn());
							offsetRow+=(IndexOfRows.get(i));
							offsetCol+=(IndexOfCols.get(i));
						}
					}
				}
			}
		}	
	}
	/**
	 * This method will highlight all valid move a player can do on his turn
	 * @param currentColor
	 */
	public void AllValidMove(Pawn currentColor) {
		//remove all previous highlight to avoid non possible move being still highlighted
		for(int i=0;i<=7;i++){
			for (int j=0;j<=7;j++) {
				if (this.getBoard()[i][j].getValueOfPawn()==Pawn.getPossiblePawn()) this.getBoard()[i][j].setValueOfPawn(Pawn.getNonePawn());
			}
		}
		for (int i=0;i<=7;i++){
			for (int j=0; j<=7; j++) {
				if(this.getBoard()[i][j].getValueOfPawn()==Pawn.getNonePawn() && this.isPossibleMove(i, j, currentColor)){
					this.getBoard()[i][j].setValueOfPawn(2);
				}
			}
		}
	}
	public boolean isAnyMoveLeft(Pawn currentColor) {
		for(int i=0;i<=7;i++){
			for (int j=0;j<=7;j++) {
				if (this.getBoard()[i][j].getValueOfPawn()==Pawn.getPossiblePawn()) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * @param currentPlayer
	 * @return
	 */
	public int PointCounter(Pawn currentPlayer) {
		int counter = 0;
		for(int i=0;i<=7;i++){
			for (int j=0;j<=7;j++) {
				if (this.getBoard()[i][j].getValueOfPawn()==currentPlayer.getValueOfPawn()){counter++;}
			}
		}
		return counter;
	}
	/**
	 * @param arrayOfDirection
	 * @return simply print the arrayOfDirection
	 */
	public String getDirectionFromBooleanArray(boolean[] arrayOfDirection){
		String s="";
		for (int i=0; i<arrayOfDirection.length;i++) {
			s+=arrayOfDirection[i]+"\t";
		}
		return s;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String showBoard="";
		for (int row=0; row<board.length; row++) {
			for (int col=0;col<board[row].length;col++) {
				showBoard += board[row][col].getValueOfPawn();
				/*
				if(board[row][col].getValueOfPawn()==-0)showBoard +="empty";
				if(board[row][col].getValueOfPawn()==1)showBoard +="white";
				if(board[row][col].getValueOfPawn()==-1)showBoard +="black";
				if(board[row][col].getValueOfPawn()==2)showBoard +="possib";
				*/
				showBoard += "\t";
			}
			showBoard+="\n";
		}
		return showBoard;
	}
}
