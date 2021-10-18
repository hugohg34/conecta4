package connect4;

import controller.BaseController;
import controller.Logic;
import controller.PlayController;
import model.Game;
import view.ViewFactory;

public class Conecta4 {

	private ViewFactory viewFactory;
	private PlayController playController;
	private Game game;
	private Logic logic;

	Conecta4() {
		this.game = new Game();
		this.logic = new Logic();
	}

	public void play() {
		BaseController baseController = logic.getController();
		while (baseController != null) {
			baseController.accept(this.viewFactory);	
		}
	}

	public static void main(String[] args) {
		new Conecta4().play();
	}

}
