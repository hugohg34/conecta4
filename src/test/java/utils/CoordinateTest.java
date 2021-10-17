package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordinateTest {

	Coordinate origin;
	int displacement;

	@BeforeEach
	protected void before() {
		this.origin = new Coordinate(0, 0);
		this.displacement = 2;
	}

	@Test
	void eastDisplacementTest() {
		Coordinate expected = new Coordinate(this.origin.getX() + this.displacement, 0);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.EAST, this.displacement);
		assertEquals(expected, calculated);
	}

	@Test
	void westDisplacementTest() {
		Coordinate expected = new Coordinate(this.origin.getX() - this.displacement, 0);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.WEST, this.displacement);
		assertEquals(expected, calculated);
	}

	@Test
	void northDisplacementTest() {
		Coordinate expected = new Coordinate(0, this.origin.getY() + this.displacement);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.NORTH, this.displacement);
		assertEquals(expected, calculated);
	}
	
	@Test
	void southDisplacementTest() {
		Coordinate expected = new Coordinate(0, this.origin.getY() - this.displacement);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.SOUTH, this.displacement);
		assertEquals(expected, calculated);
	}
	
	@Test
	void northEastDisplacementTest() {
		Coordinate expected = new Coordinate(this.origin.getX() + this.displacement, this.origin.getY() + this.displacement);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.NORTH_EAST, this.displacement);
		assertEquals(expected, calculated);
	}
	
	@Test
	void northWestDisplacementTest() {
		Coordinate expected = new Coordinate(this.origin.getX() - this.displacement, this.origin.getY() + this.displacement);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.NORTH_WEST, this.displacement);
		assertEquals(expected, calculated);
	}
	
	@Test
	void sothEastDisplacementTest() {
		Coordinate expected = new Coordinate(this.origin.getX() + this.displacement, this.origin.getY() - this.displacement);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.SOUTH_EAST, this.displacement);
		assertEquals(expected, calculated);
	}

	@Test
	void sothWestDisplacementTest() {
		Coordinate expected = new Coordinate(this.origin.getX() - this.displacement, this.origin.getY() - this.displacement);
		Coordinate calculated = this.origin.getDisplaced(CardinalDirection.SOUTH_WEST, this.displacement);
		assertEquals(expected, calculated);
	}

}
