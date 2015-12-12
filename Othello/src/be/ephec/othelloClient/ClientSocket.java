package be.ephec.othelloClient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientSocket extends Socket implements Runnable {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Client client;
	
	
	public ClientSocket(Client client) throws UnknownHostException, IOException{
		super(Param.IP_SERVEUR,Param.NUMPORTDEBASE);
		this.client = client;
		methodeCommuneAuxConstructeurs();
	}
	public ClientSocket(String ip, int port, Client client) throws UnknownHostException, IOException{
		super(ip,port);
		this.client = client;
		methodeCommuneAuxConstructeurs();
	}
	public void methodeCommuneAuxConstructeurs(){
		try {
			oos = new ObjectOutputStream(this.getOutputStream());
			ois = new ObjectInputStream(this.getInputStream());
			client.setNum((int)ois.readObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	public void lireNonStop(){
		new Thread(this).start();
	}
	public void finalize(){
		try {
			this.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object lire(){
		try {
			Object o = ois.readObject();
			client.receivedObject(o);
			return o;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			try {
				this.close(); 
				// si on ne sait pas lire c'est que le serveur est fermé
				//TODO Trouver une solution moins radicale
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void run() {
		while (!this.isClosed()){
			Object o = this.lire();
		}
		
	}
}



