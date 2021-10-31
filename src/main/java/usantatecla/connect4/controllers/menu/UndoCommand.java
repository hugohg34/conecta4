package usantatecla.connect4.controllers.menu;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

public class UndoCommand extends CommandController {

	public UndoCommand(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
		this.title = Message.UNDO_COMMAND.toString();
	}

	@Override
	public void control() {
		this.session.undo();
	}

	@Override
	public boolean isActive() {
		return this.session.undoable();
	}

}
