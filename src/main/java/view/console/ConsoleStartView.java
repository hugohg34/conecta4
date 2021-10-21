package view.console;

import controller.StartController;
import view.StartView;

public class ConsoleStartView implements StartView {

	@Override
	public void interact(StartController startController) {
		new ConsoleBoardView().show(startController);
		startController.nextState();
	}

}
