package view;

import java.util.List;

import model.Board;
import model.DiscDrop;
import utils.Console;

public class BoardView {

	private Board board;

	public void show() {
		assert (board != null);
		
		
		for(int i = Board.ROWS; i >= 0; --i) {
			for(int j = 0; j < Board.COLUMNS; j++) {
				List<DiscDrop> columList = board.getDiscDropList().get(j);
				if(columList.size() > i) {
					Console.getInstance().print(" " + columList.get(i).getColor().toString() + " ");
				}else {
					Console.getInstance().print(" o ");
				}
			}
			Console.getInstance().println("");
		}
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
