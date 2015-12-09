package be.ephec.othelloServer;

import java.util.Hashtable;

public class Board {
	private int boardSize = 8;
	protected Pawn[][] board = new Pawn[boardSize][boardSize];
	
	private static final Hashtable<Integer, Integer> IndexOfRows = new Hashtable<Integer, Integer>(){
        {put(0, -1);put(1, -1);put(2, -1);put(3, 0);put(4, 0);put(5, 1);put(6, 1);put(7, 1);}
    };
	private static final Hashtable<Integer, Integer> IndexOfCols = new Hashtable<Integer, Integer>(){
        {put(0, -1);put(1, 0);put(2, 1);put(3, -1);put(4, 1);put(5, -1);put(6, 0);put(7, 1);}
    };
	
	public Board() {
		for (int row=0; row<this.board.length; row++) {
			for (int col=0;col<this.board[row].length;col++) {
				Pawn tmp = new Pawn(0);
				tmp.setValueOfPawn(Pawn.getNonePawn());
				board[row][col] = tmp;
			}
		}
		Pawn tmpB = new Pawn(0); //no idea why I have to separate them... if change the value of the precedent pawn if I do that.
		Pawn tmpN = new Pawn(0);
		tmpB.setValueOfPawn(Pawn.getWhitePawn());
		board[3][3] = tmpB;
		board[4][4] = tmpB;
		tmpN.setValueOfPawn(Pawn.getBlackPawn());
		board[3][4] = tmpN;
		board[4][3] = tmpN;
	}
	public Board(Pawn[][] board){
		this.board=board;
	}

	public Pawn[][] getBoard(){
		return this.board;
	}
	
	public int getSizeBoard(){
		return boardSize;
	}

	public boolean isInGrid(int row, int col) {
		try {
			if(row < 0 || col < 0) {return false;}
		    if(row > 7 || col > 7) {return false;}
		    return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean[] isAdjacentToOppositePawnColor(int row,int col, Pawn currentPawnColor) {
		boolean[] arrayOfDirection ={false,false,false,false,false,false,false,false};
			//create object with table of row and table of col
		  //si isInGrid						la valeur du pion dans la case adjacente 	== la valeur opposée du pion de cette même case						  la valeur du pion de la case adjacente != de vide
		for (int i=0;i<=7;i++){
			if( (isInGrid(row+IndexOfRows.get(i), col+IndexOfCols.get(i)) 	&& 
				this.getBoard()[row+IndexOfRows.get(i)][col+IndexOfCols.get(i)].getValueOfPawn() == currentPawnColor.getOppositeColorPawn().getValueOfPawn() &&
				this.getBoard()[row][col].getValueOfPawn() == 0))	arrayOfDirection[i]=true;
		}
		return arrayOfDirection;
	}
	
	public String getDirectionFromBooleanArray(boolean[] arrayOfDirection){
		String s="";
		for (int i=0; i<arrayOfDirection.length;i++) {
			s+=arrayOfDirection[i]+"\t";
		}
		return s;
	}
	
	public boolean isPossibleMove(int row, int col, Pawn pawnToSet){
		boolean[] arrayOfDirection=this.isAdjacentToOppositePawnColor(row, col, pawnToSet);
		boolean isValid = false;
		for(int i=0;i<=7;i++){
			if(arrayOfDirection[i] == true){
				int offsetRow = row+(IndexOfRows.get(i));
				int offsetCol = col+(IndexOfCols.get(i));
				boolean hasOppPieceBetween = false;
				while(isInGrid(offsetRow,offsetCol)){
					if(this.getBoard()[offsetRow][offsetCol].getValueOfPawn()==pawnToSet.getOppositeColorPawn().getValueOfPawn()){
						hasOppPieceBetween=true;
					}
					else if (this.getBoard()[offsetRow][offsetCol].getValueOfPawn()==pawnToSet.getValueOfPawn() && hasOppPieceBetween) {
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
							//System.out.println(x+" "+y);
							System.out.println(offsetRow+" "+offsetCol);
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
	
	public void AllValidMove(Pawn currentColor) {
		//suppression des cases possibles a chaque début pour eviter les redondances
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
