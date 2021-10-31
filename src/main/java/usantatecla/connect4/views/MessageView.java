package usantatecla.connect4.views;

import usantatecla.connect4.models.Message;

public interface MessageView {

	void show(Message message);

	void show(Message message, String player);

}
