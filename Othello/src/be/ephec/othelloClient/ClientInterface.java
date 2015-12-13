package be.ephec.othelloClient;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import be.ephec.othelloServer.Board;
import be.ephec.othelloServer.Pawn;

public class ClientInterface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtMsg;
	private JTextArea textArea;
	private JLabel lblIp;
	private JLabel lblPort;
	private JButton btnConnect;
	private JButton btnChat;
	
	private JButton btn[][] = new JButton[8][8];
	private JLabel lbl[] = new JLabel[8];
	private JLabel lbltxt[] = new JLabel[8];
	
	private Client client1;
	
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
	private Board board = new Board();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public ClientInterface(Client client1) {
		this.client1 = client1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
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
		
		lblIp = new JLabel("IP");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 13;
		gbc_lblIp.gridy = 0;
		contentPane.add(lblIp, gbc_lblIp);
		
		
		txtIp = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 14;
		gbc_textField.gridy = 0;
		contentPane.add(txtIp, gbc_textField);
		txtIp.setColumns(10);
		
		lblPort = new JLabel("Port");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 13;
		gbc_lblPort.gridy = 1;
		contentPane.add(lblPort, gbc_lblPort);
		
		txtPort = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 14;
		gbc_textField_1.gridy = 1;
		contentPane.add(txtPort, gbc_textField_1);
		txtPort.setColumns(10);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(this);
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConnect.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnect.gridwidth = 5;
		gbc_btnConnect.gridx = 14;
		gbc_btnConnect.gridy = 2;
		contentPane.add(btnConnect, gbc_btnConnect);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 13;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setViewportView(textArea);
		
		txtMsg = new JTextField();
		GridBagConstraints gbc_txtMsg = new GridBagConstraints();
		gbc_txtMsg.gridwidth = 5;
		gbc_txtMsg.insets = new Insets(0, 0, 0, 5);
		gbc_txtMsg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMsg.gridx = 13;
		gbc_txtMsg.gridy = 10;
		contentPane.add(txtMsg, gbc_txtMsg);
		txtMsg.setColumns(10);
		
		btnChat = new JButton("Chat");
		GridBagConstraints gbc_btnChat = new GridBagConstraints();
		btnChat.addActionListener(this);
		gbc_btnChat.gridx = 18;
		gbc_btnChat.gridy = 10;
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
				btn[i-3][j-2].setName("" + (i-3) + "," + (j-2));
				btn[i-3][j-2].setSize(5, 5);
				contentPane.add(btn[i-3][j-2],gbc_btn);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String position = ((JButton)e.getSource()).getName();
		
		switch(e.getActionCommand()){
		case "Connect" : ClientSocket client;
			try {
				client = new ClientSocket(txtIp.getText(), Integer.parseInt(txtPort.getText()), client1);
				client.lireNonStop();
			
				client1.setSocket(client);
				client1.connexionSuccess();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				ajouteDuChat("Le serveur ne répond pas. Essayez plus tard.");
			}
			break;
		case "Chat" : client1.sendObject(txtMsg.getText());
					ajouteDuChat(txtMsg.getText());
					break;
		default: client1.sendObject(position);
		this.ajouteDuChat(position);
		}
		
		int nbClient = client1.getNbClients(); 
		if(nbClient == 1){
			btnConnect.setEnabled(false);
		}
	}
	
	public void ajouteDuChat(String s){
		textArea.append(Console.getInviteDeCommande()+ s +"\n");
		textArea.setCaretPosition(textArea.getText().length());
	}

}
