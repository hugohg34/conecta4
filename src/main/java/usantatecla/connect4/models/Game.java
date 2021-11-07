package usantatecla.connect4.models;

import usantatecla.utils.models.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class Game {

	private Board board;
	private Turn turn;

	public Game() {
		this.board = new Board();
		this.turn = new Turn(this.board);
	}

	public void reset() {
		this.board.reset();
		this.turn.reset();
	}

	public void next() {
		this.turn.next();
	}

	public Color getActiveColor() {
		return this.turn.getActiveColor();
	}

	public boolean isConnect4() {
		return this.board.isConnect4();
	}

	public Color getColor(ConcreteCoordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	public void putToken(int column) {
		this.turn.putToken(column);
	}

	public Error getPutTokenError(int column) {
		return this.turn.getPutTokenError(column);
	}

	GameMemento createMemento() {
		return new GameMemento(this.board, this.turn);
	}

	void setMemento(GameMemento memento) {
		this.board = memento.getBoard();
		this.turn = new Turn(this.board);
		this.turn.setActivePlayer(memento.getActivePlayer());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return this.turn.equals(other.turn);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + turn.hashCode();
		return result;
	}

}
