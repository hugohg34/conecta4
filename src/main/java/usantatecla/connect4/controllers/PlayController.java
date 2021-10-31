package usantatecla.connect4.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import usantatecla.connect4.controllers.menu.ActionCommand;
import usantatecla.connect4.controllers.menu.CommandController;
import usantatecla.connect4.controllers.menu.RedoCommand;
import usantatecla.connect4.controllers.menu.UndoCommand;
import usantatecla.connect4.models.Message;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.views.MenuView;
import usantatecla.connect4.views.ViewFactory;
import usantatecla.utils.models.ClosedInterval;
import usantatecla.utils.models.Color;

public class PlayController extends CompositeController {

	MenuView menuView;

	public PlayController(Session session, ViewFactory viewFactory) {
		super(session, viewFactory);
		menuView = viewFactory.createMenuView();
		createComponentControllers();
	}

	public void control() {
		do {
			menu();
		} while (!this.isConnect4());
		viewFactory.createMessageView().show(Message.PLAYER_WIN, getActiveColor().name());
	}

	public void menu() {
		List<CommandController> commandsMenu = componentControllers.stream().map(c -> (CommandController) c)
				.filter(CommandController::isActive).collect(Collectors.toList());

		assert !commandsMenu.isEmpty();
		int option;
		do {
			writeMenu(commandsMenu);
			option = menuView.readOption() - 1;
		} while (!new ClosedInterval(0, commandsMenu.size() - 1).isIncluded(option));
		commandsMenu.get(option).control();
		writeBoard();
	}

	private boolean isConnect4() {
		return this.session.isConnect4();
	}

	private Color getActiveColor() {
		return this.session.getActiveColor();
	}

	private void writeMenu(List<CommandController> commandsMenu) {
		menuView.writeIntro();
		for (int i = 0; i < commandsMenu.size(); i++) {
			menuView.writeOption(i + 1, commandsMenu.get(i).getTitle());
		}
	}

	@Override
	void createComponentControllers() {
		this.componentControllers = new ArrayList<>();
		this.componentControllers.add(new ActionCommand(session, viewFactory));
		this.componentControllers.add(new UndoCommand(session, viewFactory));
		this.componentControllers.add(new RedoCommand(session, viewFactory));
	}

}
