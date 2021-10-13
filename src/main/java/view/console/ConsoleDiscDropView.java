package view.console;

import model.DiscDrop;
import types.DiscColor;
import utils.Console;
import view.DiscDropView;

public class ConsoleDiscDropView implements DiscDropView {

	@Override
	public DiscDrop read(DiscColor color) {
		int column = Console.getInstance()
				.readInt("Insert column number to dropping disc of color " + color.toString());
		return new DiscDrop(color, column);
	}

	@Override
	public void showInvaidDropping() {
		Console.getInstance().printError("invalid Dropping");
	}

}