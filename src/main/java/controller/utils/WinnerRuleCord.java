package controller.utils;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.DiscDrop;
import types.DiscColor;
import utils.CardinalDirection;
import utils.Coordinate;

public class WinnerRuleCord {

	protected Board board;
	protected int goal = 4;

	public WinnerRuleCord(Board board) {
		this.board = board;
	}

	public boolean isFourInLine(DiscDrop discDrop) {
		for (CardinalDirection direction : CardinalDirection.values()) {
			List<DiscColor> neighbordDiscDrop = getNeighbordDiscDrop(discDrop, direction);
			if (neighbordDiscDrop.size() == this.goal && isEqualColor(discDrop, neighbordDiscDrop)) {
				return true;
			}
		}
		return false;
	}

	public List<DiscColor> getNeighbordDiscDrop(DiscDrop discDrop, CardinalDirection direction) {
		Coordinate discCoordinate = new Coordinate(discDrop.getColumn(), discDrop.getRow());
		Coordinate[] coordinateList = discCoordinate.getNeighbords(direction, goal - 1);
		List<DiscColor> neighbordList = new ArrayList<>();
		for (Coordinate coord : coordinateList) {
			if (inBoardCuadrant(coord)) {
				neighbordList.add(board.getDisc(coord.getX(), coord.getY()));
			}
		}
		return neighbordList;
	}

	private boolean isEqualColor(DiscDrop discDrop, List<DiscColor> neighbordDiscDrop) {
		for (DiscColor currentDisc : neighbordDiscDrop) {
			if (currentDisc != discDrop.getColor()) {
				return false;
			}
		}
		return true;
	}

	private boolean inBoardCuadrant(Coordinate coordinate) {
		Coordinate columBoardCord = new Coordinate(1, Board.COLUMNS);
		Coordinate rowBoardCord = new Coordinate(1, Board.ROWS);
		return columBoardCord.inCuadrant(coordinate) && rowBoardCord.inCuadrant(coordinate);
	}

}