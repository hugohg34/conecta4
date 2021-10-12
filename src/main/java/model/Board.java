package model;

import java.util.ArrayList;
import java.util.List;

import types.DiscColor;

public class Board {

	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	List<List<DiscDrop>> discDropList;

	public Board() {
		initBoard();
	}

	private void initBoard() {
		discDropList = new ArrayList<>();
		for (int i = 0; i < COLUMNS; i++) {
			discDropList.add(new ArrayList<>());
		}
	}

	public void dropping(DiscDrop discDrop) {
		this.discDropList.get(discDrop.getColumn() - 1).add(discDrop);
	}

	public DiscColor getDisc(int column, int row) {
		int columnIndex = column - 1;
		int rowIndex = row - 1;
		List<DiscDrop> columList = this.discDropList.get(columnIndex);
		DiscColor discColor = DiscColor.NULL;
		if (columList.size() > rowIndex) {
			discColor = columList.get(rowIndex).getColor();
		}
		return discColor;
	}

	public boolean isValidDropping(DiscDrop discDrop) {
		int column = discDrop.getColumn();
		if (column > COLUMNS) {
			return false;
		}
		if (column < 1) {
			return false;
		}
		return !isFullColumn(column - 1);
	}

	public boolean isFull() {
		for (int i = 0; i < COLUMNS; i++) {
			if (!isFullColumn(i)) {
				return false;
			}
		}
		return true;
	}

	private boolean isFullColumn(int columnIndex) {
		int columIndex = columnIndex;
		return discDropList.get(columIndex).size() >= ROWS;
	}

}