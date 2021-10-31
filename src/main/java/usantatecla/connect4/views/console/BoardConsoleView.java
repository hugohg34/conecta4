package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Board;
import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.BoardView;
import usantatecla.utils.views.Console;

public class BoardConsoleView extends BoardView {

	@Override
	public void write() {
		Console.getInstance().writeln(Message.HORIZONTAL_LINE.toString());
		for (int i = 0; i < Board.ROWS; i++) {
			Console.getInstance().write(Message.VERTICAL_LINE.toString());
			for (int j = 0; j < Board.COLUMNS; j++) {
				Console.getInstance().write(this.colors.get(i * Board.ROWS + j).print());
				Console.getInstance().write(Message.VERTICAL_LINE.toString());
			}
			Console.getInstance().writeln();
		}
		Console.getInstance().writeln(Message.HORIZONTAL_LINE.toString());

	}

}
