package usantatecla.connect4.controllers.menu;

import usantatecla.connect4.controllers.Controller;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

public abstract class CommandController extends Controller {

	protected CommandController(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
	}

	protected String title;

	public abstract void control();

	public abstract boolean isActive();

	public String getTitle() {
		return this.title;
	}

}
