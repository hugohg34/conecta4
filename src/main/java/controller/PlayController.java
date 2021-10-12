package controller;

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

	public PlayController(ViewFactory viewFactory) {
		this.boardView = viewFactory.getBoardView();
		this.discDropView = new DiscDropView();
		this.board = new Board();
		boardView.setBoard(board);
	}

	public void play(DiscColor color) {
		boardView.show();
		DiscDrop discDrop;
		boolean validDropping;
		do {
			discDrop = discDropView.dropping(color);
			validDropping = board.isValidDropping(discDrop);
			if (!validDropping) {
				discDropView.showInvaidDropping();
			}
		} while (!validDropping);
		board.dropping(discDrop);
	}

	public boolean isEndGame() {
		return board.isFull() || isSolvedGame();
	}

	public boolean isSolvedGame() {
		// TODO Auto-generated method stub
		return false;
	}

}
