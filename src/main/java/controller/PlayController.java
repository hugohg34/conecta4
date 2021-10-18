package controller;

import model.DiscDrop;
import model.Game;
import model.State;
import types.DiscColor;

public class PlayController extends BaseController {

	public PlayController(Game game, State state) {
		super(game, state);
	}

	public boolean isEndGame() {
		return this.game.isFull() || isWinnerPlay();
	}

	public boolean isWinnerPlay() {
		return this.game.isFourInLine();
	}

	public DiscColor currentDiscColor(int col, int row) {
		return this.game.getDiscColor(col, row);
	}

	public DiscColor getDiscColor(int col, int row) {
		return this.game.getDiscColor(col, row);
	}

	public boolean isValidDropping(int col) {
		DiscDrop discDrop = new DiscDrop(this.game.getCurrentDiscColor(), col);
		return this.game.isValidDropping(discDrop);
	}

	public void dropping(int col) {
		DiscDrop discDrop = new DiscDrop(this.game.getCurrentDiscColor(), col);
		this.game.dropping(discDrop);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
