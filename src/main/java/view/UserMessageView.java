package view;

import utils.Console;

public class UserMessageView {

	public void showError(String string) {
		Console.getInstance().printError(string);
	}
	
	public void show(String string) {
		Console.getInstance().println(string);
	}
}
