package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.PlayerView;
import usantatecla.utils.views.BoundedIntDialog;

public class PlayerConsoleView implements PlayerView {

	@Override
	public int readColum() {
		return new BoundedIntDialog(1, 7).read(Message.ENTER_COLUMN_TO_PUT.toString());
	}

}
