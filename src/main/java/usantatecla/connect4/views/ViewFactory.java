package usantatecla.connect4.views;

public abstract class ViewFactory {

	public abstract BoardView createBoardView();

	public abstract MenuView createMenuView();

	public abstract PlayerView createPlayerView();

	public abstract ResumeView createResumeView();

	public abstract StartView createStartView();

	public abstract ErrorView createErrorView();

	public abstract MessageView createMessageView();

}
