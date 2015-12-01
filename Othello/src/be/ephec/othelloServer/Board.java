package be.ephec.othelloServer;

public class Board {
	private int boardSize = 8;
	protected Pawn[][] board = new Pawn[boardSize][boardSize];
	
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
	public Board(int boardSize, Pawn[][] board){
		this.boardSize=boardSize;
		this.board=board;
	}

	public Pawn[][] getBoard(){
		return this.board;
	}
	
	public int getSizeBoard(){
		return boardSize;
	}

	public Pawn getUniqueValue(Board board, int row, int col) {
		return(board.board[row][col]);
	}
	
	public void setUniqueValue(Board board, int row, int col, Pawn pawnToSet) {
		board.board[row][col]=pawnToSet;
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
				*/
				showBoard += "\t";
			}
			showBoard+="\n";
		}
		return showBoard;
	}

}
