package view.console;

import model.Board;
import utils.Console;

public class BoardView {

	private Board board;

	public void show() {
		assert (board != null);
		Console console = Console.getInstance();
		String separator = String.format("|%33s|", "").replace(" ", "-");
		console.println(separator);
		console.println(String.format("|%14s%s%14s|", "", "BOARD", ""));
		console.println(separator);
		for (int row = Board.ROWS; row > 0; row--) {
			for (int column = 1; column <= Board.COLUMNS; column++) {
				char discChar = board.getDisc(column, row).getChar();
				console.print(String.format("| %s |", discChar));
			}
			Console.getInstance().println("");
		}
		console.println(separator);
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
