package usantatecla.connect4.models;

import java.util.ArrayList;
import java.util.List;

class Registry {

	private List<GameMemento> mementos;
	private Game game;
	private int firstPrevious;

	Registry(Game game) {
		this.game = game;
		this.reset();
	}

	void reset() {
		this.firstPrevious = 0;
		this.mementos = new ArrayList<>();
		this.mementos.add(this.firstPrevious, this.game.createMemento());
	}

	void register() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementos.remove(0);
		}
		this.firstPrevious = 0;
		this.mementos.add(this.firstPrevious, this.game.createMemento());
	}

	void undo() {
		assert this.isUndoable();

		this.firstPrevious++;
		this.game.setMemento(this.mementos.get(this.firstPrevious));
	}

	void redo() {
		assert this.isRedoable();

		this.firstPrevious--;
		this.game.setMemento(this.mementos.get(this.firstPrevious));
	}

	boolean isUndoable() {
		return this.firstPrevious < this.mementos.size() - 1;
	}

	boolean isRedoable() {
		return this.firstPrevious >= 1;
	}

}
