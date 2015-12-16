package be.ephec.othello.local;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

public class ClientInterface extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btn[][] = new JButton[8][8];
	private JLabel lbl[] = new JLabel[8];
	private JLabel lbltxt[] = new JLabel[8];
	private JLabel errMsg = new JLabel();

	private Board board = new Board();
	private int turnLeft = 60;
	
	private JTextField whiteScore;
	private JTextField blackScore;
	private JLabel turn;
	private JButton btnPlayAgainstIa;
	JButton btnHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInterface frame = new ClientInterface();
					ImageIcon b = new ImageIcon(getClass().getResource("/bd.png"));
					frame.setIconImage(b.getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(100, 100, 816, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 45, 11, 45, 45, 45, 45, 45, 45, 45, 45, 0, 53, 45, 45, 45, 45, 41, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 45, 45, 45, 45, 45, 45, 45, 45, 45, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
			
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(this);
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.fill = GridBagConstraints.BOTH;
		gbc_btnNewGame.gridwidth = 5;
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewGame.gridx = 13;
		gbc_btnNewGame.gridy = 2;
		contentPane.add(btnNewGame, gbc_btnNewGame);
		
		btnPlayAgainstIa = new JButton("Play Against IA");
		btnPlayAgainstIa.addActionListener(this);
		GridBagConstraints gbc_btnPlayAgainstIa = new GridBagConstraints();
		gbc_btnPlayAgainstIa.fill = GridBagConstraints.BOTH;
		gbc_btnPlayAgainstIa.gridwidth = 5;
		gbc_btnPlayAgainstIa.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlayAgainstIa.gridx = 13;
		gbc_btnPlayAgainstIa.gridy = 4;
		contentPane.add(btnPlayAgainstIa, gbc_btnPlayAgainstIa);
		
		JLabel lblScore = new JLabel("Score :");
		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.gridwidth = 4;
		gbc_lblScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblScore.gridx = 13;
		gbc_lblScore.gridy = 6;
		contentPane.add(lblScore, gbc_lblScore);
		
		JLabel lblWhite = new JLabel("White");
		GridBagConstraints gbc_lblWhite = new GridBagConstraints();
		gbc_lblWhite.gridwidth = 2;
		gbc_lblWhite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhite.gridx = 13;
		gbc_lblWhite.gridy = 7;
		contentPane.add(lblWhite, gbc_lblWhite);
		
		whiteScore = new JTextField();
		whiteScore.setEditable(false);
		GridBagConstraints gbc_whiteScore = new GridBagConstraints();
		gbc_whiteScore.gridwidth = 3;
		gbc_whiteScore.insets = new Insets(0, 0, 5, 0);
		gbc_whiteScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_whiteScore.gridx = 15;
		gbc_whiteScore.gridy = 7;
		contentPane.add(whiteScore, gbc_whiteScore);
		whiteScore.setColumns(10);
		
		JLabel lblBlack = new JLabel("Black");
		GridBagConstraints gbc_lblBlack = new GridBagConstraints();
		gbc_lblBlack.gridwidth = 2;
		gbc_lblBlack.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlack.gridx = 13;
		gbc_lblBlack.gridy = 8;
		contentPane.add(lblBlack, gbc_lblBlack);
		
		blackScore = new JTextField();
		blackScore.setEditable(false);
		GridBagConstraints gbc_blackScore = new GridBagConstraints();
		gbc_blackScore.gridwidth = 3;
		gbc_blackScore.insets = new Insets(0, 0, 5, 0);
		gbc_blackScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_blackScore.gridx = 15;
		gbc_blackScore.gridy = 8;
		contentPane.add(blackScore, gbc_blackScore);
		blackScore.setColumns(10);
		
		errMsg = new JLabel();
		GridBagConstraints gbc_errMsg = new GridBagConstraints();
		gbc_errMsg.fill = GridBagConstraints.BOTH;
		gbc_errMsg.insets = new Insets(0, 0, 5, 5);
		gbc_errMsg.gridx = 15;
		gbc_errMsg.gridy = 9;
		contentPane.add(errMsg, gbc_errMsg);
		
		JLabel lblTurn = new JLabel("Turn :");
		GridBagConstraints gbc_lblTurn = new GridBagConstraints();
		gbc_lblTurn.insets = new Insets(0, 0, 0, 5);
		gbc_lblTurn.gridx = 3;
		gbc_lblTurn.gridy = 10;
		contentPane.add(lblTurn, gbc_lblTurn);
		
		turn = new JLabel("Black");
		GridBagConstraints gbc_turn = new GridBagConstraints();
		gbc_turn.insets = new Insets(0, 0, 0, 5);
		gbc_turn.gridx = 4;
		gbc_turn.gridy = 10;
		contentPane.add(turn, gbc_turn);
		
		btnHelp = new JButton("Help ?");
		btnHelp.addActionListener(this);
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHelp.gridwidth = 3;
		gbc_btnHelp.insets = new Insets(0, 0, 0, 5);
		gbc_btnHelp.gridx = 6;
		gbc_btnHelp.gridy = 10;
		contentPane.add(btnHelp, gbc_btnHelp);
		
		for(int i = 0; i<8; i++){
			lbltxt[i] = new JLabel();
			GridBagConstraints gbc_lbltxt = new GridBagConstraints();
			gbc_lbltxt.insets = new Insets(0, 0, 5, 5);
			gbc_lbltxt.gridx = i+3;
			gbc_lbltxt.gridy = 1;
			contentPane.add(lbltxt[i], gbc_lbltxt);
		}
		
		lbltxt[0].setText("A");
		lbltxt[1].setText("B");
		lbltxt[2].setText("C");
		lbltxt[3].setText("D");
		lbltxt[4].setText("E");
		lbltxt[5].setText("F");
		lbltxt[6].setText("G");
		lbltxt[7].setText("H");
		
		
		for(int i = 0; i<8; i++){
			lbl[i] = new JLabel();
			lbl[i].setText(""+(i+1));
			GridBagConstraints gbc_lbl = new GridBagConstraints();
			gbc_lbl.anchor = GridBagConstraints.EAST;
			gbc_lbl.insets = new Insets(0, 0, 5, 5);
			gbc_lbl.gridx = 2;
			gbc_lbl.gridy = i+2;
			contentPane.add(lbl[i], gbc_lbl);
		}
		
		updateBoard(board);
	}
	public int[] ParseCoordinate(String s) {
		String string[] = s.split(",");
		int[] coordinate = new int[2];
		coordinate[0] = Integer.parseInt(string[0]);
		coordinate[1] = Integer.parseInt(string[1]);
		return coordinate;
	}
	
	public void ActionPlayer(Board board, Pawn player, int[] coordonnee) {
		board.flipPawn(coordonnee[0], coordonnee[1], player);
		board.AllValidMove(new Pawn(1));
		clearBoard(board);
		updateBoard(board);
		updatePlayerTurn();
		updateScore();
	}
	
	public void refreshBoard(JPanel contentPane){
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "New Game" :
				turnLeft = 60;
				board = new Board();
				clearBoard(board);
				updateBoard(board);
				updateScore();
				turn.setText("Black");
				refreshBoard(contentPane);
				break;
			case "Play Against IA" :
				JOptionPane.showMessageDialog(null, "Not yet implemented");break;
			case "Help ?" :
				if(turnLeft%2 == 0 && turnLeft != 0) {
					board.AllValidMove(new Pawn(-1));
					}
				else{board.AllValidMove(new Pawn(1));}
				clearBoard(board);
				updateBoardWithHelp(board);
				refreshBoard(contentPane);
				break;
			default :
				JButton jb = (JButton) e.getSource();
				int[] coordonnee = ParseCoordinate(jb.getName());
				if(turnLeft%2 == 0 && turnLeft != 0) {
					board.AllValidMove(new Pawn(-1));
					if(!board.isAnyMoveLeft(new Pawn(-1))){
						String nom = board.PointCounter(new Pawn(-1)) > board.PointCounter(new Pawn(1)) ? "Black" : "White";
						JOptionPane.showMessageDialog(null,"Game ended ! Congratz to "+nom);
						}
					clearBoard(board);
					updateBoard(board);
					if (board.getBoard()[coordonnee[0]][coordonnee[1]].getValueOfPawn()==Pawn.getPossiblePawn()) {
						ActionPlayer(board, new Pawn(-1), coordonnee);
						clearBoard(board);
						updateBoard(board);
						refreshBoard(contentPane);
						errMsg.setText("");
						turnLeft--;
					}
					else errMsg.setText("Unvalid");
				}
				else if(turnLeft%2 == 1 && turnLeft != 0) {
					board.AllValidMove(new Pawn(1));
					if(!board.isAnyMoveLeft(new Pawn(1))){
						String nom = board.PointCounter(new Pawn(-1)) > board.PointCounter(new Pawn(1)) ? "Black" : "White";
						JOptionPane.showMessageDialog(null,"Game ended ! Congratz to "+nom);
						}
					clearBoard(board);
					updateBoard(board);
					if (board.getBoard()[coordonnee[0]][coordonnee[1]].getValueOfPawn()==Pawn.getPossiblePawn()) {
						ActionPlayer(board, new Pawn(1), coordonnee);
						clearBoard(board);
						updateBoard(board);
						refreshBoard(contentPane);
						errMsg.setText("");
						turnLeft--;
					}
					else errMsg.setText("Unvalid");
				}
				else{
					refreshBoard(contentPane);
				}
				clearBoard(board);
				updateBoard(board);
				refreshBoard(contentPane);
		}
	}
	
	public void clearBoard(Board board) {
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				contentPane.remove(btn[i-3][j-2]);
			}
		}
	}
	public void updateBoard(Board board) {
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				btn[i-3][j-2] = new JButton();
				GridBagConstraints gbc_btn = new GridBagConstraints();
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==0){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==-1){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					Icon b = new ImageIcon(getClass().getResource("/bd.png"));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					btn[i-3][j-2].setIcon(b);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==1){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					Icon b = new ImageIcon(getClass().getResource("/wd.png"));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					btn[i-3][j-2].setIcon(b);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==2){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				btn[i-3][j-2].addActionListener(this);
				btn[i-3][j-2].setName("" + (i-3) + "," + (j-2));
				btn[i-3][j-2].setSize(5, 5);
				contentPane.add(btn[i-3][j-2],gbc_btn);
			}
		}
	}
	public void updateBoardWithHelp(Board board) {
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				btn[i-3][j-2] = new JButton();
				GridBagConstraints gbc_btn = new GridBagConstraints();
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==0){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==-1){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					Icon b = new ImageIcon(getClass().getResource("/bd.png"));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					btn[i-3][j-2].setIcon(b);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==1){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					Icon b = new ImageIcon(getClass().getResource("/wd.png"));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					btn[i-3][j-2].setIcon(b);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==2){
					btn[i-3][j-2].setBackground(new Color(0,180,150));
					btn[i-3][j-2].setPreferredSize(new Dimension(45, 45));
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				btn[i-3][j-2].addActionListener(this);
				btn[i-3][j-2].setName("" + (i-3) + "," + (j-2));
				btn[i-3][j-2].setSize(5, 5);
				contentPane.add(btn[i-3][j-2],gbc_btn);
			}
		}
	}
	public void updateScore() {
		int scoreW = board.PointCounter(new Pawn(1));
		int scoreB = board.PointCounter(new Pawn(-1));
		blackScore.setText(""+scoreB);
		whiteScore.setText(""+scoreW);
	}
	
	public void updatePlayerTurn() {
		if(turnLeft%2 == 1){
			turn.setText("Black");
		}
		if(turnLeft%2 == 0){
			turn.setText("White");
		}
	}
}