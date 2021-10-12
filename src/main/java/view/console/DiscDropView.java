package view.console;

import model.DiscDrop;
import types.DiscColor;
import utils.Console;

public class DiscDropView {

	public DiscDrop dropping(DiscColor color) {
		int column = Console.getInstance()
				.readInt("Insert column number to dropping disc of color " + color.toString());
		return new DiscDrop(color, column);
	}

	public void showInvaidDropping() {
		Console.getInstance().printError("invalid Dropping");
	}

}
