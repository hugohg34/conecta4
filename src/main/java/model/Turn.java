package model;

import java.util.Random;

import types.Color;

public class Turn {
	
	private int colorIndex;
	
	public Turn(){
		this.colorIndex = new Random().nextInt(Color.values().length);
	}

	public Color getColor() {
		return Color.values()[this.colorIndex];
	}
	
	public void change() {
		this.colorIndex = (this.colorIndex + 1)  % Color.values().length;
	}

}
