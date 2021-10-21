package controller;

import java.util.EnumMap;
import java.util.Map;

import model.Game;
import model.State;
import model.StateValue;

public class Logic {

	private Game game;
	private State state;
	private Map<StateValue, BaseController> controllers;

	public Logic() {
		this.game = new Game();
		this.state = new State();
		this.controllers = new EnumMap<> (StateValue.class);
		this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
		this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
		this.controllers.put(StateValue.EXIT, null);
	}

	public BaseController getController() {
		return this.controllers.get(this.state.getValueState());
	}
}
