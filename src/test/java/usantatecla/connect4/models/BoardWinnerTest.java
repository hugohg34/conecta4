package usantatecla.connect4.models;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import usantatecla.connect4.models.builders.BoardWinnerBuilder;
import usantatecla.utils.models.Color;
import usantatecla.utils.models.Direction;

class BoardWinnerTest {

	@Test
	void givenFourRedColorInEast_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.RED).direction(Direction.EAST).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourYellowColorInEast_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.YELLOW).direction(Direction.EAST).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourYellowColorInNorth_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.YELLOW).direction(Direction.NORTH).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourRedColorInNorth_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.RED).direction(Direction.NORTH).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourYellowColorInNorthEast_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.YELLOW).direction(Direction.NORTH_EAST).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourRedColorInNorthEast_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.RED).direction(Direction.NORTH_EAST).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourYellowColorInSouthEast_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.YELLOW).direction(Direction.SOUTH_EAST).buid();
		assertTrue(board.isConnect4());
	}

	@Test
	void givenFourRedColorInSouthEast_whenIsConnect4_thenReturnTrue() {
		Board board = new BoardWinnerBuilder().winnerColor(Color.RED).direction(Direction.SOUTH_EAST).buid();
		assertTrue(board.isConnect4());
	}
}
