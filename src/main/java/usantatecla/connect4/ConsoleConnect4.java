package usantatecla.connect4;

import usantatecla.connect4.views.console.ConsoleViewFactory;

class ConsoleConnect4 extends Connect4 {

	@Override
	protected ConsoleViewFactory createViewFactory() {
		return new ConsoleViewFactory();
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}

}
