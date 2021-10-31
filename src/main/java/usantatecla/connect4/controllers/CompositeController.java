package usantatecla.connect4.controllers;

import java.util.List;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.ViewFactory;

public abstract class CompositeController extends Controller {
	
	protected List<Controller> componentControllers;
	
	protected CompositeController(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
	}
	
	abstract void createComponentControllers();
	
}
