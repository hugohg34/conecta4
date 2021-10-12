package view;

import types.Color;
import utils.Console;

public class WinnerView {
	
	public void show(Color color) {
		String separator = String.format("%35s", "").replace(" ", "#");
		Console.getInstance().println(separator);
		Console.getInstance().println(String.format("#%33s#", ""));
		Console.getInstance().println(String.format("#%-33s#", " !PLAYER COLOR " + color.toString() + " IS WINNER!"));
		Console.getInstance().println(String.format("#%33s#", ""));
		Console.getInstance().println(separator);
	}

}
