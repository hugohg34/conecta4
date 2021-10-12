package view;

import java.util.List;

import model.Board;
import model.DiscDrop;
import utils.Console;

public class BoardView {

	private Board board;

	public void show() {
		assert (board != null);
		for(List<DiscDrop> columList: board.getDiscDropList()) {
			for(DiscDrop dd: columList) {
				Console.getInstance().print(
						dd.getColor().toString()
						+ dd.getColumn());
			}
		}

	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
