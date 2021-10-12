package view.console;

public class ViewFactory {
	
	private BoardView boardView;
	private WinnerView winnerView;
	private EndGameView endGameView;
	
	public ViewFactory(){
		this.boardView =  new BoardView();
		this.winnerView = new WinnerView();
		this.endGameView = new EndGameView();	
	}

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
