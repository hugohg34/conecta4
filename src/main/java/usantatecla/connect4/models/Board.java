package usantatecla.connect4.models;

import java.util.Arrays;

import usantatecla.utils.models.Color;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.Direction;

public class Board {

	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	public static final int GOALS_IN_DIRECTION = 4;

	private Color[][] colors;

	public Board() {
		this.colors = new Color[Board.ROWS][Board.COLUMNS];
		this.reset();
	}

	public void reset() {
		for (int i = 0; i < Board.ROWS; i++) {
			for (int j = 0; j < Board.COLUMNS; j++) {
				this.colors[i][j] = Color.NULL;
			}
		}
	}

	public void putToken(int column, Color color) {
		assert color != null;
		ConcreteCoordinate coordinate = this.getEmptyCoordinate(column);
		this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
	}

	ConcreteCoordinate getEmptyCoordinate(int column) {
		ConcreteCoordinate current = new ConcreteCoordinate(Board.ROWS - 1, column);
		if (!this.isEmpty(current)) {
			return null;
		}
		ConcreteCoordinate previous;
		do {
			previous = current;
			current = current.getInDirectionCoordinate(Direction.SOUTH);
		} while (isValid(current) && this.isEmpty(current));
		return previous;
	}

	private boolean isValid(ConcreteCoordinate coordinate) {
		return 0 <= coordinate.getRow() && coordinate.getRow() < Board.ROWS && 0 <= coordinate.getColumn()
				&& coordinate.getColumn() < Board.COLUMNS;
	}

	boolean thereIsEmpty(int column) {
		return this.getEmptyCoordinate(column) != null;
	}

	private boolean isEmpty(ConcreteCoordinate coordinate) {
		return this.getColor(coordinate) == Color.NULL;
	}

	Color getColor(ConcreteCoordinate coordinate) {
		return this.colors[coordinate.getRow()][coordinate.getColumn()];
	}

	boolean isOccupied(ConcreteCoordinate coordinate, Color color) {
		return this.getColor(coordinate) == color;
	}

	boolean isConnect4() {
		for (int i = 0; i < Board.ROWS; i++) {
			for (int j = 0; j < Board.COLUMNS; j++) {
				if (this.isConnect4(new ConcreteCoordinate(i, j))) {
					return true;
				}
			}
		}
		return false;
	}

	boolean isConnect4(ConcreteCoordinate coordinate) {	
		for (Direction direction : Direction.values()) {
			if (direction != Direction.NULL && isConnect4(coordinate, direction)) {
				return true;
			}
		}
		return false;
	}

	boolean isConnect4(ConcreteCoordinate coordinate, Direction direction) {
		assert !direction.isNull();
		assert this.isValid(coordinate);

		ConcreteCoordinate[] coordinates = coordinate.getInDirectionCoordinates(direction, GOALS_IN_DIRECTION);
		for (int i = 0; i < coordinates.length - 1; i++) {
			if (!this.isValid(coordinates[i]) || !this.isValid(coordinates[i + 1])
					|| this.getColor(coordinates[i]) != this.getColor(coordinates[i + 1])) {
				return false;
			}
		}
		return this.getColor(coordinates[0]) != Color.NULL;
	}

	public char[] toCharacterArray() {
		char[] characters = new char[Board.ROWS * Board.COLUMNS];
		int charactersCount = 0;
		for (int i = 0; i < Board.ROWS; i++) {
			for (int j = 0; j < Board.COLUMNS; j++) {
				characters[charactersCount++] = this.colors[i][j].toString().charAt(0);
			}
		}
		return characters;
	}

	public Color[][] getColors() {
		return colors;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Board other = (Board) obj;
		for (int i = 0; i < Board.ROWS; i++) {
			for (int j = 0; j < Board.COLUMNS; j++) {
				if (this.colors[i][j] != other.colors[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(this.colors);
		return result;
	}

}
