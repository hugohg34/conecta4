package usantatecla.connect4.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameMementoTest {
	
	@Test
	void given_GameAndGameFromMemento_whenPutToken_thenEqualGames() {
		int[] putTokens = {0,2,4,5,6,1,3,5};
		Game game = creteGameWithPutTokens(putTokens);
		GameMemento gameMemento = createGameMementoWithPutTokens(putTokens);
		Game gameFromMemento = new Game();
		gameFromMemento.setMemento(gameMemento);
		assertEquals(game, gameFromMemento);
	}

	private GameMemento createGameMementoWithPutTokens(int[] colums) {
		Board board = new Board();
		Turn turn = new Turn(board);
		for(int i = 0; i < colums.length; i++) {
			turn.putToken(colums[i]);
		}
		return new GameMemento(board, turn);
	}
	
	private Game creteGameWithPutTokens(int[] colums) {
		Game game = new Game();
		for(int i = 0; i < colums.length; i++) {
			game.putToken(colums[i]);
		}
		return game;
	}

}
