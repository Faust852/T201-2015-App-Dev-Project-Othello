package be.ephec.othello.models;

/**
 * Allow us to recognize the state of a pawn, White, Black, Empty or Possible
 * @author David Micciche and Adrien Culem
 * @version 0.0
 */
public class Pawn {
	protected int stateOfPawn;
	
	private static final int blackPawn =  -1;
	private static final int whitePawn = 1;
	private static final int nonePawn = 0;
	private static final int possiblePawn = 2;
	
	public Pawn(){
	}
	public Pawn(int stateOfPawn) {
			this.stateOfPawn=stateOfPawn;
	}

	public int getValueOfPawn() {
		return this.stateOfPawn;
	}
	
	public void setValueOfPawn(int stateOfPawn) {
		this.stateOfPawn = stateOfPawn;
	}

	public static int getBlackPawn() {
		return blackPawn;
	}

	public static int getWhitePawn() {
		return whitePawn;
	}

	public static int getNonePawn() {
		return nonePawn;
	}

	public static int getPossiblePawn() {
		return possiblePawn;
	}

	public Pawn getOppositeColorPawn() {
		Pawn oppositeColorPawn = new Pawn(0);
		if(this.getValueOfPawn() == 1) {oppositeColorPawn.setValueOfPawn(Pawn.getBlackPawn());}
		else if(this.getValueOfPawn() == -1) {oppositeColorPawn.setValueOfPawn(Pawn.getWhitePawn());}
		else if(this.getValueOfPawn() == 0) {oppositeColorPawn.setValueOfPawn(Pawn.getNonePawn());}
		return oppositeColorPawn;
	}
}

