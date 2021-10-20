package view.console;

import controller.PlayController;
import model.DiscDrop;
import utils.Console;

public class ConsolePlayerDiscDropView {

	private static final String INSERT_COLUMN_NUMBER_TO_DROPPING_OF_COLOR = "Insert column number to dropping disc of color %s";
	private static final String INVALID_DROPPING = "Invalid Dropping";

	public DiscDrop read(PlayController playController) {
		DiscDrop discDrop;
		boolean validDropping;
		do {
			int column = Console.getInstance().readInt(String.format(INSERT_COLUMN_NUMBER_TO_DROPPING_OF_COLOR,
					playController.currentDiscColor().toString()));
			discDrop = new DiscDrop(playController.currentDiscColor(), column);
			validDropping = playController.isValidDropping(discDrop);
			if (!validDropping) {
				showInvaidDropping();
			}
		} while (!validDropping);
		return discDrop;
	}

	public void showInvaidDropping() {
		Console.getInstance().printError(INVALID_DROPPING);
	}

}
