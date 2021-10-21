package view.console;

import controller.ResumeController;
import utils.Console;
import view.ResumeView;

public class ConsoleResumeView implements ResumeView {

	private static final String END_GAME = "END OF GAME, BYE!";

	@Override
	public void interact(ResumeController resumeController) {
		if (resumeController.isWinnerPlay()) {
			new ConsoleWinnerView().show(resumeController.getWinnerPlayerColor());
		}
		Console.getInstance().println(END_GAME);
		resumeController.nextState();
	}

}
