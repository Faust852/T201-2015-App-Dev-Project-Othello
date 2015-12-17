package be.ephec.othello.network;
import java.io.Serializable;

/**
 * Just defines the type of Message
 * @authors Adrien Culem and David Micciche
 */
public class ChatMessage implements Serializable {
	
	protected static final long serialVersionUID = 1112122200L;

	public static final int MESSAGE = 1;
	private int type;
	private String message;
	

	/**
	 * The constructor
	 */
	public ChatMessage(int type, String message) {
		this.type = type;
		this.message = message;
	}
	
	public int getType() {
		return type;
	}
	public String getMessage() {
		return message;
	}
}
