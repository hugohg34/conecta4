package controller;

import model.Game;
import model.State;
import types.DiscColor;

public class ResumeController extends BaseController {

	public ResumeController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void accept(ControllersVisitor controllerVisitor) {
		controllerVisitor.visit(this);
		
	}

	public boolean isWinnerPlay() {
		return this.game.isFourInLine();
	}

	public DiscColor getWinnerPlayerColor() {
		return this.game.getCurrentDiscColor();
	}

}
