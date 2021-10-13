package utils;

public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate getDisplacedHorizontal() {
		return new Coordinate(this.x + 1, this.y);
	}

	public Coordinate getDisplacedVertical() {
		return new Coordinate(this.x, this.y + 1);
	}

	public Coordinate getDisplacedDiagonal() {
		return new Coordinate(this.x + 1, this.y + 1);
	}

	public Coordinate getDisplacedDiagonalInv() {
		return new Coordinate(this.x - 1, this.y + 1);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean inCuadrant(Coordinate coordinate) {
		return coordinate.getX() >= this.x && coordinate.y <= this.getY();
	}
}