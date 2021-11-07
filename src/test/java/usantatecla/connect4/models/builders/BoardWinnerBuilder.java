package usantatecla.connect4.models.builders;

import usantatecla.connect4.models.Board;
import usantatecla.utils.models.Color;
import usantatecla.utils.models.Direction;

public class BoardWinnerBuilder extends BoardBuilder {
	
	private char winnerChar;
	private char replaceChar = ' ';
	private Direction direction;
	
	public BoardWinnerBuilder() {
		super();
		this.boardStringMap.put(Direction.EAST.toString(),
				"NNNNNNN" +
				"NNNNNNN" +
				"NNNNNNN" +
				"NNNNNNN" +
				"    NNN" +
				"RYRYRNN");
		
		this.boardStringMap.put(Direction.NORTH.toString(),
				"NNNNNNN" +
				"NNNNNNN" +
				"NNN NNN" +
				"NNN NNN" +
				"NNN NNN" +
				"RYN RNN");	
		
		this.boardStringMap.put(Direction.NORTH_EAST.toString(),
				"NNNNNNN" +
				"NNNNNNN" +
				"NNN NNN" +
				"NN RNNN" +
				"R RYNNN" +
				" YRYNNN");
		
		this.boardStringMap.put(Direction.SOUTH_EAST.toString(),
				"NNNNNNN" +
				"NNNNNNN" +
				" NNXNNN" +
				"Y NXNNN" +
				"RY NNNN" +
				"RYR NNN");
	}

	public BoardWinnerBuilder winnerColor(Color color) {
		this.winnerChar = color.toString().charAt(0);
		return this;
	}

	public BoardWinnerBuilder direction(Direction direction) {
		this.direction = direction;
		return this;
	}

	@Override
	public Board buid() {
		String replacedWinnerBoard = this.boardStringMap.get(this.direction.toString()).replace(replaceChar,
				winnerChar);
		boardFromString(replacedWinnerBoard);

		return this.board;
	}

}
