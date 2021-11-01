package usantatecla.connect4.models;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.connect4.models.builders.BoardSimpleBuilder;
import usantatecla.utils.models.Color;
import usantatecla.utils.models.ConcreteCoordinate;

class BoardTest {

	private Board board;

	@BeforeEach
	void beforeAll() {
		this.board = new BoardSimpleBuilder().enpty().buid();
	}

	@Test
	void givenNullColor_whenPutToken_thenAssertionError() {
		assertThrows(NullPointerException.class, () -> {
			this.board.putToken(1, null);
		});
	}

	@Test
	void givenColumnOutOfBoard_whenPutToken_thenArrayIndexOutOfBoundsException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.putToken(Board.COLUMNS + 1, Color.RED);
		});
	}

	@Test
	void givenColumnNegativeValue_whenPutToken_thenArrayIndexOutOfBoundsException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.putToken(-1, Color.RED);
		});
	}

	@Test
	void givenColumnIsFull_whenPutToken_thenNullPointerException() {
		this.board = new BoardSimpleBuilder().fullBoard().buid();
		assertThrows(NullPointerException.class, () -> {
			this.board.putToken(0, Color.RED);
		});
	}

	@Test
	void givenPutTokenRed_whenGetColorInCordinate_thenIsEqualColor() {
		this.board.putToken(0, Color.RED);
		ConcreteCoordinate cordinate = new ConcreteCoordinate(0, 0);
		assertEquals(Color.RED, this.board.getColor(cordinate));
	}
	
	@Test
	void giveBoardFromCharArray_whenToCharArray_thenIsEqualCharArray() {
		String boardString = "RRRRRRRYYYYYYYRRRRRRRYYYYYYYRRRRRRRYYYYYYY";
		char[] boardToChar = new BoardSimpleBuilder().formString(boardString).buid().toCharacterArray();
		assertEquals(boardString, new String(boardToChar));
	}

	@Test
	void givenPutTokenInEmptyColumn_whenColumIsOccupiedEqualCOlor_thenTrue() {
		ConcreteCoordinate coordinatePut = new ConcreteCoordinate(row(0), col(0));
		this.board.putToken(coordinatePut.getColumn(), Color.RED);
		assertTrue(this.board.isOccupied(coordinatePut, Color.RED));
	}

	private int row(int row) {
		return row;
	}

	private int col(int col) {
		return col;
	}

}
