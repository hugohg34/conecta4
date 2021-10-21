package view.console;

import controller.BaseController;
import model.Board;
import utils.Console;

public class ConsoleBoardView {

	private static final String HEADER_TITLE = String.format("|%14s%s%14s|", "", "BOARD", "");
	private static final String SEPARATOR = "|---------------------------------|";
	private static final String CELLFORMAT = "| %s |";
	private Console console = Console.getInstance();

	public void show(BaseController baseController) {
		printHeader();
		printBody(baseController);
		printFooter(SEPARATOR);

	}

	private void printBody(BaseController baseController) {
		for (int row = Board.ROWS; row > 0; row--) {
			for (int column = 1; column <= Board.COLUMNS; column++) {
				char discChar = baseController.getDiscColor(column, row).getChar();
				this.console.print(String.format(CELLFORMAT, discChar));
			}
			console.println("");
		}
	}

	private void printFooter(String separator) {
		console.println(separator);
		for (int column = 1; column <= Board.COLUMNS; column++) {
			this.console.print(String.format(CELLFORMAT, column));
		}
		console.println("");
		console.println(separator);
	}

	private void printHeader() {
		this.console.println(SEPARATOR);
		this.console.println(HEADER_TITLE);
		this.console.println(SEPARATOR);
	}

}
