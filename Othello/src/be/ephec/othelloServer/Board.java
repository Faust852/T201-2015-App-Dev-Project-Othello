package be.ephec.othelloServer;

public class Board {
	private int boardSize = 8;
	protected Pawn[][] board = new Pawn[boardSize][boardSize];
	
	public Board(int boardSize) {
		this.boardSize=boardSize;
		this.board=Board.setStartingBoard(board);
	}
	public Board(int boardSize, Pawn[][] board){
		this.boardSize=boardSize;
		this.board=board;
	}
	public static Pawn[][] setStartingBoard(Pawn[][] board) {
		for (int row=0; row<board.length; row++) {
			for (int col=0;col<board[row].length;col++) {
				board[row][col] = Pawn.getNonePawn();
			}
		}
		board[3][3] = Pawn.getWhitePawn();
		board[4][4] = Pawn.getWhitePawn();
		board[3][4] = Pawn.getBlackPawn();
		board[4][3] = Pawn.getBlackPawn();
		return board;
	}
	
	public Pawn[][] getBoard(){
		return this.board;
	}
	
	public static Pawn[][] setFullWhiteBoard(Pawn[][] board) {
		for (int row=0; row<board.length; row++) {
			for (int col=0;col<board[row].length;col++) {
				board[row][col] = Pawn.getWhitePawn();
			}
		}
		return board;
	}
	
	public int getSizeBoard(){
		return boardSize;
	}
	
	public static void showStartingBoard(Board oBoard) {
		for (int row=0; row<oBoard.board.length; row++) {
			System.out.println("row "+row);
			for (int col=0;col<oBoard.board[row].length;col++) {
				System.out.println(oBoard.board[row][col].getPawnColor()); 
			}
		}
	}
	
	public static Pawn getUniqueValue(Board board, int row, int col) {
		return(board.board[row][col]);
	}
	
	public static void setUniqueValue(Board board, int row, int col, Pawn pawnToSet) {
		board.board[row][col]=pawnToSet;
	}
	
	public String toString() {
		String showBoard="";
		for (int row=0; row<board.length; row++) {
			for (int col=0;col<board[row].length;col++) {
				if(board[row][col].getPawnColor()==-4144960)showBoard +="grey";
				if(board[row][col].getPawnColor()==-1)showBoard +="white";
				if(board[row][col].getPawnColor()==-16777216)showBoard +="black";
				showBoard += "\t";
			}
			showBoard+="\n";
		}
		return showBoard;
	}

}
