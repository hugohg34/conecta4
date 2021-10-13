package view.console;

import model.Board;
import utils.Console;
import view.BoardView;

public class ConsoleBoardView implements BoardView {

	private Board board;

	@Override
	public void show() {
		assert (this.board != null);
		Console console = Console.getInstance();
		String separator = String.format("|%33s|", "").replace(" ", "-");
		console.println(separator);
		console.println(String.format("|%14s%s%14s|", "", "BOARD", ""));
		console.println(separator);
		for (int row = Board.ROWS; row > 0; row--) {
			for (int column = 1; column <= Board.COLUMNS; column++) {
				char discChar = this.board.getDisc(column, row).getChar();
				console.print(String.format("| %s |", discChar));
			}
			Console.getInstance().println("");
		}
		console.println(separator);
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

}