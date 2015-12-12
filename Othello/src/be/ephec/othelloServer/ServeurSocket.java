package be.ephec.othelloServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ServeurSocket extends ServerSocket implements Runnable {
	private ApplicationServeur ma;
	private ArrayList<ClientCoteServeur> listeClients = new ArrayList<ClientCoteServeur>();
	private int nbClients = 0;
	/**
	 * Constructeur qui permet de démarrer un serveur TCP sur un numéro de port donné
	 * @param numPort le numéro de port sur lequel le serveur va écouter
	 * @throws IOException
	 */
	public ServeurSocket(int numPort,ApplicationServeur ma) throws IOException {
		super(numPort);
		this.ma = ma;
		//System.out.println("le serveur écoute sur "+this.getLocalPort());
		acceptePlusieursClients();
	}
	/**
	 * Constructeur qui permet de démarrer un serveur TCP sur le numéro de port se trouvant 
	 * dans la classe Param
	 * @throws IOException
	 */
	public ServeurSocket(ApplicationServeur ma) throws IOException {
		super(Param.NUMPORTDEBASE);
		this.ma = ma;
		//System.out.println("le serveur écoute sur "+this.getLocalPort());
		acceptePlusieursClients();
	}
	/**
	 * Méthode qui permet de créer un serveur TCP sur un numéro de port libre à partir du 
	 * numéro de port indiqué dans la classe Param
	 * Tous les numéros de port sont testés à partir de Param.NUMPORTDEBASE jusqu'à 65535
	 * @return le serveur TCP
	 */
	public static ServeurSocket getServeurPortLibre(ApplicationServeur ma){
		ServeurSocket ms = null;
		for (int numPort = Param.NUMPORTDEBASE ; numPort<=65535 ; numPort++){
			try{
				ms = new ServeurSocket(numPort,ma);
				ms.acceptePlusieursClients();
				break;
			}catch (IOException ioe){
			}
		}
		return ms;
	}
	/**
	 * Méthode qui permet de créer un serveur TCP sur un numéro de port libre à partir du 
	 * numéro de port reçu en paramètre
	 * Tous les numéros de port sont testés à partir de Param.NUMPORTDEBASE jusqu'à 65535
	 * @param numPortDepart un entier compris entre 1 et 65536. Ce sera le numéro de port 
	 * à partir duquel on cherche un port libre pour notre application
	 * @return le serveur TCP
	 * 
	 */
	public static ServeurSocket getServeurPortLibreAPartirDUnNum(ApplicationServeur ma,int numPortDepart){
		ServeurSocket ms = null;
		for (int numPort = numPortDepart ; numPort<=65535 ; numPort++){
			try{
				ms = new ServeurSocket(numPort,ma);
				ms.acceptePlusieursClients();
				break;
			}catch (IOException ioe){
			}
		}
		return ms;
	}
	/**
	 * Méthode qui attend des clients pour les ajouter à la liste des clients connectés
	 */
	public synchronized void acceptePlusieursClients(){
		// le code était ici
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Juste pour tester en console que ça fonctionne
	 * Normalement on exécute la méthode main de la classe MonApplication
	 * @param args pas utilisé
	 */
	public static void main(String[] args) {
		ServeurSocket ms = ServeurSocket.getServeurPortLibre(null);
		
	}
	public void ecrireSurUnClient(ClientCoteServeur ccs, Object o){
		ccs.ecrire(o);
	}
	public void ecrirSurTousLesClients(Object o){
		for (ClientCoteServeur clientCoteServeur : listeClients) {
			clientCoteServeur.ecrire(o);
		}
	}
	public Object lireSurUnClient(int num){
		return listeClients.get(num).lire();
	}
	@Override
	public void run() {
		while (!this.isClosed()){
			try {
				ClientCoteServeur ccs = new ClientCoteServeur(this.accept(),++nbClients,ma);
				this.listeClients.add(ccs);
				ma.traiteClientConnecte(ccs);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

