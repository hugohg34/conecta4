package controller.utils;

import model.Board;
import utils.Coordinate;

public class HorizontalWinnerRule extends WinnerRule{

	public HorizontalWinnerRule(Board board) {
		super(board);
	}

	@Override
	protected Coordinate getDisplaced(Coordinate coortinate, int displacement) {
		return coortinate.getDisplacedHorizontal(displacement);
	}

}
