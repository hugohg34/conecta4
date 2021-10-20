package controller;

import model.Game;
import model.State;

public class StartController extends BaseController {

	public StartController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
