package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.MessageView;
import usantatecla.utils.views.Console;

class MessageConsoleView implements MessageView {

	@Override
	public void show(Message message) {
		Console.getInstance().write(message.toString());
	}

	public void writeln(Message message) {
		Console.getInstance().writeln(message.toString());
	}

	@Override
	public void show(Message message, String player) {
		Console.getInstance().writeln(message.toString().replaceAll("#player", "" + player));
	}

}
