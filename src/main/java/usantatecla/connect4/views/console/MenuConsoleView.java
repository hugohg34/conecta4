package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.MenuView;
import usantatecla.utils.views.Console;

public class MenuConsoleView implements MenuView {

	@Override
	public void writeIntro() {
		Console.getInstance().writeln(Message.OPTION.toString());
	}

	@Override
	public void writeOption(int code, String value) {
		Console.getInstance().writeln("[" + code + "] " + value);
	}

	@Override
	public int readOption() {
		return Console.getInstance().readInt("");
	}

}
