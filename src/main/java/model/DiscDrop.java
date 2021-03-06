package model;

import types.DiscColor;

public class DiscDrop {
	private DiscColor color;
	private int column;

	public DiscDrop(DiscColor color, int column) {
		this.color = color;
		this.column = column;
	}

	public DiscColor getColor() {
		return this.color;
	}

	public void setColor(DiscColor color) {
		this.color = color;
	}

	public int getColumn() {
		return this.column;
	}

}