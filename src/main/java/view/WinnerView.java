package view;

import types.Color;
import utils.Console;

public class WinnerView {
	
	public void show(Color color) {
		Console.getInstance().println(String.format("%35s", "").replace(" ", "#"));
		Console.getInstance().println(String.format("#%33s#", ""));
		Console.getInstance().println(String.format("#%-33s#", " !PLAYER COLOR " + color.toString() + " IS WINNER!"));
		Console.getInstance().println(String.format("#%33s#", ""));
		Console.getInstance().println(String.format("%35s", "#").replace(" ", "#"));
	}

}
