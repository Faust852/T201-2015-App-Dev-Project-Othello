package be.ephec.othello.local;

import be.ephec.othello.models.Board;

public class Param {

	public static Board board;

	public static Board getBoard() {
		return board;
	}

	public static void setBoard(Board board) {
		Param.board = board;
	}
	
}
