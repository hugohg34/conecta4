package utils;

public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate getDisplacedHorizontal(int displacement) {
		return new Coordinate(this.x + displacement, this.y);
	}

	public Coordinate getDisplacedHorizontal() {
		return getDisplacedHorizontal(1);
	}

	public Coordinate getDisplacedVertical(int displacement) {
		return new Coordinate(this.x, this.y + displacement);
	}

	public Coordinate getDisplacedVertical() {
		return getDisplacedVertical(1);
	}
	//

	public Coordinate getDisplacedDiagonalSecondX(int displacement) {
		return new Coordinate(this.x + displacement, this.y + displacement);
	}
	
	public Coordinate getDisplacedDiagonalSecondY(int displacement) {
		return new Coordinate(this.x - displacement, this.y - displacement);
	}
	
	public Coordinate getDisplacedDiagonalX(int displacement) {
		return new Coordinate(this.x + displacement, this.y - displacement);
	}
	
	public Coordinate getDisplacedDiagonalY(int displacement) {
		return new Coordinate(this.x - displacement, this.y + displacement);
	}
	
	//
	
	public Coordinate getDisplacedHorizontal(int displacement) {
		return new Coordinate(this.x + displacement, this.y);
	}

	public Coordinate getDisplacedHorizontal() {
		return getDisplacedHorizontal(1);
	}

	public Coordinate getDisplacedVertical(int displacement) {
		return new Coordinate(this.x, this.y + displacement);
	}

	public Coordinate getDisplacedVertical() {
		return getDisplacedVertical(1);
	}
	
	public Coordinate getDisplacedDiagonal(int displacement) {
		return new Coordinate(this.x + displacement, this.y + displacement);
	}
	
	public Coordinate getDisplacedDiagonalSup(int displacement) {
		return new Coordinate(this.x + displacement, this.y + displacement);
	}

	public Coordinate getDisplacedDiagonal() {
		return getDisplacedDiagonal(1);
	}

	public Coordinate getDisplacedDiagonalInv(int displacement) {
		return new Coordinate(this.x - displacement, this.y + displacement);
	}

	public Coordinate getDisplacedDiagonalInv() {
		return getDisplacedDiagonalInv(1);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean inCuadrant(Coordinate coordinate) {
		return coordinate.getX() >= this.x && coordinate.getX() <= this.y;
	}
}