package controller;

import model.Board;
import model.DiscDrop;
import types.DiscColor;
import view.BoardView;
import view.DiscDropView;
import view.ViewFactory;
import view.console.ConsoleDiscDropView;

public class PlayController {

	private BoardView boardView;
	private Board board;
	private DiscDropView discDropView;

	public PlayController(ViewFactory viewFactory) {
		this.boardView = viewFactory.getBoardView();
		this.discDropView = new ConsoleDiscDropView();
		this.board = new Board();
		this.boardView.setBoard(this.board);
	}

	public void play(DiscColor color) {
		this.boardView.show();
		DiscDrop discDrop;
		boolean validDropping;
		do {
			discDrop = this.discDropView.read(color);
			validDropping = this.board.isValidDropping(discDrop);
			if (!validDropping) {
				this.discDropView.showInvaidDropping();
			}
		} while (!validDropping);
		this.board.dropping(discDrop);
	}

	public boolean isEndGame() {
		return this.board.isFull() || isWinnerPlay();
	}

	public boolean isWinnerPlay() {
		return this.board.isFourInLine();
	}

}