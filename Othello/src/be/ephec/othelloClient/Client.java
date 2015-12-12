package be.ephec.othelloClient;

public class Client{
	private ClientSocket socket;
	private int num;
	private int nbClients = 0;
	private ClientInterface game;
	
	public Client(){
		game = new ClientInterface(this);
		game.setVisible(true);
		nbClients++;
	}

	public static void main(String[] args) {
		Client appliClient = new Client();
	}
	
	public void connexionSuccess(){
		game.ajouteDuChat("Le client est connect� au serveur");
	}
	
	public void receivedObject(Object o){
		game.ajouteDuChat(toString());
	}
	
	public void sendObject(Object o){
		socket.ecrire(o);
	}

	public ClientSocket getSocket() {
		return socket;
	}

	public void setSocket(ClientSocket socket) {
		this.socket = socket;
	}
	
	public ClientInterface getInterfaceGraphiqueClient() {
		return game;
	}
	public void setClientInterface (ClientInterface game) {
		this.game = game;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public int getNbClients() {
		return nbClients;
	}
	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}
}