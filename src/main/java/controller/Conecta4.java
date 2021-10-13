package controller;

import model.Turn;
import view.ConsoleViewFactory;
import view.console.ViewFactory;

public class Conecta4 {

	private ViewFactory viewFactory;
	private PlayController playController;
	private Turn turn;

	Conecta4() {
		this.viewFactory = new ConsoleViewFactory();
		this.playController = new PlayController(viewFactory);
		this.turn = new Turn();
	}

	public void play() {
		do {
			this.playController.play(turn.getColor());
			if (playController.isWinnerPlay()) {
				viewFactory.getWinnerView().show(turn.getColor());
			}
			this.turn.change();
		} while (!playController.isEndGame());
		this.viewFactory.getEndGameView().show();
	}

	public static void main(String[] args) {
		new Conecta4().play();
	}

}