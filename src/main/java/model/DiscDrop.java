package model;

import types.DiscColor;

public class DiscDrop {
	private DiscColor color;
	private int column;
	private int row;
	
	public DiscDrop(DiscColor color, int column) {
		this.color = color;
		this.column = column;
	}

	public DiscColor getColor() {
		return color;
	}

	public void setColor(DiscColor color) {
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
