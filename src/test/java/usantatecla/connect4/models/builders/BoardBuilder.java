package usantatecla.connect4.models.builders;

import java.util.HashMap;
import java.util.Map;

import usantatecla.connect4.models.Board;
import usantatecla.utils.models.Color;

public abstract class BoardBuilder {

	protected Map<String, String> boardStringMap;
	protected Board board;

	public BoardBuilder() {
		this.board = new Board();
		this.boardStringMap = new HashMap<>();
	}

	protected Board boardFromString(String boardColors) {
	    int colorsCount = 0;
	    for (int i = 0; i < Board.ROWS; i++) {
	        for (int j = 0; j < Board.COLUMNS; j++) {
	            this.board.putToken(j, Color.get(boardColors.charAt(colorsCount++)));
	        }
	    }
	    return this.board;
	}
	
	public abstract Board buid();

}