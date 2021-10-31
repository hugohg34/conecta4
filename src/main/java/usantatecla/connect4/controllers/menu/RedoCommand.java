package usantatecla.connect4.controllers.menu;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

public class RedoCommand extends CommandController {

	public RedoCommand(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
		this.title = Message.REDO_COMMAND.toString();
	}

	@Override
	public void control() {
		this.session.redo();
	}

	@Override
	public boolean isActive() {
		return this.session.redoable();
	}

}
