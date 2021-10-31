package usantatecla.connect4.views.console;

import usantatecla.connect4.views.BoardView;
import usantatecla.connect4.views.ErrorView;
import usantatecla.connect4.views.MenuView;
import usantatecla.connect4.views.MessageView;
import usantatecla.connect4.views.PlayerView;
import usantatecla.connect4.views.ResumeView;
import usantatecla.connect4.views.StartView;
import usantatecla.connect4.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

	@Override
	public BoardView createBoardView() {
		return new BoardConsoleView();
	}

	@Override
	public PlayerView createPlayerView() {
		return new PlayerConsoleView();

	}

	@Override
	public ResumeView createResumeView() {
		return new ResumeConsoleView();
	}

	@Override
	public StartView createStartView() {
		return new StartConsoleView();
	}

	@Override
	public ErrorView createErrorView() {
		return new ErrorConsoleView();
	}

	@Override
	public MenuView createMenuView() {
		return new MenuConsoleView();
	}

	@Override
	public MessageView createMessageView() {
		return new MessageConsoleView();
	}

}
