package be.ephec.othelloClient;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.ephec.othelloServer.Board;
import be.ephec.othelloServer.Pawn;

public class ClientInterface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JButton btn[][] = new JButton[8][8];
	
	Pawn[][] bla=new Pawn[][]{
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(1),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
	};
	private Board board = new Board(bla);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInterface frame = new ClientInterface();
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
		setBounds(100, 100, 769, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 45, 11, 45, 45, 45, 45, 45, 45, 45, 45, 0, 53, 10, 0, 0, 0, 0, 57, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 45, 45, 45, 45, 45, 45, 45, 29, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblIp = new JLabel("IP");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 13;
		gbc_lblIp.gridy = 0;
		contentPane.add(lblIp, gbc_lblIp);
		
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 14;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblA = new JLabel("A");
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 3;
		gbc_lblA.gridy = 1;
		contentPane.add(lblA, gbc_lblA);
		
		JLabel lblB = new JLabel("B");
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 4;
		gbc_lblB.gridy = 1;
		contentPane.add(lblB, gbc_lblB);
		
		JLabel lblC = new JLabel("C");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 5;
		gbc_lblC.gridy = 1;
		contentPane.add(lblC, gbc_lblC);
		
		JLabel lblD = new JLabel("D");
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 6;
		gbc_lblD.gridy = 1;
		contentPane.add(lblD, gbc_lblD);
		
		JLabel lblE = new JLabel("E");
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 7;
		gbc_lblE.gridy = 1;
		contentPane.add(lblE, gbc_lblE);
		
		JLabel lblF = new JLabel("F");
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.insets = new Insets(0, 0, 5, 5);
		gbc_lblF.gridx = 8;
		gbc_lblF.gridy = 1;
		contentPane.add(lblF, gbc_lblF);
		
		JLabel lblG = new JLabel("G");
		GridBagConstraints gbc_lblG = new GridBagConstraints();
		gbc_lblG.insets = new Insets(0, 0, 5, 5);
		gbc_lblG.gridx = 9;
		gbc_lblG.gridy = 1;
		contentPane.add(lblG, gbc_lblG);
		
		JLabel lblH = new JLabel("H");
		GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 10;
		gbc_lblH.gridy = 1;
		contentPane.add(lblH, gbc_lblH);
		
		JLabel lblPort = new JLabel("Port");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 13;
		gbc_lblPort.gridy = 1;
		contentPane.add(lblPort, gbc_lblPort);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 14;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("1");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 2;
		contentPane.add(label, gbc_label);
		
		JButton btnConnect = new JButton("Connect");
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConnect.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnect.gridwidth = 5;
		gbc_btnConnect.gridx = 14;
		gbc_btnConnect.gridy = 2;
		contentPane.add(btnConnect, gbc_btnConnect);
		
		JLabel label_1 = new JLabel("2");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 3;
		contentPane.add(label_1, gbc_label_1);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridheight = 7;
		gbc_textArea.gridwidth = 6;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 13;
		gbc_textArea.gridy = 3;
		contentPane.add(textArea, gbc_textArea);
		
		JLabel label_2 = new JLabel("3");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 4;
		contentPane.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("4");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 5;
		contentPane.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("5");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 6;
		contentPane.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("6");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 7;
		contentPane.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("7");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 8;
		contentPane.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("8");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 2;
		gbc_label_7.gridy = 9;
		contentPane.add(label_7, gbc_label_7);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 13;
		gbc_textField_2.gridy = 10;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnChat = new JButton("Chat");
		GridBagConstraints gbc_btnChat = new GridBagConstraints();
		gbc_btnChat.gridx = 18;
		gbc_btnChat.gridy = 10;
		contentPane.add(btnChat, gbc_btnChat);
		
		for(int i = 3; i<11; i++){
			for(int j =2; j<10; j++){
				btn[i-3][j-2] = new JButton();
				GridBagConstraints gbc_btn = new GridBagConstraints();
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==0){
					btn[i-3][j-2].setBackground(new Color(0,180,0));
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==-1){
					btn[i-3][j-2].setBackground(Color.BLACK);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==1){
					btn[i-3][j-2].setBackground(Color.WHITE);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				if(board.getBoard()[i-3][j-2].getValueOfPawn()==2){
					btn[i-3][j-2].setBackground(Color.BLUE);
					gbc_btn.gridx = i;
					gbc_btn.gridy = j;
					gbc_btn.fill = GridBagConstraints.BOTH;
				}
				btn[i-3][j-2].addActionListener(this);
				btn[i-3][j-2].setName("" + i + "," + j);
				btn[i-3][j-2].setSize(5, 5);
				contentPane.add(btn[i-3][j-2],gbc_btn);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
