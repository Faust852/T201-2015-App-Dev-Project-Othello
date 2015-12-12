package be.ephec.interfaceGraphique.serveur;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.ephec.othelloServer.ApplicationServeur;
import be.ephec.othelloServer.ClientCoteServeur;

public class InterfaceGraphiqueServeur extends JFrame {

	private JPanel jpanelServer;
	private ApplicationServeur ma;
	
	public InterfaceGraphiqueServeur(ApplicationServeur ma) {
		this.ma = ma;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Serveur");
		setBounds(0, 0, 300, 500);
		jpanelServer = new JPanelAccueilServeur(ma);
		setContentPane(jpanelServer);
		this.setVisible(true);
	}
	
	public void ajouteDansLaConsole(String s){
		JPanelPrincipalServeur jps = (JPanelPrincipalServeur) jpanelServer;
		jps.ajouteDansLaConsole(s);
	}
	public void ajouteClientJComboBox(ClientCoteServeur client){
		JPanelPrincipalServeur jps = (JPanelPrincipalServeur) jpanelServer;
		jps.ajouteClientJComboBox(client);
	}
	public void supprimeClientJComboBox(ClientCoteServeur client){
		JPanelPrincipalServeur jps = (JPanelPrincipalServeur) jpanelServer;
		jps.ajouteClientJComboBox(client);
	}
	public JPanel getJpanelServer() {
		return jpanelServer;
	}
	public void setJpanelServer(JPanel jpanelServer) {
		this.jpanelServer = jpanelServer;
	}
}
