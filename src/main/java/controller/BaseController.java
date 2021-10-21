package controller;

import model.Game;
import model.State;
import types.DiscColor;

public abstract class BaseController {
	
    protected Game game;
    protected State state;

    BaseController(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public abstract void accept(ControllersVisitor controllersVisitor);

	public DiscColor getDiscColor(int col, int row) {
		return this.game.getDiscColor(col, row);
	}
}
