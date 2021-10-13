package view.console;

import view.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

	public ConsoleViewFactory() {
		this.boardView = new ConsoleBoardView();
		this.winnerView = new ConsoleWinnerView();
		this.endGameView = new ConsoleEndGameView();
	}

}