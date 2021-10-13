package view;

public abstract class ViewFactory {
	protected BoardView boardView;
	protected WinnerView winnerView;
	protected EndGameView endGameView;

	public BoardView getBoardView() {
		return this.boardView;
	}

	public WinnerView getWinnerView() {
		return this.winnerView;
	}

	public EndGameView getEndGameView() {
		return this.endGameView;
	}

}