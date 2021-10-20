package view.console;

import controller.PlayController;
import controller.ResumeController;
import controller.StartController;
import view.PlayView;
import view.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

	public ConsoleViewFactory() {
		this.startView = new ConsoleStartView();
		this.playView = new ConsolePlayView();
		this.resumeView = new ConsoleResumeView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);	
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
		
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);		
	}

}