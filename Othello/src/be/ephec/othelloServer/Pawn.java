package be.ephec.othelloServer;

import java.awt.Color;

/**
 * @author David Micciche
 * @version 0.0
 *
 */
public class Pawn {
	protected final Color color;
	
	public Pawn(Color color) {
			this.color=color;
		}
	private static Pawn blackPawn = new Pawn(Color.BLACK);
	private static Pawn whitePawn = new Pawn(Color.WHITE);
	private static Pawn nonePawn = new Pawn(Color.LIGHT_GRAY);
	private static Pawn possiblePawn = new Pawn(Color.BLUE);

	public static Pawn getBlackPawn() {
		return blackPawn;
	}
	public void setBlackPawn(Pawn blackPawn) {
		Pawn.blackPawn = blackPawn;
	}
	public static Pawn getPossiblePawn() {
		return possiblePawn;
	}
	public static void setPossiblePawn(Pawn possiblePawn) {
		Pawn.possiblePawn = possiblePawn;
	}
	public Color getColor() {
		return color;
	}
	public static Pawn getWhitePawn() {
		return whitePawn;
	}
	public static Pawn getNonePawn() {
		return nonePawn;
	}
	public static void setNonePawn(Pawn nonePawn) {
		Pawn.nonePawn = nonePawn;
	}
	public void setWhitePawn(Pawn whitePawn) {
		Pawn.whitePawn = whitePawn;
	}
	public int getPawnColor() {
		return color.getRGB();
	}
	public Pawn getOppositeColorPawn() {
		Pawn oppositeColorPawn;
		if(Color.getColor(color+"")==Color.BLACK) {oppositeColorPawn = new Pawn(Color.WHITE);return oppositeColorPawn;}
		else if(Color.getColor(color+"")==Color.WHITE) {oppositeColorPawn = new Pawn(Color.BLACK);return oppositeColorPawn;}
		else{return nonePawn;}	
	}
}

