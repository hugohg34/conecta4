package model;

import java.util.ArrayList;
import java.util.List;

import controller.utils.WinnerRuleCord;
import types.DiscColor;

public class Board {

	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	private List<List<DiscDrop>> discDropList;
	private DiscDrop lastDiscDrop;

	public Board() {
		initBoard();
	}

	private void initBoard() {
		this.discDropList = new ArrayList<>();
		for (int i = 0; i < COLUMNS; i++) {
			this.discDropList.add(new ArrayList<>());
		}
	}

	public void dropping(DiscDrop discDrop) {
		int columnIndex = discDrop.getColumn() - 1;
		this.discDropList.get(columnIndex).add(discDrop);
		discDrop.setRow(this.discDropList.get(columnIndex).size());
		this.lastDiscDrop = discDrop;
		System.out.println("Last drop color: " + discDrop.getColor() + " col: " + discDrop.getColumn() + " row: " + discDrop.getRow());
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
		return this.discDropList.get(columIndex).size() >= ROWS;
	}

	public boolean isFourInLine() {
		WinnerRuleCord winnerRule = new WinnerRuleCord(this);
		return winnerRule.isFourInLine(this.lastDiscDrop);
	}

}