package be.ephec.othello.local;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import be.ephec.othello.network.Server;


/**
 * That create a GUI for the server, it displays the logs and the message 
 * coming from clients 
 * @author Adrien Culem and David Micciche
 */
public class ServerGUI extends JFrame implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton stopStart;
	
	private JTextArea chat, event;
	
	private JTextField tPortNumber;
	
	private Server server;
	
	
	/**
	 * The constructor 
	 * @param port to listen
	 */
	public ServerGUI(int port) {
		super("Chat Server");
		server = null;
		JPanel north = new JPanel();
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
		stopStart = new JButton("Start");
		stopStart.addActionListener(this);
		north.add(stopStart);
		add(north, BorderLayout.NORTH);
		
		// the event and chat room
		JPanel center = new JPanel(new GridLayout(2,1));
		chat = new JTextArea(80,80);
		chat.setEditable(false);
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(chat));
		event = new JTextArea(80,80);
		event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));	
		add(center);
		
		addWindowListener(this);
		setSize(400, 600);
		setVisible(true);
	}		

	
	/**
	 * Display chat 
	 * @param str is what it will display
	 */
	public void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}
	/**
	 * Display the events
	 * @param str is what it will display
	 */
	public void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(server != null) {
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			stopStart.setText("Start");
			return;
		}
      		
		int port;
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Invalid port number");
			return;
		}
		
		server = new Server(port, this);
		
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
	}
	
	public static void main(String[] arg) {
		new ServerGUI(1500);
	}


    //Close the connection when closing the windows
	public void windowClosing(WindowEvent e) {
		
		if(server != null) {
			try {
				server.stop();			
			}
			catch(Exception eClose) {
			}
			server = null;
		}
		dispose();
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

	
	/**
	 * @authors Adrien Culem and David Micciche
	 * A thread to run the server
	 */
	public class ServerRunning extends Thread {
		public void run() {
			server.start();    
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
		}
	}

}
