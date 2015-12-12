package be.ephec.othelloServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientCoteServeur implements Runnable{
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int num;
	private ApplicationServeur appliServeur;
	
	public String toString(){
		return "Client numéro "+num;
	}
	
	public int getNum() {
		return num;
	}

	public ClientCoteServeur(Socket socket, int num, ApplicationServeur appliServeur) throws IOException{
		this.appliServeur = appliServeur;
		this.socket = socket;
		this.num = num;
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(num); // on envoie son numéro au client
		new Thread(this).start();
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
			return ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run() {
		while (!socket.isClosed()){
			try {
				Object object = ois.readObject();
				appliServeur.traiteObjetRecu(this, object);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				try {
					//TODO à améliorer
					socket.close();
					//TODO
					appliServeur.traiteClientDeconnecte(this);
					e.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		
	}
	
}