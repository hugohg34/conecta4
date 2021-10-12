package view;

import model.DiscDrop;
import types.Color;
import utils.Console;

public class DiscDropView {

	public DiscDrop dropping(Color color) {
		Console.getInstance().readString("Please dropping disc of color ");
		return new DiscDrop();
		
	}

}
