package usantatecla.connect4.controllers.menu;

import usantatecla.connect4.models.Error;
import usantatecla.connect4.models.Message;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.PlayerView;
import usantatecla.connect4.views.ViewFactory;

public class ActionCommand extends CommandController {

	public ActionCommand(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
		this.title = Message.ACTION_COMMAND.toString();
	}

	@Override
	public void control() {
		int column;
		Error error;
		PlayerView view = viewFactory.createPlayerView();
		do {
			column = view.readColum() - 1;
			error = this.session.getPutTokenError(column);
		} while (!error.isNull());
		this.session.putToken(column);
		this.session.next();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
