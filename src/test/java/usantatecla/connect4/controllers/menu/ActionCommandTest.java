package usantatecla.connect4.controllers.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.PlayerView;
import usantatecla.connect4.views.ViewFactory;

class ActionCommandTest {

	private Session session;
	private PlayerView playerView;
	private ActionCommand actionCommand;

	@BeforeEach
	void beforeEach() {
		this.session = spy(new Session());
		this.playerView = mock(PlayerView.class);
		ViewFactory viewFactory = mock(ViewFactory.class);
		when(viewFactory.createPlayerView()).thenReturn(playerView);
		this.actionCommand = new ActionCommand(session, viewFactory);
	}

	@Test
	void testGivenActionCommand_whenPlayerViewReadCol_thenCallSessionPutTokeColIndex() {
		int col = 2;
		int colIndex = col - 1;
		when(this.playerView.readColum()).thenReturn(col);
		ArgumentCaptor<Integer> column = ArgumentCaptor.forClass(Integer.class);
		
		this.actionCommand.control();
		verify(this.session).putToken(column.capture());
		
		assertEquals(column.getValue(), colIndex);
	}

	@Test
	void testGivenActionCommand_when_readColumn_thenCallSessionNext() {
		int col = 2;
		when(this.playerView.readColum()).thenReturn(col);
		
		this.actionCommand.control();
		
		verify(this.session).next();
	}

}
