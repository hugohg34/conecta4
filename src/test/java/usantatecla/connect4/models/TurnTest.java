package usantatecla.connect4.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.utils.models.Color;

class TurnTest {

	private Turn turn;

	@BeforeEach
	void beforeEach() {
		this.turn = new Turn(new Board());
	}

	@Test
	void givenCurrentPlayer_whenNextTurn_thenPlayerColorNotEquals() {
		Color currentColor = this.turn.getActiveColor();
		this.turn.next();
		assertNotEquals(currentColor, this.turn.getActiveColor());
	}

	@Test
	void givenCurrentPlayer_whenNextTurn_thenPlayerNotEqual() {
		Player currentPlayer = this.turn.getActivePlayer();
		this.turn.next();
		assertNotEquals(currentPlayer, this.turn.getActivePlayer());
	}

}
