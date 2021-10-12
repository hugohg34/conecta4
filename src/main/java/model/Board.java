package model;

import java.util.ArrayList;
import java.util.List;

import types.DiscColor;
import utils.Console;

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

	public boolean isFull() {
		for (int i = 0; i < COLUMNS; i++) {
			if (! isFullColumn(i)) {
				return false;
			}
		}
		return true;
	}

	private boolean isFullColumn(int index) {
		return discDropList.get(index).size() >= ROWS;
	}

	public boolean isValidDropping(DiscDrop discDrop) {
		int column = discDrop.getColumn();
		if(column > COLUMNS) {
			return false;
		}
		return !isFullColumn(column);
	}

	public void dropping(DiscDrop discDrop) {
		this.discDropList.get(discDrop.getColumn()).add(discDrop);
	}
	
	public List<List<DiscDrop>> getDiscDropList(){
		return discDropList;
	}
	
	public DiscColor getDisc(int column, int row) {
		int columnIndex = column -1;
		int rowIndex = row -1;
		List<DiscDrop> columList = this.discDropList.get(columnIndex);
		DiscColor discColor = discColor.NULL;
		if(columList.size() > rowIndex) {
			discColor = columList.get(rowIndex).getColor();
		}
		return discColor;
	}


}
