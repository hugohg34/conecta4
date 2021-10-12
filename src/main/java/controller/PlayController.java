package controller;

import model.Board;
import model.DiscDrop;
import types.Color;
import view.BoardView;
import view.DiscDropView;
import view.ErrorView;
import view.ViewFactory;

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

	public void play(Color color) {
		boardView.show();
		DiscDrop discDrop;
		boolean validDropping;
		do {
			discDrop = discDropView.dropping(color);
			validDropping = board.isValidDropping();
			if (!validDropping) {
				ErrorView.getInstanse().show("invalid Dropping");
			}
		} while (!validDropping);
		board.dropping(discDrop);
	}

	public boolean isEndGame() {
		return board.isFull() || isSolvedGame();
	}

	public boolean isSolvedGame() {
		// TODO Auto-generated method stub
		return true;
	}

}
