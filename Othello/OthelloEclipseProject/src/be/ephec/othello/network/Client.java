package be.ephec.othello.network;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import be.ephec.othello.local.ClientInterface2;


/**
 * A network Client (He can run both in a console or a GUI)
 * The console way, was for testing before we make the GUI 
 * @author Adrien Culem and David Micciche
 */
public class Client  {

	private ObjectInputStream sInput;		// to read from the socket
	private ObjectOutputStream sOutput;		// to write on the socket
	private Socket socket;

	private ClientInterface2 cg;
	
	private String server, username;
	private int port;


	/**
	 * The constructor for a console client
	 * @param server the Ip of the server
	 * @param port of creation
	 * @param username you want to use
	 */
	public Client(String server, int port, String username) {
		// which calls the common constructor with the GUI set to null
		this(server, port, username, null);
	}

	
	/**
	 * The constructor for a GUI client
	 * @param server the Ip of the server
	 * @param port of creation
	 * @param username you want to use
	 * @param cg is the GUI 
	 */
	public Client(String server, int port, String username, ClientInterface2 cg) {
		this.server = server;
		this.port = port;
		this.username = username;
		// save if we are in GUI mode or not
		this.cg = cg;
	}
	
	
	/**
	 * To launch a new Socket (When you connect) 
	 * @return a boolean to manage if the connection worked or not
	 */
	public boolean start() {
		try {
			socket = new Socket(server, port);
		} 
		catch(Exception ec) {
			display("Error connectiong to server:" + ec);
			return false;
		}
		
		String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
		display(msg);
		try
		{
			//input first
			sInput  = new ObjectInputStream(socket.getInputStream());
			sOutput = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			display("Exception creating new Input/output Streams: " + eIO);
			return false;
		}
		new ListenFromServer().start();
		try
		{
			sOutput.writeObject(username);
		}
		catch (IOException eIO) {
			display("Exception doing login : " + eIO);
			disconnect();
			return false;
		}
		return true;
	}

	/**
	 * Send the message in param to the GUI or the console 
	 * @param msg is what you want to send to the GUI or the console
	 */
	private void display(String msg) {
		if(cg == null)
			System.out.println(msg);     //For the console
		else
			cg.append(username+" : "+msg + "\n");		//For the GUI
	}
	
	
	/**
	 * Send the message in param to the server
	 * @param msg is what you want to send to the server
	 */
	public void sendMessage(ChatMessage msg) {
		try {
			sOutput.writeObject(msg);
		}
		catch(IOException e) {
			display("Exception writing to server: " + e);
		}
	}

	
	/**
	 * Whenever something goes wrong close the output/input streams
	 * and the socket
	 */
	private void disconnect() {
		try { 
			if(sInput != null) sInput.close();
		}
		catch(Exception e) {}
		try {
			if(sOutput != null) sOutput.close();
		}
		catch(Exception e) {}
        try{
			if(socket != null) socket.close();
		}
		catch(Exception e) {}
		
		if(cg != null)
			cg.connectionFailed();
			
	}
	/*
	 * To start the Client in console mode use one of the following command
	 * > java Client
	 * > java Client username
	 * > java Client username portNumber
	 * > java Client username portNumber serverAddress
	 * at the console prompt
	 * If the portNumber is not specified 1500 is used
	 * If the serverAddress is not specified "localHost" is used
	 * If the username is not specified "Anonymous" is used
	 * > java Client 
	 * is equivalent to
	 * > java Client Anonymous 1500 localhost 
	 * In console mode, if an error occurs the program simply stops
	 * when a GUI id used, the GUI is informed of the disconnection
	 */
	public static void main(String[] args) {
		
		int portNumber = 1500;
		String serverAddress = "localhost";
		String userName = "Anonymous";

		
		switch(args.length) {
			case 3:
				serverAddress = args[2];
			case 2:
				try {
					portNumber = Integer.parseInt(args[1]);
				}
				catch(Exception e) {
					System.out.println("Invalid port number.");
					System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
					return;
				}
			case 1: 
				userName = args[0];
			case 0:
				break;
			default:
				System.out.println("Usage is: > java Client [username] [portNumber] {serverAddress]");
			return;
		}
		Client client = new Client(serverAddress, portNumber, userName);
		
		if(!client.start())
			return;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("> ");
			String msg = scan.nextLine();
				client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
				break;
		}
		client.disconnect();	
	}

	/**
	 * Wait for a message and append it to the console or the GUI
	 * @authors Adrien Culem and David Micciche
	 */
	public class ListenFromServer extends Thread {

		public void run() {
			while(true) {
				try {
					String msg = (String) sInput.readObject();
					if(cg == null) {
						System.out.println(msg);
						System.out.print("> ");
					}
					else {
						cg.append(msg);
					}
				}
				catch(IOException e) {
					display("Server has close the connection: " + e);
					if(cg != null) 
						cg.connectionFailed();
					break;
				}
				catch(ClassNotFoundException e2) {
				}
			}
		}
	}
}
