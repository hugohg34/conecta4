package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

public class StartController extends Controller {

	public StartController(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
	}

	public void control() {
		this.viewFactory.createStartView().show();
		this.writeBoard();
	}

}
