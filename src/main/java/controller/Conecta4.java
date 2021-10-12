package controller;

import view.ConsoleViewFactory;
import view.ViewFactory;

public class Conecta4 {

	ViewFactory viewFactory;
	PlayController playController;

	Conecta4() {
		viewFactory = new ConsoleViewFactory();
		playController = new PlayController(viewFactory);
	}

	public void play() {
		do {
			playController.play();
		} while (!playController.isEndGame());
	}

	public static void main(String[] args) {
		new Conecta4().play();
	}

}
