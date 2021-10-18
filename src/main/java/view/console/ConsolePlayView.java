package view.console;

import controller.PlayController;
import model.DiscDrop;
import view.BoardView;

public class ConsolePlayView {
	
	public void interact(PlayController playController) {
		BoardView boardView = new ConsoleBoardView();
		boardView.setBoard(playController.getBoard());
			
		DiscDrop discDrop;
		boolean validDropping;
		do {
			ConsoleDiscDropView discDropView = new ConsoleDiscDropView();
			discDrop = discDropView.read(playController.getColor());
			validDropping = playController.isValidDropping(discDrop);
			if (!validDropping) {
				discDropView.showInvaidDropping();
			}
		} while (!validDropping);
		playController.dropping(discDrop);
	}

}
