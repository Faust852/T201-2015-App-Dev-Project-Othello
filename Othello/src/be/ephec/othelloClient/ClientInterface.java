package be.ephec.othelloClient;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.UnknownException;

import be.ephec.othelloServer.Board;
import be.ephec.othelloServer.GameController;
import be.ephec.othelloServer.Pawn;

public class ClientInterface extends JFrame implements ActionListener {

	private JPanel contentPane = new JPanel();
	private JPanel contentGrid= new JPanel();
	private JPanel contentMenu = new JPanel();
	private JButton btn[][] = new JButton[8][8];
	private JButton btnConnect = new JButton();
	private JLabel scoreBlanc = new JLabel();
	private JLabel scoreNoir = new JLabel();
	private JTextField txtIp = new JTextField();
	private GridBagConstraints c;
	
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
	Pawn[][] bla1=new Pawn[][]{
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(0)},
		{new Pawn(0),new Pawn(-1),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(1),new Pawn(1),new Pawn(-1),new Pawn(1),new Pawn(1),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(0),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0)},
		{new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(0),new Pawn(-1),new Pawn(1),new Pawn(0)},
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
					frame.setTitle("Othello");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public ClientInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setResizable(false);
		contentGrid.setBorder(new EmptyBorder(10,10,10,10));
		contentGrid.setLayout(new GridLayout(9,8));
		board.AllValidMove(new Pawn(-1));
		for(int i = 0; i<8; i++){
			for(int j =0; j<8; j++){
				btn[i][j] = new JButton();
				if(board.getBoard()[i][j].getValueOfPawn()==0){
					btn[i][j].setBackground(new Color(0,180,0));
				}
				if(board.getBoard()[i][j].getValueOfPawn()==-1){
					btn[i][j].setBackground(Color.BLACK);
				}
				if(board.getBoard()[i][j].getValueOfPawn()==1){
					btn[i][j].setBackground(Color.WHITE);
				}
				if(board.getBoard()[i][j].getValueOfPawn()==2){
					btn[i][j].setBackground(Color.BLUE);
				}
				btn[i][j].addActionListener(this);
				btn[i][j].setName("" + i + "," + j);
				btn[i][j].setSize(5, 5);
				contentGrid.add(btn[i][j]);
			}
		}
		
		btnConnect.setText("Connection");
		btnConnect.setForeground(Color.white);
		btnConnect.addActionListener(this);
		btnConnect.setSize(100,50);
		btnConnect.setBorder(new EmptyBorder(10,10,10,10));
		btnConnect.setBackground(Color.BLACK);
		
		scoreBlanc.setText(" " +" Blanc : ");
		scoreBlanc.setForeground(Color.black);
		scoreNoir.setText(" " +" Noir : ");
		scoreNoir.setForeground(Color.black);
		
		contentGrid.add(btnConnect);
		contentGrid.add(txtIp);
		
		contentGrid.add(scoreBlanc);
		contentGrid.add(scoreNoir);
		
/*		btn[4][3].setBackground(Color.black);
		btn[3][3].setBackground(Color.white);
		btn[3][4].setBackground(Color.black);
		btn[4][4].setBackground(Color.white);*/
		
		
		getContentPane().add(contentGrid);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bg = (JButton)e.getSource();
		String tileClicked = bg.getName();
		System.out.println(tileClicked);
		switch(e.getActionCommand()){
		case "Connection" : 
			Client client;
			try {
				client = new Client();
			} catch (UnknownException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			break;
		}
	}
}
