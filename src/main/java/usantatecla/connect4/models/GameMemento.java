package usantatecla.connect4.models;

import usantatecla.utils.models.Color;

class GameMemento {

	private int activePlayer;
	private char[] boardColors;

	GameMemento(Board board, Turn turn) {
		this.boardColors = board.toCharacterArray();
		this.activePlayer = turn.getActiveColor().ordinal();
	}

	Board getBoard() {
		Board board = new Board();
		int colorsCount = 0;
		for (int i = 0; i < Board.ROWS; i++) {
			for (int j = 0; j < Board.COLUMNS; j++) {
				board.putToken(j, Color.get(this.boardColors[colorsCount++]));
			}
		}
		return board;
	}

	int getActivePlayer() {
		return this.activePlayer;
	}

	int getPlayerPutTokens(Color color) {
		int playerPutTokens = 0;
		for (int i = 0; i < this.boardColors.length; i++) {
			if (Color.get(this.boardColors[i]) == color) {
				playerPutTokens++;
			}
		}
		return playerPutTokens;
	}

}
