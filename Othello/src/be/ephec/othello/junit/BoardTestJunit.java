package be.ephec.othello.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ephec.othello.models.Board;
import be.ephec.othello.models.Pawn;

public class BoardTestJunit {

	@Test
	public void testIsInGrid() {
		Board board = new Board();
		
		assertTrue(board.isInGrid(0, 0));
		assertTrue(board.isInGrid(7, 7));
		assertTrue(board.isInGrid(4, 4));
		
		assertFalse(board.isInGrid(-1, -1));
		assertFalse(board.isInGrid(8, 8));
		assertFalse(board.isInGrid(999, 999));
	}

	@Test
	public void testIsAdjacentToOppositePawnColor() {
		Board board = new Board();
		boolean[] arrayOfDirection = board.isAdjacentToOppositePawnColor(2, 3, new Pawn(Pawn.getWhitePawn()));
		assertTrue(arrayOfDirection[7]==true);
		assertTrue(arrayOfDirection[0]==false);
		assertTrue(arrayOfDirection[1]==false);
		assertTrue(arrayOfDirection[6]==false);
		
		arrayOfDirection = board.isAdjacentToOppositePawnColor(3, 3, new Pawn(Pawn.getWhitePawn()));
		assertTrue(arrayOfDirection[7]==false);
		assertTrue(arrayOfDirection[0]==false);
		assertTrue(arrayOfDirection[1]==false);
		assertTrue(arrayOfDirection[6]==false);
	}

	@Test
	public void testIsPossibleMove() {
		//one case test
		Board board = new Board();
		assertTrue(board.isPossibleMove(2, 3, new Pawn(-1)));
		assertTrue(board.isPossibleMove(3, 2, new Pawn(-1)));
		assertTrue(board.isPossibleMove(5, 4, new Pawn(-1)));
		assertTrue(board.isPossibleMove(4, 5, new Pawn(-1)));
		
		assertFalse(board.isPossibleMove(2, 3, new Pawn(1)));
		assertFalse(board.isPossibleMove(3, 2, new Pawn(1)));
		assertFalse(board.isPossibleMove(5, 4, new Pawn(1)));
		assertFalse(board.isPossibleMove(4, 5, new Pawn(1)));
		
		//multiple case test
		board = new Board(new Pawn[][]{
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		});
		assertTrue(board.isPossibleMove(1, 2, new Pawn(1)));
		assertTrue(board.isPossibleMove(6, 4, new Pawn(-1)));
		assertTrue(board.isPossibleMove(2, 6, new Pawn(-1)));
		
		assertFalse(board.isPossibleMove(2, 6, new Pawn(1)));
		assertFalse(board.isPossibleMove(3, 6, new Pawn(1)));
	}

	@Test
	public void testFlipPawn() {
		Board board = new Board();
		board.AllValidMove(new Pawn(-1));
		board.flipPawn(2, 3,new Pawn(-1));
		assertTrue(board.getBoard()[2][3].getValueOfPawn()==-1);
		assertTrue(board.getBoard()[3][3].getValueOfPawn()==new Pawn(-1).getValueOfPawn());
		board = new Board(new Pawn[][]{
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		});
		board.AllValidMove(new Pawn(-1));
		board.flipPawn(1, 4,new Pawn(-1));
		assertTrue(board.getBoard()[1][4].getValueOfPawn()==-1);
		assertTrue(board.getBoard()[2][4].getValueOfPawn()==new Pawn(-1).getValueOfPawn());
		assertTrue(board.getBoard()[3][4].getValueOfPawn()==new Pawn(-1).getValueOfPawn());
	}

	@Test
	public void testAllValidMove() {
		Board board = new Board();
		board.AllValidMove(new Pawn(-1));
		assertTrue(board.getBoard()[2][3].getValueOfPawn()==2);
		assertTrue(board.getBoard()[3][2].getValueOfPawn()==2);
		assertTrue(board.getBoard()[4][5].getValueOfPawn()==2);
		assertTrue(board.getBoard()[5][4].getValueOfPawn()==2);
	}

	@Test
	public void testIsAnyMoveLeft() {
		Board board = new Board();
		board.AllValidMove(new Pawn(-1));
		assertTrue(board.isAnyMoveLeft(new Pawn(-1)));
		board = new Board(new Pawn[][]{
			{new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
			{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		});
		board.AllValidMove(new Pawn(1));
		assertFalse(board.isAnyMoveLeft(new Pawn(1)));
	}

	@Test
	public void testPointCounter() {
		Board board = new Board();
		assertTrue(board.PointCounter(new Pawn(1))==2);
		assertTrue(board.PointCounter(new Pawn(-1))==2);
	}

}
