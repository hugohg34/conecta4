package usantatecla.connect4.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.utils.models.Color;

class PlayerTest {

	private Board board;

	Player player;

	@BeforeEach
	void beforEach() {
		this.board = new Board();
	}

	@Test
	void testGivenNewPlayer_whenNullBoard_thenAssertionError() {
		assertThrows(AssertionError.class, () -> new Player(Color.NULL, null));
	}

	@Test
	void testGivenNewPlayer_whenNullColor_thenAssertionError() {
		assertThrows(NullPointerException.class, () -> cretatePlayer(null));
	}

	@Test
	void testGivenNewPlayer_whenColorNULL_thenAssertionError() {
		assertThrows(AssertionError.class, () -> cretatePlayer(Color.NULL));
	}

	@Test
	void testGivenNewPlayer_whenColorRed_thenEqualsGetColor() {
		this.player = cretatePlayer(Color.RED);
		assertEquals(Color.RED, this.player.getColor());
	}

	@Test
	void testGivenNewPlayer_whenColorYellow_thenEqualsGetColor() {
		this.player = cretatePlayer(Color.YELLOW);
		assertEquals(Color.YELLOW, this.player.getColor());
	}

	@Test
	void testGivenPlayer_whenputToken_thendelegateBoard() {
		this.board = spy(new Board());
		this.player = cretatePlayer(Color.RED);
		int column = 5;
		this.player.putToken(column);
		verify(board).putToken(column, this.player.getColor());
	}

	private Player cretatePlayer(Color color) {
		return new Player(color, this.board);
	}

}
