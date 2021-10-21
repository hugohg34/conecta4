package controller;

import model.DiscDrop;
import model.Game;
import model.State;
import types.DiscColor;

public class PlayController extends BaseController {

	public PlayController(Game game, State state) {
		super(game, state);
	}
	
	public void nextTurn() {
		game.nextTurn();
	}

	public boolean isEndGame() {
		return this.game.isFull() || isWinnerPlay();
	}

	public boolean isWinnerPlay() {
		return this.game.isFourInLine();
	}

	public DiscColor currentDiscColor() {
		return this.game.getCurrentDiscColor();
	}

	public boolean isValidDropping(DiscDrop discDrop) {
		return this.game.isValidDropping(discDrop);
	}

	public void dropping(DiscDrop discDrop) {
		this.game.dropping(discDrop);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
