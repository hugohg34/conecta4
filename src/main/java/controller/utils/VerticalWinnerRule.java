package controller.utils;

import model.Board;
import utils.Coordinate;

public class VerticalWinnerRule extends WinnerRule{

	public VerticalWinnerRule(Board board) {
		super(board);
	}

	@Override
	protected Coordinate getDisplaced(Coordinate coortinate) {
		return coortinate.getDisplacedVertical();
	}

}
