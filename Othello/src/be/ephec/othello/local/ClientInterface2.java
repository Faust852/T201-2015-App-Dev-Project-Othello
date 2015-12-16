package be.ephec.othello.local;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.ephec.othello.models.Board;
import be.ephec.othello.models.Pawn;
import be.ephec.othello.network.ChatMessage;
import be.ephec.othello.network.Client;

public class ClientInterface2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btn[][] = new JButton[8][8];
	private JLabel lbl[] = new JLabel[8];
	private JLabel lbltxt[] = new JLabel[8];
	private JLabel errMsg = new JLabel();

	private Board board = new Board();
	private int turnLeft = 60;
	
	private boolean iaBool = false;
	
	private JTextField whiteScore;
	private JTextField blackScore;
	private JLabel turn;
	private JButton btnPlayAgainstIa;
	JButton btnHelp;
	private JTextField txtIp;
	private JLabel lblIp;
	private JLabel lblPort;
	private JTextField portField;
	private JButton btnConnect;
	private JButton btnChat;
	private JTextField textField_2;
	private JLabel lblName;
	
	private JTextField tf;
	private boolean connected;
	private Client client;
	private int defaultPort;
	private String defaultHost;
	private JTextArea textArea;
	private JTextField chat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInterface2 frame = new ClientInterface2();
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
	public ClientInterface2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(100, 100, 1084, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 45, 11, 45, 45, 45, 45, 45, 45, 45, 45, 0, 53, 45, 45, 45, 45, 41, 45, 45, 45, 45, 45, 45, 0};
		gbl_contentPane.rowHeights = new int[]{45, 0, 0, 45, 45, 45, 45, 45, 45, 45, 45, 45, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
			
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(this);
		
		lblIp = new JLabel("IP");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 19;
		gbc_lblIp.gridy = 2;
		contentPane.add(lblIp, gbc_lblIp);
		
		txtIp = new JTextField();
		txtIp.setText("localhost");
		GridBagConstraints gbc_txtIp = new GridBagConstraints();
		gbc_txtIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIp.gridwidth = 3;
		gbc_txtIp.insets = new Insets(0, 0, 5, 5);
		gbc_txtIp.gridx = 20;
		gbc_txtIp.gridy = 2;
		contentPane.add(txtIp, gbc_txtIp);
		txtIp.setColumns(10);
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.fill = GridBagConstraints.BOTH;
		gbc_btnNewGame.gridwidth = 5;
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewGame.gridx = 13;
		gbc_btnNewGame.gridy = 3;
		contentPane.add(btnNewGame, gbc_btnNewGame);
		
		btnPlayAgainstIa = new JButton("Play Against IA");
		btnPlayAgainstIa.addActionListener(this);
		
		lblPort = new JLabel("Port");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 19;
		gbc_lblPort.gridy = 3;
		contentPane.add(lblPort, gbc_lblPort);
		
		portField = new JTextField();
		portField.setText("1500");
		GridBagConstraints gbc_portField = new GridBagConstraints();
		gbc_portField.fill = GridBagConstraints.HORIZONTAL;
		gbc_portField.gridwidth = 2;
		gbc_portField.insets = new Insets(0, 0, 5, 5);
		gbc_portField.gridx = 20;
		gbc_portField.gridy = 3;
		contentPane.add(portField, gbc_portField);
		portField.setColumns(10);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(this);
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.insets = new Insets(0, 0, 5, 5);
		gbc_btnConnect.gridx = 22;
		gbc_btnConnect.gridy = 3;
		contentPane.add(btnConnect, gbc_btnConnect);
		
		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 19;
		gbc_lblName.gridy = 4;
		contentPane.add(lblName, gbc_lblName);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 20;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		GridBagConstraints gbc_btnPlayAgainstIa = new GridBagConstraints();
		gbc_btnPlayAgainstIa.fill = GridBagConstraints.BOTH;
		gbc_btnPlayAgainstIa.gridwidth = 5;
		gbc_btnPlayAgainstIa.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlayAgainstIa.gridx = 13;
		gbc_btnPlayAgainstIa.gridy = 5;
		contentPane.add(btnPlayAgainstIa, gbc_btnPlayAgainstIa);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		gbc_textArea.gridheight = 6;
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 19;
		gbc_textArea.gridy = 5;
		contentPane.add(textArea, gbc_textArea);
		
		JLabel lblScore = new JLabel("Score :");
		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.gridwidth = 4;
		gbc_lblScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblScore.gridx = 13;
		gbc_lblScore.gridy = 7;
		contentPane.add(lblScore, gbc_lblScore);
		
		JLabel lblWhite = new JLabel("White");
		GridBagConstraints gbc_lblWhite = new GridBagConstraints();
		gbc_lblWhite.gridwidth = 2;
		gbc_lblWhite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhite.gridx = 13;
		gbc_lblWhite.gridy = 8;
		contentPane.add(lblWhite, gbc_lblWhite);
		
		whiteScore = new JTextField();
		whiteScore.setEditable(false);
		GridBagConstraints gbc_whiteScore = new GridBagConstraints();
		gbc_whiteScore.gridwidth = 3;
		gbc_whiteScore.insets = new Insets(0, 0, 5, 5);
		gbc_whiteScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_whiteScore.gridx = 15;
		gbc_whiteScore.gridy = 8;
		contentPane.add(whiteScore, gbc_whiteScore);
		whiteScore.setColumns(10);
		
		JLabel lblBlack = new JLabel("Black");
		GridBagConstraints gbc_lblBlack = new GridBagConstraints();
		gbc_lblBlack.gridwidth = 2;
		gbc_lblBlack.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlack.gridx = 13;
		gbc_lblBlack.gridy = 9;
		contentPane.add(lblBlack, gbc_lblBlack);
		
		blackScore = new JTextField();
		blackScore.setEditable(false);
		GridBagConstraints gbc_blackScore = new GridBagConstraints();
		gbc_blackScore.gridwidth = 3;
		gbc_blackScore.insets = new Insets(0, 0, 5, 5);
		gbc_blackScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_blackScore.gridx = 15;
		gbc_blackScore.gridy = 9;
		contentPane.add(blackScore, gbc_blackScore);
		blackScore.setColumns(10);
		
		tf = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 19;
		gbc_textField_1.gridy = 10;
		contentPane.add(tf, gbc_textField_1);
		tf.setColumns(10);
		
		errMsg = new JLabel();
		GridBagConstraints gbc_errMsg = new GridBagConstraints();
		gbc_errMsg.fill = GridBagConstraints.BOTH;
		gbc_errMsg.insets = new Insets(0, 0, 5, 5);
		gbc_errMsg.gridx = 15;
		gbc_errMsg.gridy = 10;
		contentPane.add(errMsg, gbc_errMsg);
		
		JLabel lblTurn = new JLabel("Turn :");
		GridBagConstraints gbc_lblTurn = new GridBagConstraints();
		gbc_lblTurn.insets = new Insets(0, 0, 0, 5);
		gbc_lblTurn.gridx = 3;
		gbc_lblTurn.gridy = 11;
		contentPane.add(lblTurn, gbc_lblTurn);
		
		turn = new JLabel("Black");
		GridBagConstraints gbc_turn = new GridBagConstraints();
		gbc_turn.insets = new Insets(0, 0, 0, 5);
		gbc_turn.gridx = 4;
		gbc_turn.gridy = 11;
		contentPane.add(turn, gbc_turn);
		
		btnHelp = new JButton("Help ?");
		btnHelp.addActionListener(this);
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHelp.gridwidth = 3;
		gbc_btnHelp.insets = new Insets(0, 0, 0, 5);
		gbc_btnHelp.gridx = 6;
		gbc_btnHelp.gridy = 11;
		contentPane.add(btnHelp, gbc_btnHelp);
		
		chat = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 19;
		gbc_textField_3.gridy = 11;
		contentPane.add(chat, gbc_textField_3);
		chat.setColumns(10);
		
		btnChat = new JButton("Chat");
		btnChat.addActionListener(this);
		GridBagConstraints gbc_btnChat = new GridBagConstraints();
		gbc_btnChat.insets = new Insets(0, 0, 0, 5);
		gbc_btnChat.gridx = 22;
		gbc_btnChat.gridy = 11;
		contentPane.add(btnChat, gbc_btnChat);
		
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
		board.AllValidMove(player);
		refreshAll(board,contentPane);
	}
	
	public void refreshBoard(JPanel contentPane){
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void append(String str) {
		textArea.append(str);
		textArea.setCaretPosition(textArea.getText().length() - 1);
	}
	
	public void connectionFailed() {
		btnConnect.setEnabled(true);
		lblName.setText("Enter your username below");
		tf.setText("Anonymous");
		portField.setText("" + defaultPort);
		txtIp.setText(defaultHost);
		txtIp.setEditable(false);
		portField.setEditable(false);
		tf.removeActionListener(this);
		connected = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(connected) {
			// just have to send the message
			client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, chat.getText()));				
			tf.setText("");
			return;
		}
		switch (e.getActionCommand()) {
			case "Connect": 
				String username = textField_2.getText();
				if (username.length()==0) textField_2.setText("Anonymous");
				username = textField_2.getText().trim();
				String server = txtIp.getText().trim();
				String portNumber = portField.getText().trim();
				int port = 0;
				try {
					port = Integer.parseInt(portNumber);
				}
				catch(Exception en) {
					break;
				}
				client = new Client(server, port, username, this);
				if(!client.start()) break;
				connected = true;
				textField_2.setEditable(false);
				btnConnect.setEnabled(false);
				txtIp.setEditable(false);
				portField.setEditable(false);
			case "Chat" :
				String text = chat.getText().trim();
			case "New Game" :
				iaBool = false;
				turnLeft = 60;
				board = new Board();
				refreshAll(board,contentPane);
				turn.setText("Black");
				break;
			case "Play Against IA" :
				iaBool = true;
				turnLeft = 60;
				board = new Board();
				turn.setText("Black");
				refreshAll(board,contentPane);
				break;
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
				if(turnLeft%2 == 0 && turnLeft != 0 && !iaBool) {
					board.AllValidMove(new Pawn(-1));
					if(!board.isAnyMoveLeft(new Pawn(-1))){
						String nom = board.PointCounter(new Pawn(-1)) > board.PointCounter(new Pawn(1)) ? "Black" : "White";
						JOptionPane.showMessageDialog(null,"Game ended ! Congratz to "+nom);
						}
					clearBoard(board);
					updateBoard(board);
					if (board.getBoard()[coordonnee[0]][coordonnee[1]].getValueOfPawn()==Pawn.getPossiblePawn()) {
						ActionPlayer(board, new Pawn(-1), coordonnee);
						refreshAll(board,contentPane);
						errMsg.setText("");
						turnLeft--;
					}
					else errMsg.setText("Unvalid");
				}
				else if(turnLeft%2 == 1 && turnLeft != 0 && !iaBool) {
					board.AllValidMove(new Pawn(1));
					if(!board.isAnyMoveLeft(new Pawn(1))){
						String nom = board.PointCounter(new Pawn(-1)) > board.PointCounter(new Pawn(1)) ? "Black" : "White";
						JOptionPane.showMessageDialog(null,"Game ended ! Congratz to "+nom);
						}
					clearBoard(board);
					updateBoard(board);
					if (board.getBoard()[coordonnee[0]][coordonnee[1]].getValueOfPawn()==Pawn.getPossiblePawn()) {
						ActionPlayer(board, new Pawn(1), coordonnee);
						refreshAll(board,contentPane);
						errMsg.setText("");
						turnLeft--;
					}
					else errMsg.setText("Unvalid");
				}
				else if(turnLeft%2 == 0 && turnLeft != 0 && iaBool) {
					board.AllValidMove(new Pawn(-1));
					if(!board.isAnyMoveLeft(new Pawn(-1))){
						String nom = board.PointCounter(new Pawn(-1)) > board.PointCounter(new Pawn(1)) ? "Black" : "White";
						JOptionPane.showMessageDialog(null,"Game ended ! Congratz to "+nom);
						}
					clearBoard(board);
					updateBoard(board);
					if (board.getBoard()[coordonnee[0]][coordonnee[1]].getValueOfPawn()==Pawn.getPossiblePawn()) {
						ActionPlayer(board, new Pawn(-1), coordonnee);
						board.AllValidMove(new Pawn(1));
						search : {
							for (int i = 0; i <= 7; i++) {
								for (int j = 0; j <= 7; j++) {
									if (board.getBoard()[i][j].getValueOfPawn()==Pawn.getPossiblePawn()) {
										board.flipPawn(i, j, new Pawn(1));
										turnLeft--;
										break search;
									}
								}
							}
						}
						refreshAll(board,contentPane);
						errMsg.setText("");
						turnLeft--;
					}
					else errMsg.setText("Unvalid");
				}
				else{
					refreshBoard(contentPane);
				}
				refreshAll(board,contentPane);
		}
	}
	/**
	 * @param board
	 */
	public void clearBoard(Board board) {
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				contentPane.remove(btn[i-3][j-2]);
			}
		}
	}
	public void btnTemplate(JButton btn, GridBagConstraints gbc,int i,int j){
		btn.setBackground(new Color(0,180,0));
		btn.setPreferredSize(new Dimension(45, 45));
		gbc.gridx = i;
		gbc.gridy = j;
		gbc.fill = GridBagConstraints.BOTH;
	}
	public void updateBoard(Board board) {
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				btn[i-3][j-2] = new JButton();
				GridBagConstraints gbc_btn = new GridBagConstraints();
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==0){
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==-1){
					Icon b = new ImageIcon(getClass().getResource("/bd.png"));
					btn[i-3][j-2].setIcon(b);
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==1){
					Icon b = new ImageIcon(getClass().getResource("/wd.png"));
					btn[i-3][j-2].setIcon(b);
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==2){
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
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
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==-1){
					Icon b = new ImageIcon(getClass().getResource("/bd.png"));
					btn[i-3][j-2].setIcon(b);
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==1){
					Icon b = new ImageIcon(getClass().getResource("/wd.png"));
					btn[i-3][j-2].setIcon(b);
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==2){
					btnTemplate(btn[i-3][j-2], gbc_btn, i, j);
					btn[i-3][j-2].setBackground(new Color(0,150,150));
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
			turn.setText("White");
		}
		if(turnLeft%2 == 0){
			turn.setText("Black");
		}
	}
	public void refreshAll(Board board, JPanel contentPane){
		clearBoard(board);
		updateBoard(board);
		updatePlayerTurn();
		updateScore();
		refreshBoard(contentPane);
	}
}