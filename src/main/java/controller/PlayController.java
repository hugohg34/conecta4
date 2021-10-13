package controller;

import controller.utils.WinnerChecker;
import model.Board;
import model.DiscDrop;
import types.DiscColor;
import view.console.BoardView;
import view.console.DiscDropView;
import view.console.ViewFactory;

public class PlayController {

	private BoardView boardView;
	private Board board;
	private DiscDropView discDropView;
	private WinnerChecker winnerChecker;

	public PlayController(ViewFactory viewFactory) {
		this.boardView = viewFactory.getBoardView();
		this.discDropView = new DiscDropView();
		this.board = new Board();
		this.winnerChecker = new WinnerChecker(board);
		this.boardView.setBoard(board);
	}

	public void play(DiscColor color) {
		this.boardView.show();
		DiscDrop discDrop;
		boolean validDropping;
		do {
			discDrop = this.discDropView.dropping(color);
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
		return this.winnerChecker.check();
	}

}