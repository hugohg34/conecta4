package utils;

public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate getDisplaced(CardinalDirection direction, int displacement) {
		return new Coordinate(this.x + (direction.getX() * displacement), this.y + (direction.getY() * displacement));
	}

	public Coordinate[] getNeighbords(CardinalDirection direcion, int neighbors) {
		Coordinate[] neighbordsArray = new Coordinate[neighbors];
		for (int indexArray = 0; indexArray < neighbors; indexArray++) {
			neighbordsArray[indexArray] = getDisplaced(direcion, indexArray + 1);
		}
		return neighbordsArray;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean between(Coordinate limitX, Coordinate limitY) {
		return this.x >= limitX.getX() && this.x <= limitX.getY() && this.y >= limitY.getX() && this.y <= limitY.getY();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Coordinate coordinate = (Coordinate) obj;
		return this.x == coordinate.getX() && this.y == coordinate.getY();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.y;
		return result;
	}

}