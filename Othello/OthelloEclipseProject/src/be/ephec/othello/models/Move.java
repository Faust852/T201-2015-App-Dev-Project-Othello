package be.ephec.othello.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * For all the moves in the GUI
 * @author Adrien Culem and David Micciche
 *
 */
public class Move {

	
	/**
	 * Clear the board 
	 * @param the actual board of the game
	 */
	public static void clearBoard(Board board, JPanel contentPane, JButton btn[][]) {
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				contentPane.remove(btn[i-3][j-2]);
			}
		}
	}
	/**
	 * Simplify the creation of the grid in the method updateBoard(board)
	 * @param Parameters when you create a button in a GridBagLayout
	 * @param btn is the button, 
	 * @param gbc the GridBagConstraints 
	 * @param i position in x axis
	 * @param j position in y axis
	 * 
	 */
	public static void btnTemplate(JButton btn, GridBagConstraints gbc,int i,int j){
		btn.setBackground(new Color(0,180,0));
		btn.setPreferredSize(new Dimension(45, 45));
		gbc.gridx = i;
		gbc.gridy = j;
		gbc.fill = GridBagConstraints.BOTH;
	}
	/**
	 * Count all the pawns every turn to display the actual score in 2 JLabels
	 */
	public static void updateScore(Board board, JTextField blackScore, JTextField whiteScore) {
		int scoreW = board.PointCounter(new Pawn(1));
		int scoreB = board.PointCounter(new Pawn(-1));
		blackScore.setText(""+scoreB);
		whiteScore.setText(""+scoreW);
	}
	/**
	 * Set the JLabel below the Grid to display if this turn is black or white
	 */
	public static void updatePlayerTurn(int turnLeft, JLabel turn) {
		if(turnLeft%2 == 1){
			turn.setText("White");
		}
		if(turnLeft%2 == 0){
			turn.setText("Black");
		}
	}
	/**
	 * Allow to visually refresh the game after an action
	 * @param contentPane
	 */
	public static void refreshBoard(JPanel contentPane){
		contentPane.revalidate();
		contentPane.repaint();
	}
	/**
	 * Transform the click position (String) in coordinates on axis x and y 
	 * @param A string of the position in the grid like " 1,3"
	 * @return The coordinate of the button by axis x and y 
	 */
	public static int[] ParseCoordinate(String s) {
		String string[] = s.split(",");
		int[] coordinate = new int[2];
		coordinate[0] = Integer.parseInt(string[0]);
		coordinate[1] = Integer.parseInt(string[1]);
		return coordinate;
	}
	
}
