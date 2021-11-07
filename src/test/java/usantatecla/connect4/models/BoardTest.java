package usantatecla.connect4.models;

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

	/*
	 * Equivalence Class
	 * For Column:
	 * null, ... -1 [0,...6] 7, ...
	 * 
	 */
	
	@Test
	void testGivenEmptyBoard_when_PutTokenNullColor_thenAssertionError() {
		assertThrows(AssertionError.class, () -> {
			this.board.putToken(1, null);
		});
	}
	
	@Test
	void testGivenEmptyBoard_whenPutTokenOutsideLeftColumn_thenArrayIndexOutOfBoundsException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.putToken(-1, Color.RED);
		});
	}
	
	@Test
	void testGivenEmptyBoard_whenPutTokenInsideLeftColumn_thenGetColorIsEqual() {
		Color color = Color.RED;
		int column = 0;
		this.board.putToken(column, color);
		ConcreteCoordinate coordinate = new ConcreteCoordinate(0, column);
		assertEquals(color, this.board.getColor(coordinate));
	}
	
	@Test
	void testGivenEmptyBoard_whenPutTokenInsideRightColumn_thenGetColorIsEqual() {
		Color color = Color.YELLOW;
		int column = Board.COLUMNS -1;
		this.board.putToken(column, color);
		ConcreteCoordinate coordinate = new ConcreteCoordinate(0, column);
		assertEquals(color, this.board.getColor(coordinate));
	}
	
	@Test
	void testGivenEmptyBoard_whenPutTokenOutsideRigtColumn_thenArrayIndexOutOfBoundsException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			this.board.putToken(Board.COLUMNS, Color.RED);
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
	void testGiveBoardFromCharArray_whenToCharArray_thenIsEqualCharArray() {
		String boardFromStr = "RRRRRRRYYYYYYYRRRRRRRYYYYYYYRRRRRRRYYYYYYY";
		Board board = new BoardSimpleBuilder().formString(boardFromStr).buid();
		String boardToStr = new String (board.toCharacterArray());
		assertEquals(boardFromStr, boardToStr);
	}

}
