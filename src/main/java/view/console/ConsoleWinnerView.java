package view.console;

import types.DiscColor;
import utils.Console;
import view.WinnerView;

public class ConsoleWinnerView implements WinnerView {

	@Override
	public void show(DiscColor color) {
		String separator = String.format("%35s", "").replace(" ", "#");
		Console.getInstance().println(separator);
		Console.getInstance().println(String.format("#%33s#", ""));
		Console.getInstance().println(String.format("#%-33s#", " !PLAYER COLOR " + color.toString() + " IS WINNER!"));
		Console.getInstance().println(String.format("#%33s#", ""));
		Console.getInstance().println(separator);
	}

}