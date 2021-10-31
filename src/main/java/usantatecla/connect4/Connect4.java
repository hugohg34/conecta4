package usantatecla.connect4;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.controllers.StartController;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

abstract class Connect4 {

	private StartController startController;
	private PlayController playController;
	private ResumeController resumeController;

	protected Connect4() {
		ViewFactory viewFactory = this.createViewFactory();
		Session session = new Session();
		this.startController = new StartController(session, viewFactory);
		this.playController = new PlayController(session, viewFactory);
		this.resumeController = new ResumeController(session, viewFactory);
	}

	protected abstract ViewFactory createViewFactory();

	protected void play() {
		do {
			this.startController.control();
			this.playController.control();
		} while (this.resumeController.isResume());
	}

}
