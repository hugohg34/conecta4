package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Board;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.BoardView;
import usantatecla.connect4.views.ViewFactory;
import usantatecla.utils.models.ConcreteCoordinate;

public abstract class Controller {

	protected Session session;
	protected ViewFactory viewFactory;

	protected Controller(Session session, ViewFactory viewFactory) {
		this.session = session;
		this.viewFactory = viewFactory;
	}

	public void writeBoard() {
		BoardView boardView = this.viewFactory.createBoardView();
		for (int i = 0; i < Board.ROWS; i++) {
			for (int j = 0; j < Board.COLUMNS; j++) {
				boardView.set(session.getColor(new ConcreteCoordinate(i, j)));
			}
		}
		boardView.write();
	}

}
