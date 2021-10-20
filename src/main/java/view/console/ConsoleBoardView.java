package view.console;

import controller.PlayController;
import model.Board;
import utils.Console;

public class ConsoleBoardView {

	private PlayController playController;
	private Console console = Console.getInstance();
	private String cellFormat = "| %s |";
	String separator = String.format("|%33s|", "").replace(" ", "-");

	public ConsoleBoardView(PlayController playController) {
		this.playController = playController;
	}

	public void show() {
		printHeader();
		printBody();
		printFooter(separator);

	}

	private void printBody() {
		for (int row = Board.ROWS; row > 0; row--) {
			for (int column = 1; column <= Board.COLUMNS; column++) {
				char discChar = this.playController.getDiscColor(column, row).getChar();
				this.console.print(String.format(cellFormat, discChar));
			}
			console.println("");
		}
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

}