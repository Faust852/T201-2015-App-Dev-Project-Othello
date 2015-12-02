package be.ephec.othelloServer;

import java.awt.Color;

public class Player {
	
	private int point;
	private int color;
	private String name;
	
	public Player(int color, int point, String name) {
		this.point = point;
		this.color = color;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
}
