package be.ephec.othelloServer;

import java.awt.Color;

public class Player {
	
	private int point;
	private Color color;
	
	public Player(Color color) {
		this.point = 0;
		this.color = color;
	}

	public int getPoint() {
		return point;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
}
