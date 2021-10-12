package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	private List<DiscDrop> discDropList = new ArrayList<>(); 
	
	public boolean isFull() {
		return discDropList.size() == COLUMNS * ROWS;
	}

	public boolean isValidDropping() {
		// TODO Auto-generated method stub
		return true;
	}

	public void dropping(DiscDrop discDrop) {
		assert(isFull());
		this.discDropList.add(discDrop);
	}

}
