package be.ephec.othelloServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientCoteServer {
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int num;
	
	public ClientCoteServer(Socket socket, int num) throws IOException {
		this.socket = socket;
		this.num = num;
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(num);
	}
	
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object lire(){
		try {
			return ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}
