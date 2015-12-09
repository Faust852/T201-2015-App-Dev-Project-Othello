
import be.ephec.othelloServer.Board;
import be.ephec.othelloServer.Game;
import be.ephec.othelloServer.Pawn;
import be.ephec.othelloServer.GameController;

public class MainOthelloServer {

	public static void main(String[] args) {
		Board board = new Board();
		Pawn[][] bla=new Pawn[][]{
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		};
		Pawn[][] bla1=new Pawn[][]{
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(-1),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		};
		
		Board board2 = new Board(bla);
		board2.AllValidMove(new Pawn(-1));
		System.out.println(board2);
		board2.flipPawn(2, 6, new Pawn(-1));
		System.out.println(board2);


	}


}
