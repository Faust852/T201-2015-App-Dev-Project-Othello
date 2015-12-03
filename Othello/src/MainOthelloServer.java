
import be.ephec.othelloServer.Board;
import be.ephec.othelloServer.GameController;
import be.ephec.othelloServer.Pawn;

public class MainOthelloServer {

	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board);
		board.getBoard()[3][2].setValueOfPawn(Pawn.getBlackPawn());
		GameController.AllValidMove(board,1);
		System.out.println(board);
		board.getBoard()[3][1].setValueOfPawn(Pawn.getBlackPawn());
		GameController.AllValidMove(board,1);
		System.out.println(board);

	}
}
