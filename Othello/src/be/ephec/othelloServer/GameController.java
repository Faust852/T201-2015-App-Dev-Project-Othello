package be.ephec.othelloServer;

import java.util.Hashtable;

public class GameController{
	
    private Board board;
    private Player player1 = new Player(1, 0, "p1");
    private Player player2 = new Player(-1, 0, "p2");
    private int turnLeft = 60;
    
    public void TurnControl() {
    	while(turnLeft>0) {
    		if(turnLeft%2==0){
    			turnLeft--;
    		}
    		else{
    			turnLeft--;
    		}
    	}
    }
    
    public boolean PlayerAction(Player player, int row, int col) {
    	boolean actualMove=false;
    	board.AllValidMove(new Pawn(player.getColor()));
    	if(board.getBoard()[row][col].getValueOfPawn()==Pawn.getPossiblePawn()){
    		board.flipPawn(row, col, new Pawn(player.getColor()));
    		actualMove = true;
    	}
    	return actualMove;
    }
    public Board UpdateEverything() {
    	//TODO
    	return null;
    }
	
}