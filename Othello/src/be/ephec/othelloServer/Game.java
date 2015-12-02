package be.ephec.othelloServer;

public class Game {

	private Board board = new Board();
	
	private Player playerOne = new PlayerHuman(Pawn.getWhitePawn(),0,"Player 2");
	private Player playerTwo = new PlayerHuman(Pawn.getBlackPawn(),0,"Player 2");
	
	private int turn;
	
	public Game(Board board, Player playerOne, Player playerTwo, int turn){
		this.board = board;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.turn = 2%turn;
	}
}
