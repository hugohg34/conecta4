package view;

import model.DiscDrop;
import types.DiscColor;
import utils.Console;

public class DiscDropView {

	public DiscDrop dropping(DiscColor color) {
		int column = Console.getInstance().readInt("Please insert column to dropping disc of color " + color.toString());
		return new DiscDrop(color, column);
		
	}

	public void showInvaidDropping() {
		Console.getInstance().printError("invalid Dropping");
		
	}

}
