package view;

import model.DiscDrop;
import types.Color;
import utils.Console;

public class DiscDropView {

	public DiscDrop dropping(Color color) {
		int column = Console.getInstance().readInt("Please insert column to dropping disc of color " + color.toString());
		return new DiscDrop(color, column);
		
	}

	public void showInvaidDropping() {
		Console.getInstance().printError("invalid Dropping");
		
	}

}
