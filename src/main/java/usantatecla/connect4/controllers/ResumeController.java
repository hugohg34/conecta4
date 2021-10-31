package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

public class ResumeController extends Controller {

	public ResumeController(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
	}

	public boolean isResume() {
		boolean isResumed = this.viewFactory.createResumeView().read();
		if (isResumed) {
			this.session.reset();
		}
		return isResumed;
	}

}
