package be.ephec.othelloServer;
import java.util.Calendar;

public class Console {
	/**
	 * @return une chaîne de caractères représentant l'invite de commande comprenant l'heure suivi du signe >
	 */
	public static String getInviteDeCommande(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int seconde = cal.get(Calendar.SECOND);
		return hour+":"+minute+":"+seconde+"> ";
	}
}
