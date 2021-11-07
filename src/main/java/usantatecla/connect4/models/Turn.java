package usantatecla.connect4.models;

import usantatecla.utils.models.Color;

public class Turn {

	private Board board;
	public static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int activePlayer;

	Turn(Board board) {
		assert board != null;
		this.board = board;
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.reset();
	}

	void reset() {
		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(Color.get(i), this.board);
		}
		this.activePlayer = 0;
	}

	void next() {
		if (!this.board.isConnect4()) {
			this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
		}
	}

	Player getActivePlayer() {
		return this.players[this.activePlayer];
	}

	public void setActivePlayer(int activePlayer) {
		this.activePlayer = activePlayer;
	}

	Color getActiveColor() {
		return this.getActivePlayer().getColor();
	}

	void putToken(int column) {
		this.getActivePlayer().putToken(column);
	}

	Error getPutTokenError(int column) {
		return this.getActivePlayer().getPutTokenError(column);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Turn other = (Turn) obj;
		return this.activePlayer == other.activePlayer && this.board.equals(other.board);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1 + activePlayer;
		result = prime * result + board.hashCode();
		return result;
	}

}
