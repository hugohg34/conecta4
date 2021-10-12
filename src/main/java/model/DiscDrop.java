package model;

import types.Color;

public class DiscDrop {
	private Color color;
	private int column;
	private int row;
	
	public DiscDrop(Color color, int column) {
		this.color = color;
		this.column = column;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRow() {
		return row;
	}

}
