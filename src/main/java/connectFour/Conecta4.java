package connectFour;

import controller.BaseController;
import controller.Logic;
import view.ViewFactory;
import view.console.ConsoleViewFactory;

public class Conecta4 {

	private ViewFactory viewFactory;
	private Logic logic;

	Conecta4() {
		this.logic = new Logic();
		viewFactory = new ConsoleViewFactory();
	}

	public void play() {
		BaseController baseController = logic.getController();
		while (baseController != null) {
			baseController.accept(this.viewFactory);	
			baseController = logic.getController();
		}
		
	}

	public static void main(String[] args) {
		new Conecta4().play();
	}

}
