package be.ephec.interfaceGraphique.serveur;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import be.ephec.othelloServer.ApplicationServeur;
import be.ephec.othelloServer.ClientCoteServeur;
import be.ephec.othelloClient.Param;
import be.ephec.othelloServer.ServeurSocket;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelAccueilServeur extends JPanel implements ActionListener {
	private ApplicationServeur applicationServeur;
	private ServeurSocket server;
	private JTextField jTextFieldNumPort;
	/**
	 * Create the panel.
	 * @param applicationServeur une référence vers l'application
	 */
	public JPanelAccueilServeur(ApplicationServeur applicationServeur) {
		this.applicationServeur = applicationServeur;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel jLabelNumPort = new JLabel("Numéro du port : ");
		GridBagConstraints gbc_jLabelNumPort = new GridBagConstraints();
		gbc_jLabelNumPort.insets = new Insets(0, 0, 5, 5);
		gbc_jLabelNumPort.anchor = GridBagConstraints.EAST;
		gbc_jLabelNumPort.gridx = 0;
		gbc_jLabelNumPort.gridy = 0;
		add(jLabelNumPort, gbc_jLabelNumPort);
		
		jTextFieldNumPort = new JTextField(Param.NUMPORTDEBASE+"");
		GridBagConstraints gbc_jTextFieldNumPort = new GridBagConstraints();
		gbc_jTextFieldNumPort.insets = new Insets(0, 0, 5, 0);
		gbc_jTextFieldNumPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldNumPort.gridx = 1;
		gbc_jTextFieldNumPort.gridy = 0;
		add(jTextFieldNumPort, gbc_jTextFieldNumPort);
		jTextFieldNumPort.setColumns(10);
		
		JButton jButtonDemarrer = new JButton("Démarrer le serveur");
		jButtonDemarrer.addActionListener(this);
		GridBagConstraints gbc_jButtonDemarrer = new GridBagConstraints();
		gbc_jButtonDemarrer.gridx = 1;
		gbc_jButtonDemarrer.gridy = 1;
		add(jButtonDemarrer, gbc_jButtonDemarrer);

	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			applicationServeur.setServeurSocket(
					ServeurSocket.getServeurPortLibreAPartirDUnNum(
							applicationServeur, Integer.parseInt(
									jTextFieldNumPort.getText())));
			JPanelPrincipalServeur jps = new JPanelPrincipalServeur(applicationServeur);
			applicationServeur.getInterfaceGraphiqueServeur().setJpanelServer(jps);
			applicationServeur.getInterfaceGraphiqueServeur().setContentPane(jps);	
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} 
	}

}

