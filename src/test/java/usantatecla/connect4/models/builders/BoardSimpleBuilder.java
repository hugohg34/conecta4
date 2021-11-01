package usantatecla.connect4.models.builders;

import usantatecla.connect4.models.Board;

public class BoardSimpleBuilder extends BoardBuilder {

	public BoardSimpleBuilder() {
		super();
		this.boardStringMap.put("FULL",
				"RYRYRYR" +
				"RYRYRYR" +
				"YRYRYRY" +
				"YRYRYRY" +
				"RYRYRYR" +
				"RYRYRYR");
	}
	
	public BoardSimpleBuilder fullBoard() {
		this.board = boardFromString(this.boardStringMap.get("FULL"));
		return this;
	}
	
	public BoardSimpleBuilder enpty() {
		this.board.reset();
		return this;
	}
	@Override
	public Board buid() {
		return this.board;
	}

}
