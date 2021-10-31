package usantatecla.connect4.models;

import usantatecla.utils.models.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class Session {

	private Game game;
	private Registry registry;

	public Session() {
		this.game = new Game();
		this.registry = new Registry(game);
	}

	public void reset() {
		this.game.reset();
		this.registry.reset();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo();
	}

	public void redo() {
		this.registry.redo();
	}

	public void next() {
		this.game.next();
		this.registry.register();
	}

	public Color getColor(ConcreteCoordinate coordinate) {
		return this.game.getColor(coordinate);
	}

	public boolean isConnect4() {
		return this.game.isConnect4();
	}

	public Color getActiveColor() {
		return this.game.getActiveColor();
	}

	public usantatecla.connect4.models.Error getPutTokenError(int column) {
		return this.game.getPutTokenError(column);
	}

	public void putToken(int column) {
		this.game.putToken(column);
	}

}
