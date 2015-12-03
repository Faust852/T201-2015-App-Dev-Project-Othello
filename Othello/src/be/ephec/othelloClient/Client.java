package be.ephec.othelloClient;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.omg.CORBA.portable.UnknownException;

public class Client extends Socket {
	
	// Obliger de throw parce que sinon Super() ne sera plus la première ligne
	public Client() throws UnknownException, IOException{
		super("127.0.0.1", Param.NUMPORTDEBASE);
	}
	
	public Client(String ip) throws UnknownException, IOException{
		super(ip, Param.NUMPORTDEBASE);
	}
	
	public Client(String ip, int port) throws UnknownHostException, IOException {
		super(ip, port);
	}
	
	public static void main(String[] args) {
		try {
			Client mc = new Client();
			ObjectOutputStream oos = new ObjectOutputStream(mc.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(mc.getInputStream());
			oos.writeObject("Bonjour du client");
			while(!mc.isClosed()){
				System.out.println(ois.readObject());
			}
		} catch (UnknownException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
