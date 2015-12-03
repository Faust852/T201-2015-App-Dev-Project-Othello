package be.ephec.othelloServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends ServerSocket implements Runnable{
	
	private ArrayList<ClientCoteServer> listeClients = new ArrayList<ClientCoteServer>();
	private int nbClient = 0;
	
	public Server(int numPort) throws IOException{
		super(numPort);
		System.out.println("Le serveur écoute sur le port " + this.getLocalPort());
		acceptePlusieursClients();
	}
	
	public Server() throws IOException{
		super(Param.NUMPORTDEBASE);
		System.out.println("Le serveur écoute sur le port " + this.getLocalPort());
		acceptePlusieursClients();
	}
	
	public static Server getServeurPortLibre(){
		Server ms = null;
		for (int numPort = Param.NUMPORTDEBASE ; numPort <= 65535 ; numPort++){
			try {
				ms = new Server(numPort);
				ms.acceptePlusieursClients();
				break;
			} catch (IOException e){}
		}
		return ms;
	}
	
	public static Server getServeurPortLibre(int numPortDepart){
		Server ms = null;
		for (int numPort = numPortDepart ; numPort <= 65535 ; numPort++){
			try {
				ms = new Server(numPort);
				ms.acceptePlusieursClients();
				break;
			} catch (IOException e){}
		}
		return ms;
	}
	
	public void acceptePlusieursClients(){
		Thread t = new Thread(this);
		t.start();
	}
	
	public static void main(String [] args){
		Server ms = Server.getServeurPortLibre();
	}

	@Override
	public void run() {
		while(!this.isClosed()){
			try {
				this.listeClients.add(new ClientCoteServer(this.accept(), ++nbClient));
				System.out.println(this.listeClients.get(nbClient-1).lire());
				System.out.println("On a reçu un client");
				for(ClientCoteServer client: listeClients){
					client.ecrire("Nous avons un nouveau client connecté ; soit au total " + this.listeClients.size());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
