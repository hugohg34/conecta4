package controller.utils;

import model.Board;
import utils.Coordinate;

public class DiagonalInvWinnerRule extends WinnerRule{

	public DiagonalInvWinnerRule(Board board) {
		super(board);
	}

	@Override
	protected Coordinate getDisplaced(Coordinate coortinate) {
		return coortinate.getDisplacedDiagonalInv();
	}

}
