package controller;

import model.Board;
import model.DiscDrop;
import model.Game;
import model.State;
import types.DiscColor;

public class PlayController extends BaseController {
	
	public PlayController(Game game, State state) {
		super(game, state);
	}

	public boolean isEndGame() {
		return this.game.isFull() || isWinnerPlay();
	}

	public boolean isWinnerPlay() {
		return this.game.isFourInLine();
	}

	public Board getBoard() {
		return this.game.getBoard();
	}

	public DiscColor getColor() {
		return this.game.getColor();
	}

	public boolean isValidDropping(DiscDrop discDrop) {
		return this.game.isValidDropping(discDrop);
	}

	public void dropping(DiscDrop discDrop) {
		this.game.dropping(discDrop);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		// TODO Auto-generated method stub
		
	}

}