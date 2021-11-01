package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Board;
import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.BoardView;
import usantatecla.utils.views.Console;

public class BoardConsoleView extends BoardView {

	@Override
	public void write() {
		Console.getInstance().writeln(Message.HORIZONTAL_LINE.toString());
		for(int i = 0; i < Board.ROWS * Board.COLUMNS; i++) {
			if(i != 0 && i % Board.COLUMNS == 0) {
				Console.getInstance().writeln();
			}
			Console.getInstance().write("| ");
			Console.getInstance().write(this.colors.get(i).print());
			Console.getInstance().write(" |");		
		}
		Console.getInstance().writeln();
		Console.getInstance().writeln(Message.HORIZONTAL_LINE.toString());
	}

}
