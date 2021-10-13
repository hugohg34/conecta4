package view;

import model.DiscDrop;
import types.DiscColor;

public interface DiscDropView {

	DiscDrop read(DiscColor color);

	void showInvaidDropping();

}