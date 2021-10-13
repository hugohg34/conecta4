package controller.utils;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.DiscDrop;
import types.DiscColor;
import utils.Coordinate;

public abstract class WinnerRuleCord {

	protected Board board;
	protected int goal = 4;

	protected WinnerRuleCord(Board board) {
		this.board = board;
	}

	public boolean check(DiscDrop discDrop) {
		Coordinate discCoordinate = new Coordinate(discDrop.getColumn(), discDrop.getRow());
		List<Coordinate> neighbordCoords = getDisplacedList(discCoordinate, goal);
		List<DiscColor> neighbordDiscDrop = getNeighbordDiscDrop(neighbordCoords);

	}

	public List<Coordinate> getDisplacedList(Coordinate coordinate, int numDisplaced) {
		List<Coordinate> neighbordList = new ArrayList<>();
		for (int i = 1; i < numDisplaced; i++) {
			neighbordList.add(getDisplaced(coordinate, i));
		}
		return neighbordList;
	}

	public List<DiscColor> getNeighbordDiscDrop(List<Coordinate> coordinateList) {
		List<DiscColor> neighbordList = new ArrayList<>();
		for (Coordinate coord : coordinateList) {
			if (inBoardCuadrant(coord)) {
				neighbordList.add(board.getDisc(coord.getX(), coord.getY()));
			}
		}
		return neighbordList;
	}

	protected abstract Coordinate getDisplaced(Coordinate coortinate, int displacement);

	///////////////
	public boolean isFourInLine() {
		boolean isInline = false;
		for (int column = 1; column < Board.COLUMNS && !isInline; column++) {
			for (int row = 1; row < Board.ROWS && !isInline; row++) {
				isInline = check(column, row);
			}
		}
		return isInline;
	}

	protected abstract Coordinate getDisplaced(Coordinate coortinate);

	private boolean check(int column, int row) {
		List<DiscColor> neighborsList = neighborsList(column, row);
		int inLine = 1;
		DiscColor currentDisc = neighborsList.get(0);
		for (int i = 1; i < neighborsList.size(); i++) {
			if (currentDisc != DiscColor.NULL && currentDisc == neighborsList.get(i)) {
				inLine++;
			} else {
				inLine = 1;
			}
			currentDisc = neighborsList.get(i);
		}
		return inLine == this.goal;
	}

	private List<DiscColor> neighborsList(int column, int row) {
		List<DiscColor> discList = new ArrayList<>();
		discList.add(this.board.getDisc(column, row));
		Coordinate displacedCoord = new Coordinate(column, row);
		for (int i = 1; i < this.goal; i++) {
			displacedCoord = getDisplaced(displacedCoord);
			if (inBoardCuadrant(displacedCoord)) {
				discList.add(this.board.getDisc(displacedCoord.getX(), displacedCoord.getY()));
			}
		}
		return discList;
	}

	private boolean inBoardCuadrant(Coordinate coordinate) {
		Coordinate columBoardCord = new Coordinate(1, Board.COLUMNS);
		Coordinate rowBoardCord = new Coordinate(1, Board.ROWS);
		return columBoardCord.inCuadrant(coordinate) && rowBoardCord.inCuadrant(coordinate);
	}
}