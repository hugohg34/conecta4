package controller;

import model.Turn;
import view.ViewFactory;
import view.console.ConsoleViewFactory;

public class Conecta4 {

	private ViewFactory viewFactory;
	private PlayController playController;
	private Turn turn;

	Conecta4() {
		this.viewFactory = new ConsoleViewFactory();
		this.playController = new PlayController(this.viewFactory);
		this.turn = new Turn();
	}

	public void play() {
		do {
			this.playController.play(this.turn.getColor());
			if (this.playController.isWinnerPlay()) {
				this.viewFactory.getWinnerView().show(this.turn.getColor());
			}
			this.turn.change();
		} while (!this.playController.isEndGame());
		this.viewFactory.getBoardView().show();
		this.viewFactory.getEndGameView().show();
	}

	public static void main(String[] args) {
		new Conecta4().play();
	}

}