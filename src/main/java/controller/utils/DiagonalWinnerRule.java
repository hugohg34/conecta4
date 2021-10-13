package controller.utils;

import model.Board;
import utils.Coordinate;

public class DiagonalWinnerRule extends WinnerRule{

	public DiagonalWinnerRule(Board board) {
		super(board);
	}

	@Override
	protected Coordinate getDisplaced(Coordinate coortinate) {
		return coortinate.getDisplacedDiagonal();
	}

}
