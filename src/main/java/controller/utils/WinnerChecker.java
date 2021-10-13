package controller.utils;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import types.DiscColor;
import utils.Coordinate;

public class WinnerChecker {

	private Board board;
	private int goal = 4;

	public WinnerChecker(Board board) {
		this.board = board;
	}

	public boolean isFourInLine() {
		boolean isInline = false;
		for (int column = 1; column < Board.COLUMNS && !isInline; column++) {
			for (int row = 1; row < Board.ROWS && !isInline; row++) {
				isInline = check(diagonalList(column, row));
			}
		}
		return isInline;
	}

	private List<DiscColor> diagonalList(int x, int y) {
		List<DiscColor> discList = new ArrayList<>();
		discList.add(this.board.getDisc(x, y));
		Coordinate displacedCoord = new Coordinate(x, y);
		for (int i = 1; i < this.goal; i++) {
			displacedCoord = displacedCoord.getDisplacedDiagonal();// TODO Usar template 
			if (displacedCoord.getX() < Board.COLUMNS && displacedCoord.getY() < Board.ROWS) {
				discList.add(this.board.getDisc(displacedCoord.getX(), displacedCoord.getY()));
			}
		}
		return discList;
	}

	private boolean check(List<DiscColor> discList) {
		int inLine = 1;
		DiscColor currentDisc = discList.get(0);
		for (int i = 1; i < discList.size(); i++) {
			if (currentDisc != DiscColor.NULL && currentDisc == discList.get(i)) {
				inLine++;
			} else {
				inLine = 1;
			}
			currentDisc = discList.get(i);
		}
		return inLine == this.goal;
	}

}
