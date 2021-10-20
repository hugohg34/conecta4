package view.console;

import controller.PlayController;
import model.DiscDrop;
import view.PlayView;

public class ConsolePlayView implements PlayView {
	
	@Override
	public void interact(PlayController playController) {
		DiscDrop discDrop;
		do {
			discDrop = new ConsolePlayerDiscDropView().read(playController);
			playController.dropping(discDrop);
			playController.nextTurn();
		} while (playController.isEndGame());
		playController.nextState();
	}

}
