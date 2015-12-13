package be.ephec.othelloServer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BoardTest {

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
		fail("Not yet implemented");
	}

	@Test
	public void testAllValidMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testPointCounter() {
		fail("Not yet implemented");
	}

}
