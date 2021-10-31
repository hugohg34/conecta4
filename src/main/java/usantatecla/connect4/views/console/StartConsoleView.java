package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.StartView;

class StartConsoleView implements StartView {

	@Override
	public void show() {
		new MessageConsoleView().show(Message.TITLE);
	}

}
