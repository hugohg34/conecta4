package view.console;

import model.Board;
import utils.Console;
import view.BoardView;

public class ConsoleBoardView implements BoardView {

	private Board board;
	private Console console = Console.getInstance();
	private String cellFormat = "| %s |";
	String separator = String.format("|%33s|", "").replace(" ", "-");

	@Override
	public void show() {
		assert (this.board != null);		
		printHeader();
		for (int row = Board.ROWS; row > 0; row--) {
			for (int column = 1; column <= Board.COLUMNS; column++) {
				char discChar = this.board.getDisc(column, row).getChar();
				this.console.print(String.format(cellFormat, discChar));
			}
			console.println("");
		}
		printFooter(separator);
		
	}

	private void printFooter(String separator) {
		console.println(separator);
		for (int column = 1; column <= Board.COLUMNS; column++) {
			this.console.print(String.format(cellFormat, column));
		}
		console.println("");
		console.println(separator);
	}

	private void printHeader() {
		this.console.println(separator);
		this.console.println(String.format("|%14s%s%14s|", "", "BOARD", ""));
		this.console.println(separator);
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

}