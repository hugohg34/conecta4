package view.console;

import utils.Console;
import view.EndGameView;

public class ConsoleEndGameView implements EndGameView {

	@Override
	public void show() {
		Console.getInstance().println("END OF GAME, BYE!");
	}

}