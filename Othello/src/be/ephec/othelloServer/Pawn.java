package be.ephec.othelloServer;

import java.awt.Color;

/**
 * @author David Micciche
 * @version 0.0
 *
 */
public class Pawn {
	private final Color couleur;
	
	public Pawn(Color couleur) {
			this.couleur=couleur;
		}
	private static Pawn blackPawn = new Pawn(Color.BLACK);
	private static Pawn whitePawn = new Pawn(Color.WHITE);
	private static Pawn nonePawn = new Pawn(new Color(122,122,122,0));

	public static Pawn getBlackPawn() {
		return blackPawn;
	}
	public void setBlackPawn(Pawn blackPawn) {
		Pawn.blackPawn = blackPawn;
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
	public Color getCouleur() {
		return couleur;
	}
}

