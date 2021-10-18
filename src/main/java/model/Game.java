package model;

import types.DiscColor;

public class Game {
	private Board board;
	private Turn turn;
	
	public Game() {
		this.board = new Board();	
	}

	public boolean isFull() {
		return this.board.isFull();
	}

	public boolean isFourInLine() {
		return this.board.isFourInLine();
	}

	public Board getBoard() {
		return this.board;
	}

	public DiscColor getColor() {
		return this.turn.getColor();
	}

	public boolean isValidDropping(DiscDrop discDrop) {
		return this.board.isValidDropping(discDrop);
	}

	public void dropping(DiscDrop discDrop) {
		this.board.dropping(discDrop);
	}

	public void reset() {
		this.board.reset();		
	}

	public void next() {
		this.turn.change();
	}

}
