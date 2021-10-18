package controller;

import model.Game;
import model.State;

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
}
